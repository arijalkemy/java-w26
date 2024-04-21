# Enunciado
El Código Morse permite codificar cada caracter del abecedario como una secuencia de
"puntos" y "guiones". Por ejemplo, la letra A se codifica como · -, la letra Q se codifica como
−− · - y el dígito 1 se codifica como · −−−−.

El código Morse no distingue entre mayúsculas y minúsculas, sin embargo sus traducciones
tradicionalmente se muestran en letras mayúsculas. Cuando el mensaje está escrito en
código Morse, se usa un solo espacio para separar los códigos de caracteres y se usan 3
espacios para separar palabras

1. Se solicita llevar a cabo un API que reciba un Codigo Morse y devuelva su
   traducción en español. Tener como referencia del significado de cada símbolo la
   siguiente tabla:
 
    | Letra | Valor en morse |
    |-------|----------------|
    | A     | .-             |
    | B     | -...           |
    | C     | -.-.           |
    | D     | -..            |
    | E     | .              |
    | F     | ..-.           |
    | G     | --.            |
    | H     | ....           |
    | I     | ..             |
    | J     | .---           |  
    | K     | -.-            |
    | L     | .-..           |
    | M     | --             |
    | N     | -.             |
    | O     | ---            |
    | P     | .--.           |
    | Q     | --.-           |
    | R     | .-.            |
    | S     | ...            |
    | T     | -              |
    | U     | ..-            |
    | V     | ...-           |
    | W     | .--            |
    | X     | -..-           |
    | Y     | -.--           |
    | Z     | --..           |
    | 1     | .----          |
    | 2     | ..---          |
    | 3     | ...--          |
    | 4     | ....-          |
    | 5     | .....          |
    | 6     | -....          |
    | 7     | --...          |
    | 8     | ---..          |
    | 9     | ----.          |
    | 0     | -----          |
    | ?     | ..--..         |
    | !     | -.-.--         |
    | .     | .-.-.-         |
    | ,     | --..--         |
    

## Endpoints 🖥️

### Convertir de Texto a morse

    Ruta: http:localhost:8080/api/morse/{code} 
    PathVariable: code: Mensaje encriptado
    Codigos de respuesta: 200, 400
    Escenario de respuesta: 
    200 -> Responde el texto codificado
    400 -> Responde bad request, posibles errores, tratar de convertir un caracter no controlado

#### Posibles peticiones
    Petición: http:localhost:8080/api/morse/mercado libre 
    ResponseCode: 200 
    ResponseBody: '-- . .-. -.-. .- -.. ---   .-.. .. -... .-. .'

    Petición: http:localhost:8080/api/morse/¿mercado libre?
    ResponseCode:  400
    ResponseBody: 'El texto tiene un caracter no controlado'

    Petición: http:localhost:8080/api/morse/mércado libre
    ResponseCode:  400
    ResponseBody: 'El texto tiene un caracter no controlado'

##  Convertir de código morse a texto

    Ruta: http:localhost:8080/api/text/{code}
    PathVariable: code: String que contiene el texto codificado en morse
    Codigos de respuesta: 200, 400
    Escenario de respuesta:
    200 -> Responde el texto decodificado
    400 -> Responde bad request, posibles errores, tratar de convertir un un caracter no controlado

#### Posibles peticiones
    Petición: http:localhost:8080/api/text/-- . .-. -.-. .- -.. ---   .-.. .. -... .-. . 
    ResponseCode: 200 
    ResponseBody: 'MERCADO LIBRE'

    Petición: http:localhost:8080/api/romano/--.... .-. -.-. .- -.. ---   .-.. .. -... .-. .
    ResponseCode:  400
    ResponseBody: 'El texto tiene un caracter no controlado'

    Petición: http:localhost:8080/api/romano/.......
    ResponseCode:  400
    ResponseBody: 'El texto tiene un caracter no controlado'
    
    

