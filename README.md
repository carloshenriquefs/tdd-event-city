# :construction: - Desafio: Tdd-Eventy-City

* Desenvolvimento TDD de API Rest com Java e Spring Boot;
* Implementação de cenários de busca, inserção, deleção e atualização;
* Tratamento de exceções em API com respostas HTTP customizadas;

##

## :clipboard: - Diagrama:

![tdd drawio](https://github.com/carloshenriquefs/tdd-event-city/assets/54969405/3105cb1b-5bc1-4965-84d9-39f292da0e6d)

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
