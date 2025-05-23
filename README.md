# CadastroAPI - Sistema de Cadastro de Ninjas e Missões
Bem-vindo ao CadastroAPI, uma API RESTful desenvolvida em Java com Spring Boot para gerenciamento de ninjas e missões, inspirada no universo do anime Naruto. Este projeto implementa um CRUD (Create, Read, Update, Delete) simples, permitindo o cadastro, consulta, atualização e exclusão de ninjas e missões, ideal para aprendizado e prática de desenvolvimento de APIs.
## Sobre o Projeto
O CadastroAPI é um sistema backend que simula o gerenciamento de ninjas (como nome, vila, rank) e missões (como descrição, tipo, nível de dificuldade) no contexto do anime Naruto. A API foi projetada para ser simples, mas funcional, utilizando boas práticas de desenvolvimento com Spring Boot e integração com banco de dados MySQL.
## Funcionalidades
Gerenciamento de Ninjas:
Criação de novos ninjas com atributos como nome, vila e rank.

Listagem de todos os ninjas cadastrados.

Atualização de informações de ninjas existentes.

Exclusão de ninjas.

## Gerenciamento de Missões:
Criação de missões com detalhes como descrição, tipo (ex.: rank D, C, B, A, S) e nível de dificuldade.

Listagem de todas as missões.

Atualização de missões existentes.

Exclusão de missões.

## Tecnologias Utilizadas
Java 17: Linguagem principal do projeto.

Spring Boot 3.2.5: Framework para construção da API RESTful.

Spring Data JPA: Para mapeamento objeto-relacional e interação com o banco de dados.

MySQL: Banco de dados relacional para persistência de dados.

Maven: Gerenciador de dependências e build.

Lombok: Para redução de código boilerplate.

## Pré-requisitos
Para executar o projeto localmente, você precisará de:
Java JDK 17 ou superior.

Maven 3.8+.

MySQL (versão 8.0 ou superior) instalado e configurado.

Git para clonar o repositório.

Uma ferramenta para testar APIs, como Postman ou Insomnia.

## Configuração do Ambiente
Siga os passos abaixo para configurar e executar a API:
Clone o repositório:
```bash

git clone https://github.com/Alencar7/CadastroAPI.git
```
## Acesse o diretório do projeto:
```bash

cd CadastroAPI
```
## Configure o banco de dados:
Crie um banco de dados MySQL chamado cadastroapi:
```sql

CREATE DATABASE cadastroapi;
```
Atualize o arquivo src/main/resources/application.properties com as credenciais do seu banco de dados:
```properties

spring.datasource.url=jdbc:mysql://localhost:3306/cadastroapi?useSSL=false&serverTimezone=UTC
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
Compile e execute a aplicação:
```bash

mvn clean install
mvn spring-boot:run
```
A API estará disponível em http://localhost:8080.

## Endpoints Principais
A API fornece os seguintes endpoints para interação:

| Método | Endpoint                | Descrição                        |
|--------|-------------------------|----------------------------------|
| GET    | /api/ninjas             | Lista todos os ninjas.           |
| GET    | /api/ninjas/{id}        | Retorna um ninja por ID.         |
| POST   | /api/ninjas             | Cria um novo ninja.              |
| PUT    | /api/ninjas/{id}        | Atualiza um ninja existente.     |
| DELETE | /api/ninjas/{id}        | Exclui um ninja por ID.          |

**Exemplo de corpo para POST/PUT (Ninja)**:
```json

{
  "name": "Naruto Uzumaki",
  "village": "Konoha",
  "rank": "Genin"
}
```
### Missões

| Método | Endpoint                | Descrição                        |
|--------|-------------------------|----------------------------------|
| GET    | /api/missions           | Lista todas as missões.          |
| GET    | /api/missions/{id}      | Retorna uma missão por ID.       |
| POST   | /api/missions           | Cria uma nova missão.            |
| PUT    | /api/missions/{id}      | Atualiza uma missão existente.   |
| DELETE | /api/missions/{id}      | Exclui uma missão por ID.        |

**Exemplo de corpo para POST/PUT (Missão)**:
```json
{
  "description": "Escoltar comerciante até Vila da Areia",
  "type": "C",
  "difficulty": "Média"
}

```

## Testando a API
Para testar os endpoints, utilize ferramentas como Postman ou Insomnia. Certifique-se de que a API está rodando localmente (http://localhost:8080) e envie requisições com os formatos JSON apropriados.
Exemplo de teste com cURL para criar um ninja:
```bash

curl -X POST http://localhost:8080/api/ninjas \
-H "Content-Type: application/json" \
-d '{"name":"Naruto Uzumaki","village":"Konoha","rank":"Genin"}'
```
