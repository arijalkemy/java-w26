# Enunciado
Se necesita desarrollar un API para buscar por nombre o parte del mismo personajes de Star Wars. La misma va a recibir una palabra a buscar y retorna un listado de personajes que contengan esa palabra en su nombre.

Ejemplo:

- Si buscamos "Luke" ->  nos mostrará el personaje de "Luke Skywalker"
- Si buscamos "Darth" -> nos mostrará el personaje de "Darth Vader" y "Darth Maul".

Tendremos una sola entidad llamada Personaje, con los siguientes atributos:

- name
- height
- mass
- hairColor
- skinColor
- eyeColor
- birthYear
- gender
- homeworld
- species

Todos los atributos serán de tipo String, excepto height y mass que serán de tipo entero.


Del personaje, se desea ver todos los atributos menos hairColor, skinColor, eyeColor y birthYear.


Nota: Por el momento no se utilizará ninguna conexión de base de datos, así que utilizaremos el archivo starwars.json como base de datos. Tratar de aplicar la arquitectura multicapa donde sea posible hacerlo.


## Endpoints 🖥️

### Obtener los personajes por nombre

    Ruta: http:localhost:8080/character/{name}
    PathVariable: name: nombre del personaje
    Codigos de respuesta: 200
    Escenario de respuesta: 
    200 -> Responde los personajes que coincidan con ese nombre
    204 -> No encontró personajes que coincidan con ese nombre

#### Posibles peticiones
    Petición: http:localhost:8080/character/luke 
    ResponseCode: 200 
    ResponseBody: 
    [
        {
            "name": "Luke Skywalker",
            "height": 172,
            "mass": 77,
            "gender": "male",
            "homeworld": "Tatooine",
            "species": "Human"
        }
    ]

    Petición: http:localhost:8080/character/dar
    ResponseCode: 200 
    ResponseBody: 
    [
        {
            "name": "Darth Vader",
            "height": 202,
            "mass": 136,
            "gender": "male",
            "homeworld": "Tatooine",
            "species": "Human"
        },
        {
            "name": "Biggs Darklighter",
            "height": 183,
            "mass": 84,
            "gender": "male",
            "homeworld": "Tatooine",
            "species": "Human"
        },
        {
            "name": "Darth Maul",
            "height": 175,
            "mass": 80,
            "gender": "male",
            "homeworld": "Dathomir",
            "species": "Zabrak"
        }
    ]

### Obtener todos los personajes

    Ruta: http:localhost:8080/characters/
    Codigos de respuesta: 200
    Escenario de respuesta: 
    200 -> Responde el deporte que coincide con el nombre

#### Posibles peticiones
    Petición: http:localhost:8080/characters/ 
    ResponseCode: 200 
    ResponseBody: 
    [
        {
            "name": "Luke Skywalker",
            "height": 172,
            "mass": 77,
            "gender": "male",
            "homeworld": "Tatooine",
            "species": "Human"
        },...
    ]

