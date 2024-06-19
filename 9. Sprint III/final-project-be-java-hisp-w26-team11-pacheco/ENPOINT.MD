# User Story: Listar los lotes de un producto en un almacén específico

## Descripción
Esta User Story está diseñada para permitir a un representante listar los lotes de un producto específico en un almacén, con el objetivo de mantener visibilidad sobre la disponibilidad de stock y gestionar inventarios de manera efectiva.

## Requerimientos Cubiertos
- **User Story Code:** ml-list-product-batches-in-warehouse-01
- **User Story Name:** Listar los lotes de un producto en un almacén específico

## Detalles del Endpoint
El servicio se expone desde el warehouse de fulfillment y ofrece la capacidad de listar los lotes de un producto en un almacén determinado.

### Endpoint
- **Método:** GET
- **URI:** `/api/v1/products/{productId}/warehouses/{warehouseId}/batches`
- **Descripción:** Este endpoint devuelve la lista de lotes disponibles de un producto en un almacén específico.
- **Código de la User Story:** ml-list-product-batches-in-warehouse-01

### Parámetros de la URI
- `{productId}`: ID del producto para el cual se desea listar los lotes.
- `{warehouseId}`: ID del almacén específico donde se buscarán los lotes.

### Representación JSON de la Respuesta
La respuesta esperada del endpoint será una lista de objetos JSON, cada uno representando un lote de producto en el almacén especificado. Cada objeto incluirá los siguientes campos:
```json
[
    {
        "batch_number": 1,
        "product_id": 1,
        "current_temperature": 10.23,
        "minimum_temperature": 1.05,
        "initial_quantity": 500,
        "current_quantity": 100,
        "manufacturing_date": "2023-05-10",
        "manufacturing_time": "2023-05-10T11:11:11",
        "due_date": "2023-05-30"
    },
    {
        "batch_number": 2,
        "product_id": 1,
        "current_temperature": 10.23,
        "minimum_temperature": 1.05,
        "initial_quantity": 10,
        "current_quantity": 7,
        "manufacturing_date": "2024-07-10",
        "manufacturing_time": "2024-07-10T11:11:11",
        "due_date": "2024-08-30"
    }
    // Otros lotes
]
```

## Escenario de Uso
- **ESCENARIO 1: lista exitosa de lotes**
  - DADO QUE el representante desea listar los lotes de un producto en un almacén específico
  - Y el producto y el almacén son válidos
  - CUANDO se realiza una solicitud para obtener los lotes del producto en el almacén
  - ENTONCES se devuelve la lista de lotes disponibles del producto en el almacén especificado

## Validaciones y Consideraciones
- Autenticación requerida como representante para acceder a los endpoints.
- Se deben manejar adecuadamente los errores posibles, contemplando escenarios como productos no encontrados o errores de autenticación.
- Utilización de Access Token para la autenticación como cliente autenticado.

## Notas Adicionales
Este servicio está diseñado para mejorar la gestión de inventarios y proporcionar visibilidad en tiempo real sobre la disponibilidad de productos en almacén.