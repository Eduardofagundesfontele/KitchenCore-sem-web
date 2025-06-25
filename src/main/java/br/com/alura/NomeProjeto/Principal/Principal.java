package br.com.alura.NomeProjeto.Principal;

// Importa os modelos de dados
import br.com.alura.NomeProjeto.model.DadosReceita;
import br.com.alura.NomeProjeto.model.Receita;
import br.com.alura.NomeProjeto.model.Dados;
import br.com.alura.NomeProjeto.model.Paises;

// Importa os serviços
import br.com.alura.NomeProjeto.service.ConsumoApi;
import br.com.alura.NomeProjeto.service.ConverterDados;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class Principal {

    // Scanner para entrada de dados do usuário
    Scanner scanner = new Scanner(System.in);

    // Endereços da API
    private final String ENDERECO_RECEITAS = "https://www.themealdb.com/api/json/v1/1/filter.php?a=";
    private final String ENDERECO_PAISES = "https://www.themealdb.com/api/json/v1/1/list.php?a=list";

    // Consumo da API e conversor de dados
    private ConsumoApi consumo = new ConsumoApi();
    private ConverterDados conversor = new ConverterDados();

    // Método principal
    public void exibeMenu() {

        // Exibe lista de países
        System.out.println("🌍 Países Disponíveis:");
        var jsonPaises = consumo.obterDados(ENDERECO_PAISES);
        Dados dadosPaises = conversor.obterDados(jsonPaises, Dados.class);
        List<Paises> listaPaises = dadosPaises.meals();

        for (Paises p : listaPaises) {
            System.out.println("• " + p.pais());
        }

        // Pergunta qual país o usuário quer
        System.out.print("\nDigite o país desejado exatamente como aparece acima: ");
        String pais = scanner.nextLine();

        // Busca receitas do país informado
        var jsonReceitas = consumo.obterDados(ENDERECO_RECEITAS + pais);
        DadosReceita dadosReceita = conversor.obterDados(jsonReceitas, DadosReceita.class);
        List<Receita> listaReceitas = dadosReceita.meals();

        if (listaReceitas == null || listaReceitas.isEmpty()) {
            System.out.println("❌ Nenhuma receita encontrada para o país: " + pais);
            return;
        }

        // Exibe as receitas encontradas
        System.out.println("\n🍽 Receitas encontradas para " + pais + ":");
        final int[] contador = {1};
        listaReceitas.forEach(r -> {
            System.out.println(contador[0] + " - " + r.nome());
            contador[0]++;
        });

        // Usuário escolhe uma receita
        System.out.print("\nDigite o nome da receita que deseja visualizar os detalhes: ");
        String nomeEscolhida = scanner.nextLine();

        try {
            // Codifica o nome para evitar erro na URL
            String nomeCodificado = URLEncoder.encode(nomeEscolhida, StandardCharsets.UTF_8.toString());

            // Monta URL para buscar os detalhes da receita
            String urlBuscaDetalhes = "https://www.themealdb.com/api/json/v1/1/search.php?s=" + nomeCodificado;

            // Busca JSON com detalhes
            var jsonDetalhes = consumo.obterDados(urlBuscaDetalhes);
            DadosReceita detalhes = conversor.obterDados(jsonDetalhes, DadosReceita.class);
            List<Receita> listaDetalhes = detalhes.meals();

            if (listaDetalhes == null || listaDetalhes.isEmpty()) {
                System.out.println("❌ Receita não encontrada: " + nomeEscolhida);
            } else {
                Receita receitaSelecionada = listaDetalhes.get(0);
                System.out.println("\n🍽 Receita: " + receitaSelecionada.nome());
                System.out.println("📋 Instruções:\n" + receitaSelecionada.instrucoes());
            }

        } catch (Exception e) {
            System.out.println("❌ Erro ao buscar detalhes da receita: " + e.getMessage());
        }

        // Fecha o scanner
        scanner.close();
    }
}
