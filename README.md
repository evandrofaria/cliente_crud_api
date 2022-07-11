# Cliente - API

Foi construído uma API para persistir operações no banco de dados, utilizado Java com Spring e banco de dados
PostgreSQL.

## Iniciando o servidor da API

* **Importe o banco de dados [PostgreSQL](postgres.sql) com as seguintes configurações**:

```
Database: postgres
Username: postgres
Senha: postgres
```

### Acessando a API

| Método | Endpoint                                | Ação                                           | Exemplo                                                    |
|--------|-----------------------------------------|------------------------------------------------|------------------------------------------------------------|
| GET    | **/usuarios**                           | Retorna todos os usuários                      | `http://localhost:8080/usuarios`                           |
| GET    | **/usuarios/{id}**                      | Retorna usuário específico                     | `http://localhost:8080/usuarios/{id}`                      |
| GET    | **/usuarios/{id}/emails**               | Retorna os emails do usuário                   | `http://localhost:8080/usuarios/{id}/emails`               |
| GET    | **/usuarios/{id}/telefones**            | Retorna os telefones do usuário                | `http://localhost:8080/usuarios/{id}/telefones`            |
| PUT    | **/usuarios/{id}/dados-basicos/editar** | Atualiza dados básicos do usuário específico   | `http://localhost:8080/usuarios/{id}/dados-basicos/editar` |
| PUT    | **/usuarios/{id}/telefones/editar**     | Atualiza telefones do usuário específico       | `http://localhost:8080/usuarios/{id}/telefones/editar`     |
| PUT    | **/usuarios/{id}/emails/editar**        | Atualiza emails do usuário específico          | `http://localhost:8080/usuarios/{id}/emails/editar`        |
| POST   | **/usuarios/{id}/emails/incluir**       | Cadastra novo email para usuário específico    | `http://localhost:8080/usuarios/{id}/emails/incluir`       |
| POST   | **/usuarios/{id}/telefones/incluir**    | Cadastra novo telefone para usuário específico | `http://localhost:8080/usuarios/{id}/telefones/incluir`    |

### Acessando a aplicação

* **Para acessar a aplicação como administrador**:

```
CPF: 12312312387
Senha: 123456
```

* **Para acessar a aplicação como usuário comum**:

```
CPF: 12312312388
Senha: 123456
```
