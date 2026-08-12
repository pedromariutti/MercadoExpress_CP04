# MercadoExpress_CP04

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.0-brightgreen)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-21-orange)](https://adoptium.net/)
[![Oracle](https://img.shields.io/badge/Oracle-Database-red)](https://www.oracle.com/br/database/)
[![Lombok](https://img.shields.io/badge/Lombok-1.18.30-purple)](https://projectlombok.org/)
[![HATEOAS](https://img.shields.io/badge/HATEOAS-Nível%203-blue)](https://restfulapi.net/hateoas/)

## Sobre o Projeto

Esse é um sistema de gestão para uma empresa do tipo Mercado Express. A aplicação implementa um CRUD completo (Create, Read, Update, Delete) para o gerenciamento de produtos, utilizando Spring Boot e integração com banco de dados Oracle.

O projeto foi desenvolvido seguindo os princípios do HATEOAS (Nível 3 de Maturidade de Richardson) e utiliza o Lombok para reduzir a verbosidade do código, garantindo um código mais limpo.

---

## Tecnologias Utilizadas

### Backend
| Tecnologia | Versão | Descrição |
|------------|--------|-----------|
| **Java** | 21 | Linguagem de programação |
| **Spring Boot** | 4.1.0 | Framework principal |
| **Spring Data JPA** | 4.1.0 | Persistência com JPA/Hibernate |
| **Spring HATEOAS** | 4.1.0 | Implementação do Nível 3 de Richardson |
| **Spring Validation** | 4.1.0 | Validação de dados com Bean Validation |
| **Spring Web MVC** | 4.1.0 | API REST com Spring MVC |
| **Oracle JDBC** | 11.x | conexão com Oracle Database |
| **Lombok** | 1.18.30 | Redução de código boilerplate |
| **SpringDoc OpenAPI** | 3.1.0 | Swagger |

### Ferramentas
- **Maven** - Gerenciamento de dependências
- **Insomnia/Postman** - Testes de API
- **Oracle SQL Developer** - Gerenciamento do banco de dados
- **Git/GitHub** - Controle de versão

### SPRING INITIALIZR
<img width="1027" height="880" alt="SpringInitializr" src="https://github.com/user-attachments/assets/2e4ad4b6-69c8-4f8f-9eda-909b746fd4a1" />

### Deploy realizado no RENDER
<img width="944" height="898" alt="deploy_live" src="https://github.com/user-attachments/assets/cefd4597-fe61-4ed7-96b4-7b9c2a066a27" />

---

## Configuração e Instalação

### Pré-requisitos

- JDK 21 ou superior
- Maven 3.8+ instalado
- Acesso a uma instância do Oracle Database (Oracle_FIAP)
- Insomnia ou Postman para testar os endpoints
- Git (opcional, para clonar o repositório)

### Passos para rodar o projeto localmente

1. **Clone o repositório:**
   ```
   git clone https://github.com/pedromariutti/MercadoExpress_CP04.git
   cd MercadoExpress_CP04
   ```

2. Configure o banco de dados no arquivo src/main/resources/application.properties:

# Altere as variáveis abaixo conforme suas credenciais
spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl
spring.datasource.username=SEU_RM_AQUI
spring.datasource.password=SUA_SENHA_AQUI

3. Execute o projeto com Maven:
mvn clean spring-boot:run

4. Acesse a aplicação:

API: https://mercadoexpress-cp04.onrender.com

Swagger UI: https://mercadoexpress-cp04.onrender.com/swagger-ui/index.html

OpenAPI Docs: https://mercadoexpress-cp04.onrender.com/v3/api-docs

## Endpoints da API
A API segue o padrão RESTful e está documentada com HATEOAS. Todos os endpoints retornam links para navegação entre os recursos.

| Método | Endpoint | Descrição | Corpo da Requisição |
|--------|----------|-----------|---------------------|
| **POST** | `/mercado` | Adiciona um novo produto | ✅ JSON |
| **GET** | `/mercado` | Lista todos os produtos | ❌ |
| **GET** | `/mercado/{id}` | Busca um produto pelo ID | ❌ |
| **PUT** | `/mercado/{id}` | Atualiza completamente um produto | ✅ JSON |
| **PATCH** | `/mercado/{id}` | Atualiza parcialmente um produto | ✅ JSON |
| **DELETE** | `/mercado/{id}` | Remove um produto pelo ID | ❌ |

# Testes com Insomnia/Postman

1 - PUT
<img width="680" height="819" alt="PUT1" src="https://github.com/user-attachments/assets/7f2a4a3c-11c4-43e0-b396-9b42d152bf54" />

2 - POST
<img width="664" height="951" alt="POST1" src="https://github.com/user-attachments/assets/d3126211-f0b0-46fd-aa02-a734773a0e87" />


3 - DELETE
<img width="673" height="342" alt="DELETE1" src="https://github.com/user-attachments/assets/39f5a7d8-9801-4fa8-87b9-58321ceb3dd5" />
<img width="673" height="455" alt="DELETE2_ConfirmandoDelete" src="https://github.com/user-attachments/assets/7f34647a-430e-4f41-a8ab-27da7a32d87c" />


4 - GET 
<img width="678" height="920" alt="GET1" src="https://github.com/user-attachments/assets/ddc7bb0e-b39e-45fd-a88d-500177bb5362" />
<img width="678" height="657" alt="GET2_ID" src="https://github.com/user-attachments/assets/744b7b84-b694-4d28-b4a5-0dbb470951de" />

5 - PATCH
<img width="678" height="818" alt="PATCH1" src="https://github.com/user-attachments/assets/0e1a1dd7-465c-43ea-84e0-43751f673221" />
