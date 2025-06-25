package br.com.alura.NomeProjeto.model;

// Importa as anotações do Jackson para mapear o JSON
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Ignora campos desconhecidos que não estão mapeados no record
@JsonIgnoreProperties(ignoreUnknown = true)
public record Receita(
        // Mapeia o campo "strMeal" do JSON para o nome da receita
        @JsonAlias("strMeal") String nome,

        // Mapeia a imagem da receita (miniatura)
        @JsonAlias("strMealThumb") String image,

        // Mapeia o ID da receita
        @JsonAlias("idMeal") String id,

        // Mapeia o campo que traz as instruções da receita
        @JsonAlias("strInstructions") String instrucoes
) {}
