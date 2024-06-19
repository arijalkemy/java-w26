## 🍎 MELIFrescos API: Gestión de Productos Frescos 🍎

###### Esta API te permite administrar eficientemente el inventario de productos frescos en MELIFrescos. Realiza tareas como registrar nuevos productos, actualizar información existente y obtener detalles de los productos junto con sus lotes.

#### 🚀 Endpoints

#### 🆕 Registro de un Nuevo Producto

* POST api/v1/fresh-products/add

Agrega un nuevo producto fresco al sistema.

Request Body (JSON):
```
JSON
{
"name": "Manzanas Fuji",
"price": 1.99
}
```

| Campo | Tipo   | Descripción                   |
|-------|--------|-----------------------------|
| name  | string | Nombre del producto (obligatorio) |
| price | number | Precio del producto (obligatorio)  |

Expected Response (201 Created):
```
JSON
{
"message": "Product added successfully",
"code": 201
}
```



#### 🔄 Actualización de un Producto

* PUT /fresh-products/update

Modifica los datos de un producto existente.

Request Body (JSON):
```
JSON
{
"id": 123,
"name": "Manzanas Gala",
"price": 2.49
}
```



| Campo | Tipo   | Descripción                   |
|-------|--------|-----------------------------|
| id    | number | ID del producto (obligatorio)   |
| name  | string | Nuevo nombre del producto (obligatorio) |
| price | number | Nuevo precio del producto (obligatorio)  |

Response (200 OK):
```
JSON
{
"message": "Product updated successfully",
"code": 200
}
```



#### ➕ Registro Masivo de Productos

* POST /fresh-products/add/bulk

Registra varios productos frescos en una sola operación.

Request Body (JSON):
```
JSON
[
{ "name": "Manzanas Fuji", "price": 1.99 },
{ "name": "Peras Anjou", "price": 0.89 },
// ... más productos ...
]
```
Response (201 Created):
```
JSON
{
"message": "Products added successfully",
"code": 201
}
```


#### 📋 Lista de Productos con Información de Lotes

* GET /fresh-products/list/batches

Obtén una lista detallada de productos, incluyendo información sobre sus lotes.

Response (200 OK):
```
JSON
[
{
"name": "Manzanas Fuji",
"type": "FRUTA",
"price": 1.99,
"batchNumber": 1
},
// ... más productos ...
]
```

### 📦 Modelos de Datos

##### ProductRequestDto:

```
{
"id": 123,
"name": "string",
"price": 0.0
}
```

##### ProductStatusDto:
```
{
"message": "string",
"code": 0
}
```
##### ProductResponseWithTypeDTO:
```
{
"name": "string",
"type": "string",
"price": 0.0,
"batchNumber": 0
}
```

### 🛠️ Cómo Usar la API

* Obtener un Token JWT: Obtén un token JWT válido a través del endpoint de autenticación (no incluido en este ejemplo).

* Enviar el Token en el Encabezado: Incluye el token JWT en el encabezado Authorization de todas las solicitudes a la API:

* Authorization: Bearer <your_jwt_token>



### ⚠️ Consideraciones Adicionales

Validación: La API valida los datos de entrada para garantizar su integridad.
Manejo de Errores: Se proporcionan respue
