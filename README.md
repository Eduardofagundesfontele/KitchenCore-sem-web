# 🍲 Encontrador de Receitas de Refeições

Este aplicativo Java permite explorar receitas de refeições de todo o mundo usando a API TheMealDB. Você pode listar os países disponíveis, visualizar receitas específicas de um país e, em seguida, obter instruções detalhadas para uma receita escolhida.

---

## ✨ Funcionalidades

* **Navegar por Países:** Veja uma lista de todos os países para os quais há receitas disponíveis.
* **Buscar Receitas por País:** Obtenha uma lista de receitas associadas a um país específico.
* **Ver Detalhes da Receita:** Digite parte do nome de uma receita para recuperar suas instruções completas e uma imagem.

---

## 🚀 Como Executar

Para executar este aplicativo, você precisará de:

* Java Development Kit (JDK) 11 ou mais recente
* Uma IDE como IntelliJ IDEA, Eclipse ou Visual Studio Code com extensões Java

### Passos:

1.  **Clonar o Repositório (ou copiar os arquivos):**
    Se este projeto estiver em um repositório Git, clone-o:
    ```bash
    git clone <url-do-repositorio>
    cd NomeProjeto
    ```
    Caso contrário, certifique-se de ter todos os arquivos Java (`.java`) na estrutura de pacotes correta (`br.com.alura.NomeProjeto`).

2.  **Compilar e Executar:**
    Navegue até a raiz do seu projeto (onde a pasta `src` está localizada) no seu terminal.

    * **Compilar:**
        ```bash
        javac -d out src/br/com/alura/NomeProjeto/Principal/Principal.java src/br/com/alura/NomeProjeto/model/*.java src/br.com.alura/NomeProjeto/service/*.java
        ```
        (Pode ser necessário ajustar o comando de compilação com base na estrutura exata do seu projeto, caso tenha mais arquivos ou pacotes aninhados além de `model` e `service`).

    * **Executar:**
        ```bash
        java -cp out br.com.alura.NomeProjeto.Main
        ```
        *(Nota: Você precisará de um arquivo `Main.java` com um método `main` para iniciar a classe `Principal`, ou pode chamar `Principal.exibeMenu()` diretamente de sua IDE, se ela suportar.)*

    **Alternativamente, se estiver usando uma IDE:**
    Abra o projeto em sua IDE e execute a classe `Main` (ou a classe que contém o método `main` que inicia `Principal.exibeMenu()`).

---

## 🛠️ Estrutura do Projeto

* `br.com.alura.NomeProjeto.Principal.Principal`: A classe principal que contém a lógica do aplicativo e a interação com o usuário.
* `br.com.alura.NomeProjeto.model.*`: Contém classes record (`Dados`, `DadosReceita`, `Paises`, `Receita`) para modelar os dados recebidos da API.
* `br.com.alura.NomeProjeto.service.ConsumoApi`: Lida com as requisições HTTP para a API externa.
* `br.com.alura.NomeProjeto.service.ConverterDados`: Gerencia a desserialização JSON para objetos Java.

---

## 🌐 API Utilizada

Este aplicativo consome dados da [API TheMealDB](https://www.themealdb.com/api.php).

* **Listar todos os países:** `https://www.themealdb.com/api/json/v1/1/list.php?a=list`
* **Filtrar por país:** `https://www.themealdb.com/api/json/v1/1/filter.php?a={nome_do_pais}`
* **Buscar por nome da refeição:** `https://www.themealdb.com/api/json/v1/1/search.php?s={nome_da_refeicao}`

---

## 🤝 Contribuição

Sinta-se à vontade para fazer um fork deste repositório, fazer melhorias e enviar pull requests.

---

## 📄 Licença

Este projeto é de código aberto e está disponível sob a [Licença MIT](LICENSE).
