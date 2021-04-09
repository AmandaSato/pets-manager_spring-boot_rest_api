
API (Application Programming Interface) é o conjunto de 
requisições que permite a comunicação de dados entre 
aplicações. As operações básicas para manipulação de dados 
é realizada através de requisições HTTP.

REST (Representational State Transfer) é um padrão de 
integração entre aplicações.

REST API é uma API que utiliza a arquitetura REST.

Critérios para que uma API seja considerada RESTful:

- Ter uma arquitetura cliente/servidor formada por 
  clientes, servidores e recursos, com solicitações 
  gerenciadas por meio de HTTP. 
  
  
- Realizar comunicação cliente/servidor "stateless". 
  Isso significa que cada solicitação é separada e 
  não conectada com outras, e que nenhuma informação 
  do cliente é armazenada entre elas.
  
    
- Armazenar dados em cache para otimizar as interações
  entre cliente e servidor. 
  
  
- Ter uma interface uniforme entre os componentes para 
  que as informações sejam transferidas em um 
  formato padronizado. Para tanto, é necessário que:
  - os recursos solicitados sejam identificáveis e 
    estejam separados das representações enviadas ao 
    cliente;
  - os recursos possam ser manipulados pelo cliente por 
    meio da representação recebida com informações 
    suficientes para tais ações;
  - as mensagens autodescritivas retornadas ao cliente 
    contenham informações suficientes para descrever como
    processá-las;
  - hipermídia seja incorporada. Isso significa que após
    acessar um recurso, o cliente precisa ser capaz de 
    usar hiperlinks para encontrar todas as demais 
    ações disponíveis para ele no momento. 
    

- Ter um sistema em camadas que organiza os tipos de 
  servidores (responsáveis pela segurança, pelo 
  carregamento de carga e assim por diante) envolvidos 
  na recuperação das informações solicitadas em 
  hierarquias que o cliente não pode ver.
  Possibilitar código sob demanda (opcional): a 
  capacidade de enviar do servidor para o cliente um 
  código executável quando solicitado, a fim de ampliar 
  as funções do cliente. 
  
Teste da API

http://localhost:8080/api/v1/pets

POST:

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

{
"id": 2,
"petName": "Bartolomeu",
"breed": "Pug",
"petWeight": "05,00kg",
"ownerName": "Mikaela",
"cpf": "369.333.878-79",
"petBirthDate": "2017-01-01",
"phones": [
{
"id": 2,
"type": "MOBILE",
"number": "(11)999999998"
}
]
}

{
"id": 3,
"petName": "Pandora",
"breed": "Chitsu",
"petWeight": "06,10kg",
"ownerName": "Roberto",
"cpf": "856.693.500-49",
"petBirthDate": "2012-01-01",
"phones": [
{
"id": 3,
"type": "MOBILE",
"number": "(11)999999997"
}
]
}

GET:
http://localhost:8080/api/v1/pets
http://localhost:8080/api/v1/pets/1
http://localhost:8080/api/v1/pets/2
http://localhost:8080/api/v1/pets/3

PUT:



