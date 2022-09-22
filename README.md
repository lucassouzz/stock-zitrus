### Spring Boot

Desafio Backend:
● Construir uma aplicação RESTful para controle de estoque com no mínimo duas
entidades, como por exemplo: Produto e Movimento Estoque.

Tecnologia:
● Java Spring Boot
O mínimo esperado da aplicação:
● Boas práticas de desenvolvimento e clean code;
● CRUD - (Create, Read, Update, Delete) de produtos;
● Efetuar entrada e saída dos produtos no estoque. É importante validar o saldo ao
efetuar uma saída do produto, caso não haja quantidade suficiente, deve ser retornado
uma mensagem específica;
● Consulta de produtos por tipo, com quantidade de saída e quantidade disponível;
● Consulta de lucro por produto, exibindo a quantidade total de saída, e total do lucro
(valor de venda – valor do fornecedor).

###Observação: 
Foi implementado autenticação via Json Web Token, neste caso para que seja possível realizar as requisições do API é necessário a geração do token
por meio do login (/user/login) passando o usuário já pre-cadastrado no banco de dados H2 conforme arquivo import.sql

#### Documentação básica:
[- Visualizar documentação.](https://documenter.getpostman.com/view/14768065/2s7ZEBm1aQ)
