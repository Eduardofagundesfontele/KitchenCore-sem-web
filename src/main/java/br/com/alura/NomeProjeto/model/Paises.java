package br.com.alura.NomeProjeto.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
// Classe que representa uma receita individual da lista
public record Paises(
        @JsonAlias("strArea") String pais

) {
    // Sobrescreve toString para imprimir os dados de forma legível
    @Override
    public String toString() {
        return "🍽 Pais: " + pais ;

    }
}

