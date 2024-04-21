# Enunciado
Hacer deporte es muy importante para la salud. Consideramos una persona deportista a aquella que realice algún tipo de actividad física de forma frecuente.

Para validar si una persona es deportista, se necesita una aplicación que permita relacionar dos entidades:


Persona, cuyos atributos serán:
- Nombre
- Apellido
- Edad

Deporte, cuyos atributos serán:
- Nombre
- Nivel

Nuestra aplicación deberá contar con la siguiente funcionalidad:


Ver todos los deportes que tenemos cargados.

- PATH: /findSports

Consultar si existe un deporte ingresando su nombre. De existir, se deberá mostrar el nivel del mismo. Utilizar la clase ResponseEntity para devolver la respuesta.

- PATH: /findSport/{name}

Visualizar a las personas deportistas. Queremos que se vea un listado con el nombre y el apellido de la persona y el nombre del deporte que realiza (no es necesario que se vea la edad ni el nivel del deporte realizado). Para este punto es importante valerse de un DTO.

- PATH: /findSportsPersons

## Endpoints 🖥️

### Obtener los deportes

    Ruta: http:localhost:8080/findSports
    Codigos de respuesta: 200
    Escenario de respuesta: 
    200 -> Responde los deportes con sus respectivos niveles

#### Posibles peticiones
    Petición: http:localhost:8080/findSports 
    ResponseCode: 200 
    ResponseBody: 
    [
        {
            "nombre": "Tenis",
            "nivel": "Amateur"
        },
        {
            "nombre": "Futbol",
            "nivel": "Profesional"
        },
        {
            "nombre": "Basketball",
            "nivel": "Semi-pro"
        },
        {
            "nombre": "Natación",
            "nivel": "Profesional"
        }
    ]

### Obtener un deporte por nombre

    Ruta: http:localhost:8080/findSport/{name}
    PathVariable: name: nombre del deporte
    Codigos de respuesta: 200
    Escenario de respuesta: 
    200 -> Responde el deporte que coincide con el nombre

#### Posibles peticiones
    Petición: http:localhost:8080/findSport/Futbol 
    ResponseCode: 200 
    ResponseBody: 
    {
        "nombre": "Futbol",
        "nivel": "Profesional"
    }

### Obtener todos los deportistas

    Ruta: http:localhost:8080/findSportsPersons
    Codigos de respuesta: 200
    Escenario de respuesta: 
    200 -> Responde la lista de deportistas

#### Posibles peticiones
    Petición: http:localhost:8080/findSportsPersons
    ResponseCode: 200 
    ResponseBody: 
    [
        {
            "nombre": "Pepito",
            "apellido": "Perez",
            "deporte": "Tenis"
        },
        {
            "nombre": "Armando",
            "apellido": "Casas",
            "deporte": "Futbol"
        },
        {
            "nombre": "Esteban",
            "apellido": "Quito",
            "deporte": "Basketball"
        },
        {
            "nombre": "Armando",
            "apellido": "Paredes",
            "deporte": "Natación"
        },
        {
            "nombre": "Daniela",
            "apellido": "Perez",
            "deporte": "Tenis"
        },
        {
            "nombre": "Natalia",
            "apellido": "Perez",
            "deporte": "Futbol"
        }
    ]
