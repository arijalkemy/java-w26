# pf-be-hisp-w26-t01-arguello

# Requerimiento 6


Esta API es responsable de la gestión de almacenes. 

## Autenticación

Para interactuar con los endpoints, es necesaria la autenticación, excepto para el login. 

**Credenciales de representante:**
- Email: juan@gmail.com
- Contraseña: juan


## Endpoints

### User Story de los endpoints mencionados abajo:

https://docs.google.com/document/d/1YAwYHYsLZ-JITe_PJBH5v7XHd-8MuLGf/edit?usp=sharing&ouid=107712999667191135719&rtpof=true&sd=true


### POST /auth/login

**Request:**

```json
{
"email": "juan@gmail.com",
"password": "juan"
}
```

**Response:**

```json
{
"token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWId21iOiJqdWFuQGdtYWlsLmNvbSIsImlhdCI6MTcxOTE4MTI3NSwiZXhwIjoxNzE5MTgyNzE1fQ.Lpasdadb9RN3yokqmH_7a2Sm7r0jEB6IdL0bBa3Ik-WSw",
}
```


### GET /api/v1/fresh-products/inboundorder/warehouse/{idWarehouse}

Este endpoint permite listar todas las órdenes de carga con sus respectivos lotes de un warehouse determinado. Solo accesible por usuario autenticado que sea representante del warehouse a consultar.

**Response:**

```json
[
    {
        "order_number": 1,
        "order_date": "05-10-2022",
        "section": {
            "section_code": 1,
            "warehouse_code": 1
        },
        "batch_stock": [
            {
                "batch_number": 1,
                "product_id": 1,
                "current_temperature": 25.0,
                "minimum_temperature": 20.0,
                "initial_quantity": 100,
                "current_quantity": 70,
                "manufacturing_date": "05-10-2022",
                "manufacturing_time": "05-10-2022T10:00:00",
                "due_date": "01-04-2025"
            },
            {
                "batch_number": 2,
                "product_id": 2,
                "current_temperature": 22.0,
                "minimum_temperature": 18.0,
                "initial_quantity": 50,
                "current_quantity": 50,
                "manufacturing_date": "07-10-2022",
                "manufacturing_time": "07-10-2022T11:00:00",
                "due_date": "07-04-2025"
            }
        ]
    }
]
```


### GET /api/v1/fresh-products/inboundorder/{idOrder}

Este endpoint permite obtener una orden de carga con sus respectivos lotes, a partir de su id. Solo accesible por usuario autenticado que sea representante del warehouse al que pertenece la orden.

**Response:**

```json
{
    "order_number": 1,
    "order_date": "05-10-2022",
    "section": {
      "section_code": 1,
      "warehouse_code": 1
    },
    "batch_stock": [
        {
            "batch_number": 1,
            "product_id": 1,
            "current_temperature": 25.0,
            "minimum_temperature": 20.0,
            "initial_quantity": 100,
            "current_quantity": 70,
            "manufacturing_date": "05-10-2022",
            "manufacturing_time": "05-10-2022T10:00:00",
            "due_date": "01-04-2025"
        },
        {
            "batch_number": 2,
            "product_id": 2,
            "current_temperature": 22.0,
            "minimum_temperature": 18.0,
            "initial_quantity": 50,
            "current_quantity": 50,
            "manufacturing_date": "07-10-2022",
            "manufacturing_time": "07-10-2022T11:00:00",
            "due_date": "07-04-2025"
        }
    ]
}
```


## Uso

Utiliza herramientas como Postman o CURL para interactuar con la API. Asegúrate de incluir las credenciales adecuadas.

## Consideraciones de Seguridad

Asegúrate de que las credenciales de usuario no sean expuestas y que la comunicación con la API se realice a través de HTTPS, protegiendo así la privacidad e integridad de los datos transmitidos.