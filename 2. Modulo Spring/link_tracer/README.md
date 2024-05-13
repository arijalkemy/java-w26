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

    Ruta: http:localhost:8080/new - POST
    Body: 
        {
            "link": "https://github.com"
        }
    Codigos de respuesta: 200
    Escenario de respuesta: 
    200 -> Responde que fue creado el recurso

#### Posibles peticiones
    Petición: http:localhost:8080/new 
    RequestBody: 
    {
        "link": "https://github.com",
        "password": "abc123"
    }
    ResponseCode: 200 
    ResponseBody: 
    {
        "id": 1,
        "link": "https://github.com"
    }
    
    --- Repitiendo la petición
    Petición: http:localhost:8080/new 
    RequestBody: 
    {
        "link": "https://github.com",
    }
    ResponseCode: 200 
    ResponseBody: 
    {
        "id": 1,
        "link": "https://github.com"
    }


### Redirigir al link

    Ruta: http:localhost:8080/redirect/{id}
    Codigos de respuesta: 404, 301-200
    Escenario de respuesta: 
    301 - 200 -> Responde con la página correspondiente al link proporcionado
    404 -> Responde cuando el enlace no es válido

#### Posibles peticiones
    Petición: http:localhost:8080/redirect/1
    ResponseCode: 301 - 200
    ResponseBody: 
    
    Html correspondiente a la página


    Petición: http:localhost:8080/redirect/2
    ResponseCode: 404 
    ResponseBody:
    {
        "message":"La url no es válida"
    }

    Petición: http:localhost:8080/redirect/2?password='wrong pass'
    ResponseCode: 404 
    ResponseBody:
    {
        "message":"La clave no es correcta"
    }

    Petición: http:localhost:8080/redirect/2?password='wrong pass'
    ResponseCode: 404 
    ResponseBody:
    {
        "message":"El link está deshabilitado"
    }

    Petición: http:localhost:8080/redirect/99999
    ResponseCode: 404 
    ResponseBody:
    {
        "message":"El link con id: 99999 no existe"
    }


### Deshabilitar el link

    Ruta: http:localhost:8080/invalidate/{id}
    PathParams: id: id del blog a buscar    
    Codigos de respuesta: 200, 404
    Escenario de respuesta: 
    200 -> Responde cuando se invalida un enlace
    404 -> Responde cuando se trata de invalidar un link inexistente

#### Posibles peticiones
    Petición: http:localhost:8080/invalidate/1
    ResponseCode: 200 
    ResponseBody: 
    {
    }

    Petición: http:localhost:8080/invalidate/99999
    ResponseCode: 404 
    ResponseBody: 
    {
        "message":"El link con id: 99999 no existe"
    }

### Metricas de un link

    Ruta: http:localhost:8080/metrics/{id}
    PathParams: id: id del blog a buscar    
    Codigos de respuesta: 200, 404
    Escenario de respuesta: 
    200 -> Responde con las metricas de un enlace
    404 -> Responde cuando se trata de invalidar un link inexistente

#### Posibles peticiones
    Petición: http:localhost:8080/metrics/1
    ResponseCode: 200 
    ResponseBody: 
    {
        "link": "https://github.com/",
        "metrics": 2
    }

    Petición: http:localhost:8080/metrics/99999
    ResponseCode: 404 
    ResponseBody: 
    {
        "message":"El link con id: 99999 no existe"
    }