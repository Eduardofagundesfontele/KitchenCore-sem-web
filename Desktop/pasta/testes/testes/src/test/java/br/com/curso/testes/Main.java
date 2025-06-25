package br.com.curso.testes;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.UpperCase;



// Tudo precisa estar dentro desta classe
public class Main {
    public static void main(String[] args) {
  // // Expressão lambda que verifica se um número é primo

        Conversor conversor = a -> a.toUpperCase();


        String teste = "teste";
        System.out.println( conversor.converter(teste));
    }
}
