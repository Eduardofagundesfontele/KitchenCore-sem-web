package br.com.alura.NomeProjeto.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// Implementação da interface para converter JSON em objetos usando Jackson
public class ConverterDados implements IconverteDados {

    // Objeto da biblioteca Jackson para fazer a conversão
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        try {
            // Converte o JSON para um objeto da classe informada
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            // Se der erro na conversão, lança exceção com mensagem detalhada
            throw new RuntimeException("Erro ao converter JSON para a classe: " + classe.getSimpleName(), e);
        }
    }
}
