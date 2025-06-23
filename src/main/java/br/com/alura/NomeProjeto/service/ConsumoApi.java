package br.com.alura.NomeProjeto.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// Classe responsável por consumir API via HTTP
public class ConsumoApi {

    // Método que recebe a URL da API e retorna o JSON recebido como String
    public String obterDados(String endereco) {
        // Cria um cliente HTTP (Java 11+)
        HttpClient client = HttpClient.newHttpClient();

        // Cria a requisição HTTP do tipo GET para a URL informada
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .GET()
                .build();

        try {
            // Envia a requisição e captura a resposta como String (JSON)
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Retorna o corpo da resposta, que é o JSON
            return response.body();
        } catch (IOException | InterruptedException e) {
            // Caso aconteça erro de rede ou interrupção, lança RuntimeException para parar a execução
            throw new RuntimeException("Erro ao consumir a API: " + endereco, e);
        }
    }
}
