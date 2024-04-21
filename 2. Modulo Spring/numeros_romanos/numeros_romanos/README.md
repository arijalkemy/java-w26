# Enunciado
Los romanos eran un grupo inteligente. Conquistaron la mayor parte de Europa y la
gobernaron durante cientos de años. Inventaron carreteras de hormigón y rectas e incluso
bikinis. Sin embargo, una cosa que nunca descubrieron fue el número cero. Esto hizo que
escribir y fechar historias extensas de sus hazañas fuera un poco más desafiante, pero el
sistema de números que se les ocurrió todavía está en uso hoy. Por ejemplo, la BBC usa
números romanos para fechar sus programas. 

Los romanos escribieron números usando letras: I, V, X, L, C, D, M. (observe que estas letras
tienen muchas líneas rectas y, por lo tanto, son fáciles de cortar en tabletas de piedra).

1. En este contexto se requiere desarrollar una API para convertir un número decimal a
   un número romano. Algunos casos de prueba:

```
    1 → I
    2 → II
    3 → III
    4 → IV
    5 → V
    7 → VII
    10 → X
    13 → XIII
    50 → L
    100 → C
    500 → D
    1000 → M
```

## Endpoints 🖥️

### Convertir de Número entero a número romano

    Ruta: http:localhost:8080/api/romano/{numero} 
    PathVariable: numero: Numero entero a convertir a número romano
    Codigos de respuesta: 200, 400
    Escenario de respuesta: 
    200 -> Responde el número convertido a número romano
    400 -> Responde bad request, posibles errores, tratar de convertir un número negativo o un número superior a 3999
    
#### Posibles peticiones
    Petición: http:localhost:8080/api/romano/1973 
    ResponseCode: 200 
    ResponseBody: 'MCMLXXIII'

    Petición: http:localhost:8080/api/romano/0
    ResponseCode:  400
    ResponseBody: 'No es posible convertir un número menor que 1'

    Petición: http:localhost:8080/api/romano/0
    ResponseCode:  400
    ResponseBody: 'No es posible convertir un número mayor que 3999'

##  Convertir de número romano a número entero

    Ruta: http:localhost:8080/api/numero/{romano}
    PathVariable: romano: String que contiene el número romano a convertir a número entero
    Codigos de respuesta: 200, 400
    Escenario de respuesta:
    200 -> Responde el número convertido a número entero
    400 -> Responde bad request, posibles errores, tratar de convertir un String no valido

#### Posibles peticiones
    Petición: http:localhost:8080/api/romano/MCMLXXIII 
    ResponseCode: 200 
    ResponseBody: 1997

    Petición: http:localhost:8080/api/romano/IXA
    ResponseCode:  400
    ResponseBody: -1

    Petición: http:localhost:8080/api/romano/XXXX
    ResponseCode:  400
    ResponseBody: -1
    
    

