
# Programación Java - Requerimiento 6

## Especificaciones del Requerimiento

### Requerimientos US: ml-product-crud-06

### Importante:

Las historias de usuario están narradas desde el punto de vista los compradores
de productos en función a sus necesidades.
Los servicios son expuestos para ser consumidos por los BUYERS.
Los contratos hacen referencia a la User Story Búsqueda con filtros dinámicos de productos.

#### User Story

**Código de User Story:** ml-product-crud-06  
**Nombre de User Story:** Filter de products  
**Horas estimadas:** 2

**Descripción:**  
COMO Buyer QUIERO filtrar los products PARA una búsqueda específica.

#### Escenarios

**ESCENARIO 1:** Los products están registrados  
DADO QUE Los products están registrados  
CUANDO El buyer realice una búsqueda con filtros  
ENTONCES Los productos deberán ser obtenidos según los filtros.

**ESCENARIO 2:** No hay productos según los filtros  
DADO QUE No hay productos registrados según los filtros.  
CUANDO El buyer busque productos  
ENTONCES Se devolverá una lista vacía.

### Representación JSON

```json
{
"id_seller": "integer",
"type": "String",
"name": "String",
"min_price": "Double",
"max_price": "Double"
}
```

### Contratos referentes a la User Story

**Nota:**  
Cada uno de los parámetros del body son opcionales. 
Si no se pasa ningún parámetro en el body, deberá devolver la lista completa de products. 
Trabajar con Access Token para el pedido como cliente autenticado.

### Validación

- Autenticarse como buyer y acceder a los endpoints.
- Validación de valores positivos para min_price y max_price.

### Endpoint

**HTTP Plantilla URI:**  
GET /api/v1/products/filter

**Descripción:**  
Filtrar products

**US-code:**  
ml-product-crud-06

### Response

```json
[
  {
   "id": "integer",
   "name": "String",
   "description": "String",
   "type": "String",
   "creation_date": "String"
  }
]
```




