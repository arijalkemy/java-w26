# Enunciado

Un conocido Youtuber desea crear un servicio REST para manejar un blog. Dentro del blog, se pueden realizar varias operaciones y algunas de ellas pueden generar excepciones. Éstas últimas deben tratarse de una manera adecuada y devolver mensajes breves y significativos en caso de que ocurran, dado que si esto no sucede, el Youtuber puede perder seguidores.


Se debe crear una entidad llamada “EntradaBlog” con los siguientes atributos:

- Id del blog.
- Título del blog.
- Nombre del autor.
- Fecha de publicación.

La API debe ser capaz de:

1. Crear una nueva entrada de Blog y devolver un mensaje adecuado diciendo que ha sido creada correctamente mostrando su “Id”. (URI: /blog).
En el caso de que ya exista una entrada de blog con ese “Id”, capturar la excepción y devolver un mensaje indicando dicha situación.

2. Devolver la información de una entrada de Blog específico, recibiendo el “Id” del mismo. (URI: /blog/{id}).
Si el “Id” ingresado no corresponde a ninguna entrada de Blog, indicarlo con un mensaje adecuado.

3. Devolver el listado de todas las entradas de blogs existentes. (URI: /blogs).

Implementar las clases de excepciones personalizadas que hagan falta.

Manejar el tratamiento de las excepciones utilizando alguno de los métodos vistos.


Nota: Como repositorio para guardar información se puede utilizar un HashMap<Integer, BlogDTO> o un List<BlogDTO>.

## Endpoints 🖥️

### Crear un nuevo blog

    Ruta: http:localhost:8080/blog - POST
    Body: 
        {
            "id": Integer,
            "title": String,
            "authorName": String,
            "postDate": "yyyy-MM-dd"
        }
    Codigos de respuesta: 200, 409
    Escenario de respuesta: 
    200 -> Responde que fue creado el recurso
    409 -> Responde cuando se intenta crear un blog con un id ya existente

#### Posibles peticiones
    Petición: http:localhost:8080/blog 
    RequestBody: 
    {
        "id": 1,
        "title": "Prueba de titulo",
        "authorName": "Daniel",
        "postDate": "2024-04-18"
    }
    ResponseCode: 200 
    ResponseBody: 
    1
    --- Repitiendo la petición
    Petición: http:localhost:8080/blog 
    RequestBody: 
    {
        "id": 1,
        "title": "Prueba de titulo",
        "authorName": "Daniel",
        "postDate": "2024-04-18"
    }
    ResponseCode: 409 
    ResponseBody: 
    {
        "message": "El blog con id:1 ya existe"
    }
    

### Obtener todas las entradas del blog

    Ruta: http:localhost:8080/blogs
    Codigos de respuesta: 200, 204 
    Escenario de respuesta: 
    200 -> Responde la lista de todas las entradas de blog
    204 -> Responde cuando no hay ningúna entrada de blog registrad

#### Posibles peticiones
    Petición: http:localhost:8080/blogs
    ResponseCode: 200 
    ResponseBody: 
    [
        {
            "id": 1,
            "title": "Prueba de titulo",
            "authorName": "Daniel",
            "postDate": "2024-04-18"
        },
        {
            "id": 2,
            "title": "Prueba",
            "authorName": "Daniel",
            "postDate": "2024-04-18"
        }
    ]


    Petición: http:localhost:8080/blogs
    ResponseCode: 204 


### Obtener un blog por id

    Ruta: http:localhost:8080/blog/{id}
    PathParams: id: id del blog a buscar    Codigos de respuesta: 200
    Codigos de respuesta: 200, 404
    Escenario de respuesta: 
    200 -> Responde entrada del blog
    404 -> Responde cuando se busca un blog inexistente

#### Posibles peticiones
    Petición: http:localhost:8080/blog/1
    ResponseCode: 200 
    ResponseBody: 
    {
        "id": 1,
        "title": "Prueba de titulo",
        "authorName": "Daniel",
        "postDate": "2024-04-18"
    }

    Petición: http:localhost:8080/blog/12
    ResponseCode: 404 
    ResponseBody: 
    {
        "message": "El blog con el id: 12 no existe"
    }