// === Principal.java ===
package br.com.alura.NomeProjeto.Principal;

import br.com.alura.NomeProjeto.model.Dados;
import br.com.alura.NomeProjeto.model.DadosReceita;
import br.com.alura.NomeProjeto.model.Paises;
import br.com.alura.NomeProjeto.model.Receita;
import br.com.alura.NomeProjeto.service.ConsumoApi;
import br.com.alura.NomeProjeto.service.ConverterDados;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {

    Scanner scanner = new Scanner(System.in);

    // URLs das APIs
    private final String ENDERECO_PAISES = "https://www.themealdb.com/api/json/v1/1/list.php?a=list";
    private final String ENDERECO_RECEITAS_POR_PAIS = "https://www.themealdb.com/api/json/v1/1/filter.php?a=";
    private final String ENDERECO_RECEITA_DETALHES = "https://www.themealdb.com/api/json/v1/1/search.php?s=";

    private ConsumoApi consumo = new ConsumoApi();
    private ConverterDados conversor = new ConverterDados();

    public void exibeMenu() {
        // Exibe todos os países disponíveis
        System.out.println("\uD83C\uDF0D Países disponíveis:");
        String jsonPaises = consumo.obterDados(ENDERECO_PAISES);
        Dados dadosPaises = conversor.obterDados(jsonPaises, Dados.class);
        List<Paises> listaPaises = dadosPaises.meals();

        // Lista os países
        listaPaises.forEach(p -> System.out.println("\u2022 " + p.pais()));

        // Pede ao usuário o nome do país
        System.out.print("\nDigite o nome do país: ");
        String pais = scanner.nextLine();

        // Busca as receitas do país
        String jsonReceitas = consumo.obterDados(ENDERECO_RECEITAS_POR_PAIS + URLEncoder.encode(pais, StandardCharsets.UTF_8));
        DadosReceita dadosReceita = conversor.obterDados(jsonReceitas, DadosReceita.class);
        List<Receita> listaReceitas = dadosReceita.meals();

        if (listaReceitas == null || listaReceitas.isEmpty()) {
            System.out.println("\u274C Nenhuma receita encontrada para o país informado.");
            return;
        }

        // Mostra as receitas do país
        System.out.println("\n\uD83C\uDF7D Receitas encontradas:");
        listaReceitas.forEach(r -> System.out.println("\u2022 " + r.nome()));

        // Permite digitar parte do nome de uma receita
        System.out.print("\nDigite parte do nome da receita que deseja ver as instruções: ");
        String trechoNome = scanner.nextLine().toLowerCase();

        // Filtra a primeira receita que contenha esse trecho
        Optional<Receita> receitaEncontrada = listaReceitas.stream()
                .filter(r -> r.nome().toLowerCase().contains(trechoNome))
                .findFirst();

        if (receitaEncontrada.isPresent()) {
            String nomeReceita = receitaEncontrada.get().nome();
            String urlDetalhes = ENDERECO_RECEITA_DETALHES + URLEncoder.encode(nomeReceita, StandardCharsets.UTF_8);
            String jsonDetalhes = consumo.obterDados(urlDetalhes);
            DadosReceita detalhes = conversor.obterDados(jsonDetalhes, DadosReceita.class);
            Receita receitaCompleta = detalhes.meals().get(0);

            // Exibe as instruções da receita
            System.out.println("\n\uD83D\uDCCB Instruções da receita: " + receitaCompleta.nome() );
            System.out.println(receitaCompleta.image());
            System.out.println(receitaCompleta.instrucoes());
        } else {
            System.out.println("\u274C Nenhuma receita encontrada com esse nome.");
        }

        scanner.close();
    }
}
