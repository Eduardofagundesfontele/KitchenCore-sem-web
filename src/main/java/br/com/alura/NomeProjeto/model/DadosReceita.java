package br.com.alura.NomeProjeto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosReceita(List<Receita> meals) {}

