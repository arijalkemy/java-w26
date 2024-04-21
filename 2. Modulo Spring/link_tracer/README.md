# Enunciado
Link Tacker es un sistema para trackear/enmascarar URLs y poder obtener analítica de cuantas veces se llamó a cada uno de los links, así como también agregar reglas de negocio para el funcionamiento del redirect.

Se pide desarrollar una aplicación utilizando Spring Boot con Maven que soporte los siguientes casos de uso:

1. Crear un link: Endpoint POST para crear link a partir de una URL válida y tiene que devolver un JSON con el linkId para utilizar en la redirección.
2. Redirección:  Dado un link (ej: http://localhost:8080/link/{linkId} ) tiene que realizar un redirect a la URL enmascarada. Siempre y cuando el link sea válido. En el caso de que el link sea invalido devolver 404(INVESTIGAR REDIRECT).
3. Estadísticas por link: Endpoint GET que dado un link (ej: http://localhost:8080/metrics/{linkID} ) tiene que devolver la estadística de cantidad de veces que se redireccionó.
4. Invalidate link: Endpoint POST para invalidar un link (ej: http://localhost:8080/invalidate/{linkID} ).
5. Al crear los links se tiene que poder agregar un password que va a ser un query param al llamar a la redirección.

Nota: Repositorio a utilizar para guardar información, puede ser un HashMap<Integer, LinkDTO> o un List<LinkDTO>.

## Endpoints 🖥️

### Crear un nuevo link

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