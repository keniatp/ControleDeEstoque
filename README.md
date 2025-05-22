# API de Controle de Estoque

Projeto desenvolvido em parceria com **Ian Saldanha** ([@031Iansz](https://github.com/031Iansz)), utilizando **Spring Boot**, com o objetivo de criar uma API REST para gerenciar o controle de estoque de produtos.

## Estrutura do Banco de Dados
### Tabela: `usuario`
| Campo    | Tipo | Descrição       |
| -------- | ---- | --------------- |
| id       | int  | Identificador   |
| nome     | str  | Nome do usuário |
| endereco | str  | Endereço        |
| setor    | str  | Setor           |

### Tabela: `produtos`
| Campo      | Tipo | Descrição              |
| ---------- | ---- | ---------------------- |
| id         | int  | Identificador          |
| nome       | str  | Nome do produto        |
| quantidade | int  | Quantidade em estoque  |
| status     | str  | Disponível/Indisponível|

### Tabela: `saida`
| Campo            | Tipo | Descrição                     |
| ---------------- | ---- | ----------------------------- |
| id               | int  | Identificador                 |
| data             | str | Data da saída                 |
| id_usuario       | int  | Usuário que realizou a saída  |
| id_produto       | int  | Produto retirado              |
| quantidade_saida | int  | Quantidade retirada           |
