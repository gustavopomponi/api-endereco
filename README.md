
# API Endereço

A API de endereço possui a funcionalidade de efetuar a busca dos dados de endereço a partir de um CEP fornecido.

A aplicação foi desenvolvida utilizando uma arquitetura clean, com ênfase em manter o código limpo, legível e reutilizável, conforme os princípios do Clean Code.

O mecanismo de funcionamento da aplicação foi estruturado com base em um sistema de cache. Quando uma consulta de CEP é realizada, a aplicação inicialmente verifica a base de dados local. Caso o CEP não seja encontrado, a consulta é realizada a uma API externa, cujo retorno é armazenado na base local, acompanhado de um registro em uma base de logs, e o resultado é então retornado pela API.

Nas consultas subsequentes, ao identificar a existência do CEP na base local, a aplicação registra a operação no log e retorna o resultado diretamente da base local, sem a necessidade de realizar uma nova requisição à API externa.

O objetivo dessa abordagem é reduzir a quantidade de chamadas externas, tornando o processo de consulta mais eficiente e rápido, especialmente em cenários com alta demanda para o mesmo CEP.



## Autores

- [@gustavopomponi](https://www.github.com/gustavopomponi)


## Rodando localmente

Clone o projeto

```bash
  https://github.com/gustavopomponi/api-endereco.git
```

Entre no diretório do projeto

```bash
  cd api-endereco
```

Faça o build da imagem de container da aplicação

```bash
  docker build -t  teste-santander .
```

Inicie a stack da aplicação

```bash
  docker compose up -d
```


## Documentação da API

#### Retorna os dados do endereço

```http
  GET /api/v1/endereco/{cep}
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `cep` | `string` | **Obrigatório**. O CEP que se deseja consultar |




## Uso/Exemplos

http://localhost:8080/api/v1/endereco/04617001

Código de Retorno: 200 OK

Payload de resposta:
```JSON
{
    "cep": "04617000",
    "logradouro": "Rua Vieira de Morais",
    "complemento": "até 0430 - lado par",
    "bairro": "Campo Belo",
    "localidade": "São Paulo",
    "uf": "SP",
    "unidade": "",
    "ibge": "3550308",
    "gia": "1004"
}
```



## Stack utilizada

**Infraestrutura:** Git, Docker

**Back-end:** Java, Spring Boot

**Database:** PostreSQL, MongoDB

