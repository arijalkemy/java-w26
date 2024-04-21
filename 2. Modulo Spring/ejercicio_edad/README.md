# Enunciado
Se necesita desarrollar un API que recibe como parámetro tres valores:

 - Día 
 - Mes 
 - Año

Dichos valores corresponden a la fecha de nacimiento de una persona y deben ser valores enteros. Por ejemplo, un ingreso válido sería: 10/01/1990.

Para este caso, es necesario que la fecha de nacimiento se pase mediante la URL del navegador. Por ejemplo: http://localhost:8080/10/01/1990. Como resultado, la API deberá devolver la edad de la persona.

## Endpoints 🖥️

### Calcular la edad de una persona

    Ruta: http:localhost:8080/api/edad/{dia}/{mes}/{anio} 
    PathVariable: code: Mensaje encriptado
    Codigos de respuesta: 200, 400
    Escenario de respuesta: 
    200 -> Responde la edad de la persona
    400 -> Responde bad request, posibles errores, tratar de calcular una edad con una fecha inexistente

#### Posibles peticiones
    Petición: http:localhost:8080/api/edad/23/10/1997 
    ResponseCode: 200 
    ResponseBody: 26

    Petición: http:localhost:8080/api/edad/23/14/1997
    ResponseCode:  400
    ResponseBody: -1

    Petición: http:localhost:8080/api/edad/23/10/2025
    ResponseCode:  400
    ResponseBody: -1
