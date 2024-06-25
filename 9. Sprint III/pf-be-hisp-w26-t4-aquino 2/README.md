### Historia de Usuario

**US 6:** Obtener un listado de todos los batch paginados

**Signo:**

| Método | SIGN                                                          |
|--------|---------------------------------------------------------------|
| GET    | /api/api/v1/fresh_products/batches?page={num}&size={cantidad} |

**Filtros/Parámetros:**

| Parámetros | Tipo    | Descripción/Ejemplo                                              |
|------------|---------|------------------------------------------------------------------|
| num        | Integer | Orden de precio ("asc" para ascendente, "desc" para descendente) |
| cantidad   | Integer | Nombre del producto para filtrar por coincidencia                |

**Respuesta:**

STATUS: 200 OK
Un arreglo de objetos `BatchDTO` conteniendo información sobre cada BATCH.

| Tipo de Dato  | JSON Property       | Descripción                                                      |
|---------------|---------------------|------------------------------------------------------------------|
| Integer       | batch_number        | Identificador único del batch.                                   |
| Integer       | product_id          | Identificador único del producto.                                |
| Double        | current_temperature | Fecha de la publicación en formato "dd-MM-yyyy".                 |
| Double        | minimum_temperature | Temperatura minima                                               |
| Integer       | initial_quantity    | Cantidad inicial del lote                                        |
| Integer       | current_quantity    | Cantidad actual del lote                                         |
| LocalDate     | manufacturing_date  | Fecha de creación en formato "dd-MM-yyyy".                       |
| LocalDateTime | manufacturing_time  | Fecha y hora de la publicación en formato "dd-MM-yyyy HH:mm:ss". |
| LocalDate     | due_date            | Fecha de vencimiento en formato "dd-MM-yyyy".                    |