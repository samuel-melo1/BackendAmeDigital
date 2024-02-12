# Challenge Backend API

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://shields.io/badge/MySQL-lightgrey?logo=mysql&style=plastic&logoColor=white&labelColor=blue)

Esse é um projeto construído com  **Java, Spring Boot, Spring JPA, MySQL como banco de dados e SWAGGER para documentação. .** 

A API foi desenvolvida com base em um desafio da empresa AmeDigital. Em resumo, consiste em uma API para o mundo incrivel de Star Wars. A API é responsável por criar os planetas do universo Star Wars e inserir as informações, como Nome, Clima e Tempo de cada planeta. Por fim, consiste também em um consumo da própria API do Star Wars, a https://swapi.co/ para que seja possível realizar a busca de em quantos filmes esse planeta criado apareceu. 


## Table of Contents

- [Instalaçao](#instalação)
- [Usabilidade](#usabilidade)
- [API Endpoints](#api-endpoints)
- [Banco de Dados](#banco-de-dados)
- [Contribuição](#contribuição)

## Instalação

1. Clone o repositório:

```bash
git clone https://github.com/samuel-melo1/BackendAmeDigital.git
```

2. Instale as dependencias com Maven em https://start.spring.io/

3. Instale [MySQL](https://www.mysql.com/downloads/)
4. Instale  [MySQL Extension](https://dev.mysql.com/doc/mysql-getting-started/en/)

## Usabilidade

1. Inicie a aplicação com o Maven
2. A API estará disponível em http://localhost:8080


## API Endpoints
A API possui os seguintes endpoints:

```markdown

POST /api/v1/savePlanet - Rota para registrar um novo planeta

GET /api/v1/listPlanets - Rota responsável por listar os planetas cadastrados

DELETE /api/v1/listByNome/{nome} - Rota para deletar um planeta por nome

POST /api/v1/listByID/{id_planet} - Rota responsável por listar um planeta por ID

POST /api/v1/deletePlanet/{id_planet} - Rota para deletar um planeta

```

**BODY**
```json
{
    "nome": "Naboo",
    "clima": "temperate",
    "terreno": "grassy hills, swamps, forests, mountains",
    "aparicoes": 11
}
```


## Banco de Dados
O projeto utiliza o [MySQL](https://dev.mysql.com/doc/mysql-getting-started/en/) como banco de dados. O necessário para ser utilizado é apenas criar o banco de dados, as tabelas serão criadas pelo JPA.

## Contribuição

Sugestões e/ou contribuições são bem-vindas! Se você encontrar qualquer questão ou tenha sugestões de melhorias, por favor, abra uma solicitação pull para o repositório. 


Ao contribuir para este projeto, siga o estilo de código existente, [commit conventions](https://www.conventionalcommits.org/en/v1.0.0/), e envie suas alterações em uma ramificação separada.
