# API REST de gerenciamento de Pets

## Descrição
API no padrão REST, desenvolvida com Spring-Boot, para cadastro e gerenciamento
de Pets. A aplicação suporta as requisições http: GET, PUT, POST e DELETE.

## Dados do cadastro
- Nome do Pet
- Tipo/Raça do Pet
- Peso do Pet
- Aniversário do Pet
- Nome do dono
- CPF do dono
- Números de contato do Dono (celular, residencial ou comercial)
  

## Exemplo de Utilização da API
Utilize uma plataforma para execução de testes de APIs e requisições HTTP  (ex:. [Postman](https://www.postman.com/)) para realizar os testes abaixo.


### POST: 
Criar novos cadastros.
```
http://localhost:8080/api/v1/pets
```


```JSON
{
  "petName":"Babi",
  "breed":"Maltês",
  "petWeight":"02,50kg",
  "ownerName":"Amanda",
  "cpf": "412.169.608-52",
  "petBirthDate":"03-04-2007",
  "phones": [{
    "type": "MOBILE",
    "number": "(11)999999999"
  }]
}
```
```JSON
{
  "petName": "Bartolomeu",
  "breed": "Pug",
  "petWeight": "05,00kg",
  "ownerName": "Mikaela",
  "cpf": "369.333.878-79",
  "petBirthDate": "01-01-2017",
  "phones": [{
    "type": "MOBILE",
    "number": "(11)999999998"
  }]
}
```
```JSON
{
  "petName": "Pandora",
  "breed": "Chitsu",
  "petWeight": "06,10kg",
  "ownerName": "Roberto",
  "cpf": "856.693.500-49",
  "petBirthDate": "01-01-2012",
  "phones": [{
    "type": "MOBILE",
    "number": "(11)999999997"
  }]
}
```

### GET:
Buscar todos os cadastros listados ou um cadastro específico, através do ID.
```
http://localhost:8080/api/v1/pets
```
```
http://localhost:8080/api/v1/pets/{id}
```


### PUT:
Corrigir o dado "Chitsu" para o nome correto "Shih Tsu" do cadastro de ID 3.

http://localhost:8080/api/v1/pets/3

```JSON
{
  "id": 3,
  "petName": "Pandora",
  "breed": "Shih Tsu",
  "petWeight": "06,10kg",
  "ownerName": "Roberto",
  "cpf": "856.693.500-49",
  "petBirthDate": "01-01-2012",
  "phones": [{
    "id": 3,
    "type": "MOBILE",
    "number": "(11)999999997"
  }]
}
```

### DELETE:
Deletar um cadastro através do ID.

```
http://localhost:8080/api/v1/pets/{id}
```

## Critérios de validação dos dados

**petName**: 
entre 2 e 100 caracteres.

**breed**:
entre 2 e 100 caracteres.

**petWeight**:
precisa seguir o formato: " 00,00kg ".

**ownerName**:
entre 2 e 100 caracteres.

**cpf**:
CPF válido com a pontuação correta.

**petBirthDate**:
precisa seguir o formato: " dd-mm-yyyy ".

**phones-type**:
uma das três opções: "MOBILE", "HOME", "COMMERCIAL".

**phones-number**:
entre 13 e 14 caracteres.


  


