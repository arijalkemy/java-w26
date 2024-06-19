
# Meli Frescos API

Esta API proporciona funcionalidades para gestionar productos frescos, incluyendo la búsqueda de productos por nombre y rango de precios, así como la obtención de productos con stock bajo.

## Endpoints

### Buscar productos por nombre y rango de precios

**URL**: `/api/v1/fresh-products/search`

**Método**: `GET`

**Descripción**: Este endpoint permite buscar productos por nombre y rango de precios.

**Parámetros de consulta**:
- `name` (opcional): Nombre del producto.
- `minPrice` (opcional): Precio mínimo.
- `maxPrice` (opcional): Precio máximo.

**Ejemplo de solicitud**:
```http
GET /api/v1/fresh-products/search?name=Apple&minPrice=0.5&maxPrice=2.5
Authorization: Bearer <token>
```

**Respuesta**:
```json
[
  {
    "name": "Apple",
    "price": 1.0
  },
  {
    "name": "Banana",
    "price": 2.0
  }
]
```

### Obtener productos con stock bajo

**URL**: `/api/v1/fresh-products/low-stock`

**Método**: `GET`

**Descripción**: Este endpoint permite obtener una lista de productos cuyo stock está por debajo de un umbral especificado.

**Parámetros de consulta**:
- `threshold`: Umbral de stock mínimo (requerido).

**Ejemplo de solicitud**:
```http
GET /api/v1/fresh-products/low-stock?threshold=10
Authorization: Bearer <token>
```

**Respuesta**:
```json
[
  {
    "id": 1,
    "name": "Manzana",
    "quantity": 5
  },
  {
    "id": 2,
    "name": "Platano",
    "quantity": 4
  }
]
```

## Autenticación

Los endpoints requieren autenticación mediante un token JWT. Incluye el token en el encabezado de la solicitud como se muestra a continuación:

```http
Authorization: Bearer <token>
```

## Ejecución de Pruebas

Para ejecutar las pruebas unitarias y de integración, utiliza los siguientes comandos:

```bash
./mvnw test
```