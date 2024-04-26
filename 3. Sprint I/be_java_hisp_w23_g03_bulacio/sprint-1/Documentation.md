# Sprint 1 - SocialMeli - Entrega individual

## Tabla de contenidos

- [Objetivo](#objetivo)
- [Cambios en las entidades](#cambios-en-las-entidades)
- [Endpoints](#endpoints)
  - [US 0010 - Crear una nueva publicación en promoción](#us-0010---crear-una-nueva-publicación-en-promoción)
  - [US 0011 - Obtener la cantidad de productos en promoción de un vendedor](#us-0011---obtener-la-cantidad-de-productos-en-promoción-de-un-vendedor)
  - [Extra](#extra)
    - [Obtener un listado de todas las publicaciones](#obtener-un-listado-de-todas-las-publicaciones)
- [Anotaciones](#anotaciones)

## Objetivo

El objetivo de esta entrega es agregar funcionalidad extra a la API de __SocialMeli__ que fue previamente desarrollada en grupo.

### Cambios en las entidades

Se agregaron los siguientes atributos a la entidad `Publication`:

- `hasPromo` (boolean): indica si la publicación tiene una promoción.
- `discount` (float): indica el porcentaje de descuento de la promoción.

Para el ejercicio extra, introduje el concepto de **precio total** de una publicación, que se calcula de la siguiente manera:

- Si la publicación tiene una promoción, el precio total es el precio de la publicación menos el descuento.
- Si la publicación no tiene una promoción, el precio total es el precio de la publicación.

Este campo se calcula automáticamente a la hora de devolver el DTO, haciendo uso de la anotación de jackson @JsonProperty.

```java
public class PublicationDTO implements Serializable {

    // ...
    
    @JsonProperty("total_price")
    public double calculateTotalPrice() {
        if (hasPromo) {
            return price * (1 - discount);
        } else {
            return price;
        }
    }
}
```
### Endpoints

##### [US 0010] - Crear una nueva publicación en promoción

```http
POST /products/promo-post
```

__Payload__:

```json
{
  "user_id": 2,
  "date": "2021-01-01",
  "product": {
    "product_id": 111,
    "product_name": "Teclado",
    "type": "Gamer",
    "brand": "Logitech",
    "color": "Red & Black",
    "notes": "Special Edition"
  },
  "category": 100,
  "price": 1500.50,
  "has_promo": true,
  "discount": 0.4
}
```
__Filtros/Parámetros:__

| Parámetro | Tipo | Descripción                                                                         |
| --- | --- |-------------------------------------------------------------------------------------|
| `user_id` | int | Número que identifica a un usuario de tipo `Seller`                                   |
| `date` | LocalDate | Fecha de la publicación en formato yyyy-MM-dd                                       |
| `product_id` | int | Número identificatorio de un producto asociado a una publicación                    |
| `product_name` | String | Cadena de caracteres que representa el nombre de un producto                        |
| `type` | String | Cadena de caracteres que representa el tipo de un producto                          |
| `brand` | String | Cadena de caracteres que representa la marca de un producto                         |
| `color` | String | Cadena de caracteres que representa el color de un producto                         |
| `notes` | String | Cadena de caracteres para colocar notas u observaciones de un producto              |
| `category` | int | Identificador que sirve para conocer la categoría a la que pertenece un producto.   |
| `price` | double | Precio del producto                                                                 |
| `has_promo` | boolean | Campo true o false para determinar si un producto está en promoción o no            |
| `discount` | double | En caso de que un producto estuviese en promoción ,establece el monto de descuento. |

##### [US 0011] - Obtener la cantidad de productos en promoción de un vendedor

```http
GET /products/promo-post/count?user_id={userId}
```

__Response__:

```json
{
  "user_id" : 234,
  "user_name": "vendedor1",
  "promo_products_count": 23
}
```

**Filtros/Parámetros:**

| Parámetro | Tipo | Descripción                                                                         |
| --- | --- |-------------------------------------------------------------------------------------|
| `user_id` | int | Número que identifica a un usuario de tipo `Seller`                                   |
| `user_name` | String | Cadena de caracteres que representa el nombre de un usuario                          |
| `promo_products_count` | int | Cantidad numérica de productos en promoción de un determinado usuario.               |


#### Extra

Para el ejercicio extra, decidí agregar un nuevo endpoint que permita obtener un listado de todas las publicaciones
en el sistema, junto a una serie de filtros para poder listar las publicaciones bajo distintos criterios.

##### Obtener un listado de todas las publicaciones

```http
GET /products/all
```

**Query Params:**

| Parámetro     | Tipo | Descripción                                                                                                          |
|---------------| --- |----------------------------------------------------------------------------------------------------------------------|
| `order`       | String | Ordena las publicaciones por el precio total de forma ascendente o descendente. Posibles valores: price_asc, min_asc |
| `minPrice`    | double | Filtra las publicaciones por precio mínimo.                                                                          |
| `maxPrice`    | double | Filtra las publicaciones por precio máximo.                                                                          |
| `productName` | String | Filtra las publicaciones por nombre de producto.                                                                     |

Estos filtros son opcionales, por lo que se pueden combinar o utilizar de forma individual según sea necesario.

**Ejemplo:**

```http
GET /products/all?order=total_price_asc&minTotal=500&maxTotal=1000&productName=Teclado
```

Respuesta:

```json
{
  "publications": [
    {
      "user_id": 2,
      "post_id": 3,
      "date": "2021-01-01",
      "product": {
        "product_id": 1112,
        "product_name": "Teclado Caro pero con promo",
        "type": "Gamer",
        "brand": "Logitech",
        "color": "Red & Black",
        "notes": "Special Edition"
      },
      "category": 100,
      "price": 1500.0,
      "has_promo": true,
      "discount": 0.5,
      "total_price": 750.0
    },
    {
      "user_id": 2,
      "post_id": 2,
      "date": "2021-01-01",
      "product": {
        "product_id": 1112,
        "product_name": "Teclado Caro",
        "type": "Gamer",
        "brand": "Logitech",
        "color": "Red & Black",
        "notes": "Special Edition"
      },
      "category": 100,
      "price": 995.0,
      "has_promo": false,
      "discount": 0.0,
      "total_price": 995.0
    }
  ]
}
```

**Anotaciones:** En la entrega grupal, el endpoint que traía todos los sellers estaba previamente en `/products/all`, fue movido a `/users/sellers`
