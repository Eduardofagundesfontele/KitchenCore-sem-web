package br.com.alura.NomeProjeto.service;

// Interface que define um contrato para converter JSON em objetos Java
public interface IconverteDados {
    // Método genérico que recebe um JSON e a classe para qual deve converter,
    // e retorna o objeto convertido do tipo T.
    <T> T obterDados(String json, Class<T> classe);
}
