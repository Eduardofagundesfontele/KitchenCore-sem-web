package br.com.alura.NomeProjeto.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
// Classe que representa o objeto raiz do JSON retornado pela API
public record Dados(
        // O JSON tem um campo "meals" que é uma lista de receitas
        @JsonAlias("meals") List<Receita> meals
) {}
