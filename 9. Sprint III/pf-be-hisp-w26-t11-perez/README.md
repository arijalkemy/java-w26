## API Endpoints

### GET /api/v1/fresh-products/ordersById/{id}

Este endpoint se utiliza para obtener los detalles de una orden de compra específica.

#### Parámetros

- `id`: El ID de la orden de compra que se desea obtener.

#### Respuesta

Devuelve un objeto `PurchaseOrderDetailDTO` que contiene los detalles de la orden de compra solicitada. Si la orden de compra no se encuentra, se devolverá un error 404.

#### Ejemplo de uso

```sh
/api/v1/fresh-products/ordersById/{orderNumber}
```

### GET /api/v1/expired-batches

Este endpoint se utiliza para obtener una lista de todos los lotes de productos que han expirado.

#### Respuesta

Devuelve un lista de `BatchStockResponseDTO` que contiene los detalles de los lotes expirados. Si no hay retorna un arreglo vacío.

#### Ejemplo de uso

```sh
/api/v1/expired-batches
```