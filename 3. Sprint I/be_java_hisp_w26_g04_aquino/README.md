### Historia de Usuario

**US 0011:** Obtener publicaciones con filtrado opcional por orden de precio, nombre de producto y
tipo.

**Signo:**

| Método | SIGN                                                                   |
|--------|------------------------------------------------------------------------|
| GET    | /posts?price_order={priceOrder}&product_name={productName}&type={type} |

**Filtros/Parámetros:**

| Parámetros   | Tipo   | Descripción/Ejemplo                                              |
|--------------|--------|------------------------------------------------------------------|
| price_order  | String | Orden de precio ("asc" para ascendente, "desc" para descendente) |
| product_name | String | Nombre del producto para filtrar por coincidencia                |
| type         | String | Tipo de producto para filtrar por coincidencia                   |

**Respuesta:**

STATUS: 200 OK
Un arreglo de objetos `PostResponseDTO` conteniendo información sobre cada publicación.

| Tipo de Dato | JSON Property | Descripción                                            |
|--------------|---------------|--------------------------------------------------------|
| int          | post_id       | Identificador único de la publicación.                 |
| int          | user_id       | Identificador único del usuario.                       |
| LocalDate    | date"         | Fecha de la publicación en formato "dd-MM-yyyy".       |
| int          | category      | Categoría de la publicación.                           |
| double       | price         | Precio de la publicación.                              |
| Product      | product       | Objeto que representa el producto de la publicación.   |
| boolean      | has_promo     | Indicador de si la publicación tiene promoción.        |
| double       | discount.     | Descuento aplicado, si la publicación tiene promoción. |