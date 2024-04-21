# Enunciado
Una concesionaria de automóviles desea realizar un API REST que le permita realizar la carga de determinados autos usados. Para ello, necesitamos desarrollar los siguientes endpoints:

| N° | Endpoint                             | Método | Descripción                                                                |
|----|--------------------------------------|--------|----------------------------------------------------------------------------|
| 1  | v1/api/vehicles/                     | POST   | Agrega un nuevo vehículo.                                                  |
| 2  | v1/api/vehicles/                     | GET    | Retorna un listado de todos los usados seleccionados. No incluye services. |
| 3  | v1/api/vehicles/dates?since=’’to=’’  | GET    | Retorna el listado de los vehículos según fecha de fabricación.            |
| 4  | v1/api/vehicles/prices?since=’’to=’’ | GET    | Muestra el listado de los vehículos según los precios dados.               |
| 5  | v1/api/vehicles/{id}                 | GET    | Muestra toda la información relacionada con el vehículo.                   |

Dado que el dueño de la concesionaria es un cliente muy exigente, se sugiere realizar buenas prácticas de programación como por ejemplo la separación del proyecto según la Arquitectura Multicapas.

Tener en cuenta que por el momento, al no estar trabajando con bases de datos, podemos implementar collections (listas, arraylists, etc) para manejar los CRUD de manera lógica.

Por otro lado, un analista funcional nos proporciona el siguiente Payload de ejemplo para tener en cuenta a la hora de realizar un alta mediante el método POST:

```
    {
        "brand":"Chevrolet",
        "model":"Corsa",
        "manufacturingDate":"2000-11-20",
        "numberOfKilometers":"115000",
        "doors":"5",
        "price":"90000",
        "currency":"AR",
        "services":[
            {
                "date":"2003-05-20",
                "kilometers":"60000",
                "descriptions":"Change air filters"
            }
        ],
        "countOfOwners":"2"
    }
```

## Endpoints 🖥️

### Crear un nuevo vehiculo

    Ruta: http:localhost:8080/v1/api/vehicles/ - POST
    Body: 
        {
            "brand": String,
            "model": String,
            "manufacturingDate":Date,
            "numberOfKilometers":Long,
            "doors":Integer,
            "price":Long,
            "currency":String,
            "services":[
                {
                    "date":Date,
                    "kilometers":Long,
                    "descriptions":String
                }
            ],
            "countOfOwners":Integer
        }
    Codigos de respuesta: 201, 400
    Escenario de respuesta: 
    201 -> Responde que fue creado el recurso
    400 -> BadResponse si los datos no están completos

#### Posibles peticiones
    Petición: http:localhost:8080/v1/api/vehicles/ 
    RequestBody: 
    {
        "brand": "Chevrolet",
        "model": "Corsa",
        "manufacturingDate": "2000-11-20",
        "numberOfKilometers": "115000",
        "doors": "5",
        "price": "90000",
        "currency": "AR",
        "services": [
            {
                "date": "2003-05-20",
                "kilometers": "60000",
                "descriptions": "Change air filters"
            }
        ],
        "countOfOwners": "2"
    }
    ResponseCode: 200 
    ResponseBody: 
    {
        "brand": "Chevrolet",
        "model": "Corsa",
        "manufacturingDate": "2000-11-20",
        "numberOfKilometers": 115000,
        "doors": 5,
        "price": 90000.0,
        "currency": "AR",
        "countOfOwners": 2
    }

### Obtener todos los vehiculos

    Ruta: http:localhost:8080/v1/api/vehicles/
    Codigos de respuesta: 200
    Escenario de respuesta: 
    200 -> Responde la lista de todos los vehiculos

#### Posibles peticiones
    Petición: http:localhost:8080/v1/api/vehicles/
    ResponseCode: 200 
    ResponseBody: 
    [
        {
            "brand": "Chevrolet",
            "model": "Corsa",
            "manufacturingDate": "2000-11-20",
            "numberOfKilometers": 115000,
            "doors": 5,
            "price": 90000.0,
            "currency": "AR",
            "countOfOwners": 2
        }
    ]

### Obtener todos los vehiculos con fecha de manufactura entre dos fechas

    Ruta: http:localhost:8080/v1/api/vehicles/dates?since= &to=
    QueryParams: since: fecha desde, to: fecha hasta
    Codigos de respuesta: 200
    Escenario de respuesta: 
    200 -> Responde la lista de vehiculos

#### Posibles peticiones
    Petición: http:localhost:8080/v1/api/vehicles/dates?since=2000-11-20&to=2020-02-01
    ResponseCode: 200 
    ResponseBody: 
    [
        {
            "brand": "Chevrolet",
            "model": "Corsa",
            "manufacturingDate": "2000-11-20",
            "numberOfKilometers": 115000,
            "doors": 5,
            "price": 90000.0,
            "currency": "AR",
            "countOfOwners": 2
        }
    ]

### Obtener todos los vehiculos con precio entre dos precios

    Ruta: http:localhost:8080/v1/api/vehicles/prices?since= &to=
    QueryParams: since: precio desde, to: precio hasta
    Codigos de respuesta: 200
    Escenario de respuesta: 
    200 -> Responde la lista de vehiculos

#### Posibles peticiones
    Petición: http:localhost:8080/v1/api/vehicles/dates?since=0&to=90000
    ResponseCode: 200 
    ResponseBody: 
    [
        {
            "brand": "Chevrolet",
            "model": "Corsa",
            "manufacturingDate": "2000-11-20",
            "numberOfKilometers": 115000,
            "doors": 5,
            "price": 90000.0,
            "currency": "AR",
            "countOfOwners": 2
        }
    ]

### Obtener un vehiculo por id 

    Ruta: http:localhost:8080/v1/api/vehicles/{id}
    PathVariable: id: identificador del vehiculo
    Codigos de respuesta: 200
    Escenario de respuesta: 
    200 -> Responde un vehiculo cuyo id coincida

#### Posibles peticiones
    Petición: http:localhost:8080/v1/api/vehicles/1
    ResponseCode: 200 
    ResponseBody: 
    
    {
        "brand": "Chevrolet",
        "model": "Corsa",
        "manufacturingDate": "2000-11-20",
        "numberOfKilometers": 115000,
        "doors": 5,
        "price": 90000.0,
        "currency": "AR",
        "countOfOwners": 2
    }
    