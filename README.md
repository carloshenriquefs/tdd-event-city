# :construction: - Desafio: TDD-Event-City

* Desenvolvimento TDD de API Rest com Java e Spring Boot;
* Implementação de cenários de busca, inserção, deleção e atualização;
* Tratamento de exceções em API com respostas HTTP customizadas;

##

## :clipboard: - Diagramas:

![tdd drawio](https://github.com/carloshenriquefs/tdd-event-city/assets/54969405/3105cb1b-5bc1-4965-84d9-39f292da0e6d)

![seed drawio](https://github.com/carloshenriquefs/tdd-event-city/assets/54969405/ab837811-3290-465d-80b3-f1261732ea13)

##

## :gear: - Endpoint's:

#### :house: - City:

``GET:`` <br />
* findById(id){} <br />
* findAllName(){}

``POST:`` <br />
* insert(){}
    
``DELETE:`` <br />
* delete(id){}

##

#### :microphone: - Event:

``PUT:`` <br />
* update(id){}

##

## :hourglass: - Tests:

#### :house: - City:

    - findAllShouldReturnAllResourcesSortedByName(){}
    - insertShouldInsertResource(){}
    - deleteShouldReturnNoContentWhenIndependentId(){}
    - deleteShouldReturnNotFoundWhenNonExistingId(){}

##

#### :microphone: - Event:

    - updateShouldUpdateResourceWhenIdExists(){}
    - updateShouldReturnNotFoundWhenIdDoesNotExists(){}

##

### :white_check_mark: - Critérios:

## 

- [x] - DELETE /cities/{id} deve retornar 404 Not Found quando id não existir;
- [x] - DELETE /cities/{id} deve retornar 204 No Content quando id for independente;
- [x] - DELETE /cities/{id} deve retornar 400 Bad Request quando id for dependente;
- [x] - POST /cities deve inserir recurso;
- [x] - GET /cities deve retornar recursos ordenados por nome;
- [x] - PUT /events deve atualizar recurso quando id existir;
- [x] - PUT /events deve retornar 404 Not Found quando id não existir;   
