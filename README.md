# Mini Trello API

Uma API RESTful desenvolvida com Java e Spring Boot para gerenciamento de tarefas, com autenticação baseada em JWT. 

## Tecnologias

- Java 
- Spring Boot 
- Spring Web
- Spring Data JPA
- Spring Security
- JWT 
- H2 Database 
- Jakarta EE

---

## Funcionalidades

### Público (sem autenticação):
- `POST /api/auth/register`: Criar um novo usuário
- `POST /api/auth/login`: Autenticar e obter um token JWT

### Protegido (requer token JWT):
- `POST /api/tarefas`: Criar nova tarefa
- `GET /api/tarefas`: Listar todas as tarefas
- `PUT /api/tarefas/{id}`: Atualizar status da tarefa
- `DELETE /api/tarefas/{id}`: Remover tarefa

---

## Autenticação

### 1. Registrar usuário
```http
POST /api/auth/register
Content-Type: application/json

{
  "username": "usuario",
  "password": "senha"
}
```

### 2. Login (gera token)
```http
POST /api/auth/login
Content-Type: application/json

{
  "username": "usuario",
  "password": "senha"
}
```

### 3. Usar token
Inclua no header das requisições:

```
Authorization: Bearer <seu-token-jwt>
```

---

## Exemplo de Tarefa

```json
{
  "titulo": "Estudar java",
  "descricao": "Ler documentação e praticar com projetos",
  "status": "PENDENTE"
}
```

---

## Banco de Dados

A aplicação usa **H2 em memória**. Acesse o console em:

- **URL:** `http://localhost:8080/h2-console`
- **JDBC URL:** `jdbc:h2:mem:testdb`
- **User:** `shrek`
- **Senha:** (em branco)

---

## Configurações importantes (`application.properties`)

```properties
# H2
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# JPA
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=shrek
spring.datasource.password=

# JWT
jwt.secret=seuSegredoSecreto1234567890
jwt.expiration=86400000  
```

---

## Como rodar o projeto

```bash
# Clone o repositório
git clone https://github.com/dcarm3/AtividadeGerenciadorDeTarefas

# Entre no diretório
cd mini-trello-api

# Compile e execute
./mvnw spring-boot:run
