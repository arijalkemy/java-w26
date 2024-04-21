# Enunciado

Una entidad de la salud necesita del desarrollo de una API para realizar consultas respecto a la salud de una persona teniendo en cuenta determinados síntomas que pueda presentar.

Para esto, tendremos dos clases:

- Persona, cuyos atributos serán:

  - id
  - nombre
  - apellido
  - edad

- Síntoma, cuyos atributos serán:
  - codigo
  - nombre
  - nivel_de_gravedad

Nuestra aplicación deberá contar con la siguiente funcionalidad:


- Ver todos los síntomas que tenemos cargados.
  - PATH: /findSymptom

- Consultar si existe un síntoma ingresando su nombre. De existir, se deberá mostrar el nivel de gravedad del mismo. Utilizar la clase ResponseEntity para devolver la respuesta.
  - PATH: /findSymptom/{name}

- Visualizar a las personas que puedan ser del grupo de riesgo. Para ello, necesitamos visualizar un listado con el nombre y el apellido de aquellas personas mayores de 60 años que puedan poseer al menos un síntoma asociado. Como para la respuesta de esta consulta habrá que tener en cuenta la relación entre las dos tablas, se recomienda utilizar el patrón DTO.
  - PATH: /findRiskPerson

Nota: Por el momento no se utilizará ninguna base de datos, por lo cual, los diferentes objetos se deben manejar mediante listas dinámicas (collections).

## Endpoints 🖥️

### Obtener la lista de sintomas registrados

    Ruta: http:localhost:8080/findSymptom
    Codigos de respuesta: 200
    Escenario de respuesta: 
    200 -> Responde la lista de sintomas 

#### Posibles peticiones
    Petición: http:localhost:8080/findSymptom
    ResponseCode: 200 
    ResponseBody: 
    [
      {
          "code": 1,
          "name": "Tos",
          "levelOfSeverity": "Alto"
      },
      {
          "code": 2,
          "name": "Fiebre",
          "levelOfSeverity": "Alto"
      },
      {
          "code": 3,
          "name": "Dificultad a respirar",
          "levelOfSeverity": "Severo"
      },
      {
          "code": 4,
          "name": "Fatiga",
          "levelOfSeverity": "Medio"
      },
      {
          "code": 5,
          "name": "Dolor de cabeza",
          "levelOfSeverity": "Bajo"
      },
      {
          "code": 6,
          "name": "Congestion",
          "levelOfSeverity": "Alto"
      },
      {
          "code": 7,
          "name": "Dolor de garganta",
          "levelOfSeverity": "Medio"
      }
    ]

### Obtener un sintoma en específico

    Ruta: http:localhost:8080/findSymptom/{name}
    PathVariable: name: Nombre del sintoma a buscar
    Codigos de respuesta: 200
    Escenario de respuesta: 
    200 -> Responde el sintoma con el nombre en cuestión

#### Posibles peticiones
    Petición: http:localhost:8080/findSymptom/Tos
    ResponseCode: 200 
    ResponseBody: 
    {
      "code": 1,
      "name": "Tos",
      "levelOfSeverity": "Alto"
    }

### Obtener personas que puedan ser de un grupo de riesgo

    Ruta: http:localhost:8080/findRiskPerson
    Codigos de respuesta: 200
    Escenario de respuesta: 
    200 -> Responde la lista de personas que tienen más de 60 años y poseen al menos un sintoma asociado

#### Posibles peticiones
    Petición: http:localhost:8080/findRiskPerson
    ResponseCode: 200 
    ResponseBody: 
    [
      {
          "name": "Manuel",
          "lastName": "Lopez",
          "age": 61,
          "symptoms": [
              {
                  "code": 1,
                  "name": "Tos",
                  "levelOfSeverity": "Alto"
              },
              {
                  "code": 3,
                  "name": "Dificultad a respirar",
                  "levelOfSeverity": "Severo"
              },
              {
                  "code": 4,
                  "name": "Fatiga",
                  "levelOfSeverity": "Medio"
              }
          ]
      },
      {
          "name": "Sofia",
          "lastName": "Sanchez",
          "age": 65,
          "symptoms": [
              {
                  "code": 1,
                  "name": "Tos",
                  "levelOfSeverity": "Alto"
              }
          ]
      }
    ]

