# Projeto EPI

Backend para o aplicativo de gerenciamento de EPI, desenvolvido em Kotlin utilizando o framework Spring Boot.

## Tecnologias Utilizadas

- **Linguagem:** [Kotlin](https://kotlinlang.org/)
- **Framework:** [Spring Boot](https://spring.io/projects/spring-boot)
- **Segurança:** [Spring Security](https://spring.io/projects/spring-security) com [JWT (JSON Web Tokens)](https://jwt.io/)
- **Banco de Dados:** [H2 Database](https://www.h2database.com/html/main.html) (em memória para desenvolvimento)
- **Build:** [Apache Maven](https://maven.apache.org/)
- **API:** RESTful

## Como Executar o Projeto

### Pré-requisitos

- JDK 21 ou superior
- Apache Maven

### Passos

1.  **Clone o repositório:**
    ```bash
    git clone <url-do-repositorio>
    cd app_unisinos_mobile
    ```

2.  **Execute o projeto com o Maven Wrapper:**
    - No Linux/macOS:
      ```bash
      ./mvnw spring-boot:run
      ```
    - No Windows:
      ```bash
      mvnw.cmd spring-boot:run
      ```

A aplicação estará disponível em `http://localhost:8080`.

## Endpoints da API

A seguir estão os endpoints disponíveis na aplicação.

### Autenticação

-   **`POST /auth/login`**
    -   Autentica um usuário e retorna um token JWT.
    -   **Request Body:**
        ```json
        {
          "email": "admin@admin.com",
          "password": "admin"
        }
        ```
    -   **Response (Sucesso):**
        ```json
        {
          "token": "seu.jwt.token.aqui"
        }
        ```

### Usuários

-   **`POST /user/create`**
    -   Cria um novo usuário.
    -   **Request Body:**
        ```json
        {
          "name": "Nome do Usuário",
          "email": "usuario@exemplo.com",
          "password": "senha123",
          "role": "DEFAULT"
        }
        ```

-   **`GET /user/{id}`**
    -   Busca um usuário pelo seu ID.
    -   **Requer Autenticação (Bearer Token)**

### Formulários

-   **`POST /form/register`**
    -   Registra um novo formulário.
    -   **Requer Autenticação (Bearer Token)**
    -   **Request Body:**
        ```json
        {
          "title": "Título do Formulário",
          "description": "Descrição detalhada do formulário."
        }
        ```

-   **`PUT /form/{idFormulario}/assinar`**
    -   Assina um formulário existente, vinculando-o a um usuário.
    -   **Requer Autenticação (Bearer Token)**
    -   **Request Body:**
        ```json
        {
          "userId": 1
        }
        ```

-   **`GET /form`**
    -   Retorna uma lista de todos os formulários cadastrados.
    -   **Requer Autenticação (Bearer Token)**

## Configuração de Segurança

A aplicação utiliza JWT para proteger os endpoints. Para acessar as rotas protegidas, é necessário enviar o token JWT no cabeçalho `Authorization` da requisição:

```
Authorization: Bearer <seu-token-jwt>
```