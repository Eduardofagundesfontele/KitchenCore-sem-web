package br.com.alura.NomeProjeto;

// Importa as classes que vamos usar para modelo e serviços
import br.com.alura.NomeProjeto.model.Dados;
import br.com.alura.NomeProjeto.service.ConsumoApi;
import br.com.alura.NomeProjeto.service.ConverterDados;

// Importa classes do Spring Boot para rodar a aplicação e executar código ao iniciar
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
		// Cria um objeto para consumir API externa
		var consumoApi = new ConsumoApi();

		// Define a URL da API que retorna receitas canadenses em JSON
		var url = "https://www.themealdb.com/api/json/v1/1/filter.php?a=Canadian";

		// Faz a requisição para a API e recebe o JSON como String
		var json = consumoApi.obterDados(url);

		// Exibe o JSON cru no console
		System.out.println(json);

		// Cria o conversor de JSON para objetos Java
		ConverterDados conversor = new ConverterDados();

		// Converte o JSON para objeto da classe Dados (que representa o JSON recebido)
		Dados dados = conversor.obterDados(json, Dados.class);

		// Exibe o objeto Dados convertido no console (de forma legível)
		System.out.println(dados);
	}
}
