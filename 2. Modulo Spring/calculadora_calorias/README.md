# Enunciado
Un restaurante desea poder ofrecer a sus potenciales comensales la posibilidad de conocer los ingredientes y calorías de cada uno de los platos que se encuentran en su menú. Para esto, necesita el desarrollo de una API que a partir de la recepción de un plato del menú (brindando nombre y peso en gramos) sea capaz de retornar:

- Cantidad total de calorías del plato
- Lista de ingredientes que lo conforman y cantidad de calorías de cada uno de ellos
- El ingrediente con mayor cantidad de calorías

Bonus: Por otra parte, el dueño del restaurante está interesado en la posibilidad de que sus clientes, además de enviar plato por plato, puedan enviar una lista de platos y obtener estos mismos puntos diferenciados por cada uno de los platos brindados.


Para facilitar toda esta tarea, el dueño facilitó el archivo food.json como base de datos a ser utilizada.
## Endpoints 🖥️

### Obtener las calorias de un plato

    Ruta: http:localhost:8080/calories/{plateName}
    PathVariable: plateName: nombre de un plato
    Codigos de respuesta: 200
    Escenario de respuesta: 
    200 -> Responde la cantidad total de calorias de un plato 

#### Posibles peticiones
    Petición: http:localhost:8080/calories/Arroz con pollo 
    ResponseCode: 200 
    ResponseBody: 1760
    

### Obtener la lista de ingredientes de un plato por su nombre

    Ruta: http:localhost:8080/ingredients/{plateName}
    PathVariable: plateName: nombre de un plato
    Codigos de respuesta: 200
    Escenario de respuesta: 
    200 -> Responde la lista de ingredientes de un plato

#### Posibles peticiones
    Petición: http:localhost:8080/ingredients/Arroz con pollo
    ResponseCode: 200 
    ResponseBody: 
    {
        "name": "Arroz con pollo",
        "ingredients": [
            {
                "name": "Pollo",
                "calories": 268,
                "weigth": 200
            },
            {
                "name": "Arroz blanco",
                "calories": 1486,
                "weigth": 420
            },
            {
                "name": "Pimiento",
                "calories": 2,
                "weigth": 10
            },
            {
                "name": "Zanahoria",
                "calories": 4,
                "weigth": 10
            }
        ]
    }

### Obtener el ingrediente con más calorias de un plato

    Ruta: http:localhost:8080/maxCalories/{plateName}
    Codigos de respuesta: 200
    Escenario de respuesta: 
    200 -> Responde el ingrediente con mas calorias de un plato

#### Posibles peticiones
    Petición: http:localhost:8080/maxCalories/Arroz con pollo
    ResponseCode: 200 
    ResponseBody: 
    {
    "name": "Arroz blanco",
    "calories": 354
    }
### Bonus - Obtener el listado de ingredientes y las calorias de un plato recibiendo una lista de nombre de platos

    Ruta: http:localhost:8080/platesCalories/{platesNames}
    Codigos de respuesta: 200
    Escenario de respuesta: 
    200 -> Responde una lista de platos, con sus respectivos ingredientes y calorias totales del plato

#### Posibles peticiones
    Petición: http:localhost:8080/platesCalories/Arroz con pollo, Pasta con pollo
    ResponseCode: 200 
    ResponseBody: 
    [
        {
            "name": "Arroz con pollo",
            "ingredients": [
                {
                    "name": "Pollo",
                    "calories": 268,
                    "weigth": 200
                },
                {
                    "name": "Arroz blanco",
                    "calories": 1486,
                    "weigth": 420
                },
                {
                    "name": "Pimiento",
                    "calories": 2,
                    "weigth": 10
                },
                {
                    "name": "Zanahoria",
                    "calories": 4,
                    "weigth": 10
                }
            ],
            "totalCalories": 1760
        },
        {
            "name": "Pasta con pollo",
            "ingredients": [
                {
                    "name": "Pollo",
                    "calories": 268,
                    "weigth": 200
                },
                {
                    "name": "Pasta al huevo",
                    "calories": 1545,
                    "weigth": 420
                },
                {
                    "name": "Nata o crema de leche",
                    "calories": 29,
                    "weigth": 10
                },
                {
                    "name": "Bacon (Panceta ahumada)",
                    "calories": 665,
                    "weigth": 100
                }
            ],
            "totalCalories": 2507
        }
    ]