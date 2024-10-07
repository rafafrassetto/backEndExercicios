# API REST - Sistema de Pagamento Pix

## Casos de Uso:
- Realizar uma transação Pix.
- Gerenciar usuários (chaves Pix e informações bancárias).

## Recursos:
- `transacoes`
- `usuarios`

### Endpoints para o recurso `transacoes`

| Descrição                         | URI                                 | Método HTTP | Corpo                                                                                  | Resposta Esperada | Erros esperados                                |
|------------------------------------|-------------------------------------|-------------|----------------------------------------------------------------------------------------|-------------------|-----------------------------------------------|
| Listar todas as transações         | `/transacoes`                       | `GET`       | Vazio                                                                                  | `200 OK`          | `404 Not Found` - Nenhuma transação encontrada. |
| Obter detalhes de uma transação    | `/transacoes/{transacao-id}`        | `GET`       | Vazio                                                                                  | `200 OK`          | `404 Not Found` - Transação não encontrada.    |
| Criar uma nova transação           | `/transacoes`                       | `POST`      | `{ "usuario_origem_id": "123", "usuario_destino_id": "456", "valor": 100.00 }`         | `201 Created`     | `400 Bad Request` - Dados inválidos.           |
| Atualizar os dados de uma transação| `/transacoes/{transacao-id}`        | `PUT`       | `{ "valor": 150.00 }`                                                                  | `200 OK`          | `404 Not Found` - Transação não encontrada.    |
| Deletar uma transação              | `/transacoes/{transacao-id}`        | `DELETE`    | Vazio                                                                                  | `200 OK`          | `404 Not Found` - Transação não encontrada.    |

### Endpoints para o recurso `usuarios`

| Descrição                        | URI                              | Método HTTP | Corpo                                                                | Resposta Esperada | Erros esperados                             |
|-----------------------------------|----------------------------------|-------------|----------------------------------------------------------------------|-------------------|--------------------------------------------|
| Listar todos os usuários          | `/usuarios`                      | `GET`       | Vazio                                                                | `200 OK`          | `404 Not Found` - Nenhum usuário encontrado.|
| Obter detalhes de um usuário      | `/usuarios/{usuario-id}`         | `GET`       | Vazio                                                                | `200 OK`          | `404 Not Found` - Usuário não encontrado.   |
| Criar um novo usuário             | `/usuarios`                      | `POST`      | `{ "nome": "João", "cpf": "123.456.789-00", "chave_pix": "email@x.com" }` | `201 Created`     | `400 Bad Request` - Dados inválidos.        |
| Atualizar os dados de um usuário  | `/usuarios/{usuario-id}`         | `PUT`       | `{ "chave_pix": "novoemail@x.com" }`                                 | `200 OK`          | `404 Not Found` - Usuário não encontrado.   |
| Deletar um usuário                | `/usuarios/{usuario-id}`         | `DELETE`    | Vazio                                                                | `200 OK`          | `404 Not Found` - Usuário não encontrado.   |
