package br.com.alura.NomeProjeto.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
// Classe que representa uma receita individual da lista
public record Receita(
        @JsonAlias("strMeal") String nome,
        @JsonAlias("strMealThumb") String imagem,
        @JsonAlias("idMeal") String id
) {
    // Sobrescreve toString para imprimir os dados de forma legível
    @Override
    public String toString() {
        return "🍽 Receita: " + nome + "\n" +
                "🖼 Imagem: " + imagem + "\n" +
                "🆔 ID: " + id + "\n";
    }
}

