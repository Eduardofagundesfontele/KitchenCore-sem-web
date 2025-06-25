package br.com.alura.NomeProjeto;

// Importa as classes que vamos usar para modelo e serviços
import br.com.alura.NomeProjeto.Principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Marca essa classe como aplicação Spring Boot
public class NomeProjetoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		// Método principal que inicia a aplicação Spring Boot
		SpringApplication.run(NomeProjetoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibeMenu();


	}
}
