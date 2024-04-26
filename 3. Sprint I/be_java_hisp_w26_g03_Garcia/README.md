# Grupo 03 - Sprint 1 - SocialMeli

En este proyecto desarrollaremos un API la nueva herramienta de Mercado Libre, __SocialMeli__.

## Integrantes

- Blas Bulacio
- Camila Beczkowski
- Andrés García
- Andrés Kubler
- Bruno Donato
- Leonel Abatte

## Tabla de contenidos

- [Entidades](#entidades)
    - [UserData](#1-userdata)
    - [Seller](#2-seller)
    - [Buyer](#3-buyer)
    - [Publication](#4-publication)
    - [Product](#5-product)
- [Diagrama de clases](#diagrama-de-clases)
- [Endpoints](#endpoints)
  - [Seguir a un usuario](#1-seguir-a-un-usuario)
  - [Cantidad de usuarios que siguen a un vendedor](#2-obtener-el-resultado-de-la-cantidad-de-usuarios-que-siguen-a-un-determinado-vendedor)
  - [Usuarios que siguen a un vendedor](#3-obtener-el-listado-de-todos-los-usuarios-que-siguen-a-un-determinado-vendedor)
  - [Vendedores a los cuales sigue un usuario](#4-obtener-un-listado-de-todos-los-vendedores-a-los-cuales-sigue-un-determinado-usuario)
  - [Dar de alta una publicación](#5-dar-de-alta-una-publicación)
  - [Publicaciones de un vendedor que un usuario sigue en las últimas dos semanas](#6-6-obtener-un-listado-de-las-publicaciones-realizadas-por-los-vendedores-que-un-usuario-sigue-en-las-últimas-dos-semanas)
  - [Poder realizar la acción de “Unfollow”](#7-poder-realizar-la-acción-de-unfollow)
  - [Dar de alta publicación de promoción](#10-llevar-a-cabo-la-publicación-de-un-nuevo-producto-en-promoción)
  - [Cantidad de productos en promoción](#11-obtener-la-cantidad-de-productos-en-promoción-de-un-determinado-vendedor)
  - [Lista de productos en promoción](#12-obtener-la-lista-de-productos-en-promoción-de-un-determinado-vendedor)
  - [Eliminar publicación](#12-eliminar-publicación-de-vendedor)

## Entidades

### 1. UserData

Es la información de un usuario registrado en __SocialMeli__.

#### Atributos

| Campo | Tipo | Descripción                                           |
|-------|------|-------------------------------------------------------|
| user_id | Integer | Identificador del usuario                             |
| user_name | String | Nombre del usuario                                    |

### 2. Seller

Es el usuario que puede subir publicaciones y ser seguido por compradores.

#### Atributos

| Campo | Tipo | Descripción                                           |
|-------|------|-------------------------------------------------------|
| user_id | Integer | Identificador del usuario                             |
| user_name | String | Nombre del usuario                                    |
| followers | List<UserData> | Lista de la información de los seguidores del usuario |
| publications | List<Publication> | Lista de publicaciones del usuario                    |

### 3. Buyer

Es el usuario que sigue a los vendedores.

#### Atributos


| Campo | Tipo | Descripción                                                     |
|-------|------|-----------------------------------------------------------------|
| user_id | Integer | Identificador del usuario                                       |
| user_name | String | Nombre del usuario                                              |
| followed | List<UserData> | Lista de la información de los usuarios seguidos por el usuario |


### 4. Publication

Es la publicación de un producto que realiza un vendedor.

#### Atributos


| Campo | Tipo | Descripción                                                     |
|-------|------|-----------------------------------------------------------------|
| post_id | Integer | Identificador de la publicación                                |
| user_id | Integer | Identificador del usuario que realizó la publicación           |
| date | LocalDate | Fecha de la publicación                                        |
| product | Product | Producto que se está vendiendo                                 |
| category | Integer | Identificador de la categoría del producto                     |
| price | Double | Precio del producto                                             |

### 5. Product

El producto que se está vendiendo.

#### Atributos

| Campo | Tipo | Descripción                                                     |
|-------|------|-----------------------------------------------------------------|
| product_id | Integer | Identificador del producto                                     |
| product_name | String | Nombre del producto                                             |
| brand | String | Marca del producto                                              |
| color | String | Color del producto                                              |
| notes | String | Notas adicionales sobre el producto                             |

## Diagrama de clases

![image](documentation/diagrams/out/dc-Class_Diagram.png)

## Endpoints

### 1. Seguir a un usuario


```http
POST /users/{userId}/follow/{userIdToFollow}
```

#### Filtros/Parámetros:

| Parámetro | Tipo | Descripción                                       |
|-------|------|---------------------------------------------------|
| userId | Integer | Número que identifica a un usario de tipo `Buyer` |
| userIdToFollow | Integer | Número que identifica a un usario de tipo `Seller`  |


### 2. Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor

```http
GET /users/{userId}/followers/count
```
#### Response
```http
{
    "user_id": 234,
    "user_name": "vendedor1",
    "followers_count": 35
}
```

#### Filtros/Parámetros:

| Parámetro | Tipo | Descripción |
|-------|------|----------------------------------------------------------------|
| userId | Integer | Número que identifica a un usario de tipo `Seller` |

### 3. Obtener el listado de todos los usuarios que siguen a un determinado vendedor

```http
GET /users/{userId}/followers/list
GET /users/{userId}/followers/list?order=name_asc
GET /users/{userId}/followers/list?order=name_desc
```

#### Response
```http
{
    "user_id": 234,
    "user_name": "vendedor1",
    "followers": [
        {
            "user_id": 1,
            "user_name": "comprador1"
        },
        {
            "user_id": 2,
            "user_name": "comprador2"
        }
    ]
}
```

#### Filtros/Parámetros:

| Parámetro | Tipo | Descripción |
|-------|------|----------------------------------------------------------------|
| userId | Integer | Número que identifica a un usario de tipo `Seller` |

### 4. Obtener  un listado de todos los vendedores a los cuales sigue un determinado usuario

```http
GET /users/{userId}/followed/list
GET /users/{userId}/followed/list?order=name_asc
GET /users/{userId}/followed/list?order=name_desc
```

#### Response
```http
{
    "user_id": 234,
    "user_name": "comprador1",
    "followed": [
        {
            "user_id": 1,
            "user_name": "vendedor1"
        },
        {
            "user_id": 2,
            "user_name": "vendedor2"
        }
    ]
}
```

#### Filtros/Parámetros:

| Parámetro | Tipo | Descripción                                       |
|-------|------|---------------------------------------------------|
| userId | Integer | Número que identifica a un usario de tipo `Buyer` |

### 5. Dar de alta una publicación

```http
POST /products/newpost
```

#### Payload

| Parámetro | Tipo | Descripción                                                                      |
|-------|------|----------------------------------------------------------------------------------|
| userId | Integer | Número que identifica a un usario de tipo `Seller`                               |
| date | LocalDate | Fecha de la publicación en formato dd-MM-yyyy                                    |
| detail | Product | Detalle del producto                                                             |
| category | Integer | Identificador que sirve para conocer la categoría a la que pertenece un producto |
| price | Double | Precio del producto                                                              |

Ejemplo:

```http
{
    "userId": 1,
    "date": "2023-03-01",
    "detail": {
        "product_id": 1,
        "productName": "Producto 1",
        "brand": "Marca 1",
        "color": "Color 1",
        "notes": "Notas 1"
    },
    "category": 1,
    "price": 100.0
}
```

### 6. 6: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas

```http
GET /products/followed/{userId}/list
GET /products/followed/{userId}/list?order=date_asc
GET /products/followed/{userId}/list?order=date_desc
```

#### Response

```http
{
    "userId": 1,
    "posts": [
        {
            "postId": 1,
            "date": "2023-03-01",
            "detail": {
                "productId": 1,
                "productName": "Producto 1",
                "brand": "Marca 1",
                "color": "Color 1",
                "notes": "Notas 1"
            },
            "category": 1,
            "price": 100.0
        },
        {
            "postId": 2,
            "date": "2023-03-02",
            "detail": {
                "productId": 2,
                "productName": "Producto 2",
                "brand": "Marca 2",
                "color": "Color 2",
                "notes": "Notas 2"
            },
            "category": 2,
            "price": 200.0
        }
    ]
}
```

#### Filtros/Parámetros

| Parámetro | Tipo | Descripción |
|-------|------|----------------------------------------------------------------|
| userId | Integer | Número que identifica a un usario de tipo `Buyer` |

### 7. Poder realizar la acción de “Unfollow”

```http
POST /users/{userId}/unfollow/{userIdToUnfollow}
```

#### Filtros/Parámetros:

| Parámetro | Tipo | Descripción                                        |
|-------|------|----------------------------------------------------|
| userId | Integer | Número que identifica a un usario de tipo `Buyer`  |
| userIdToUnfollow | Integer | Número que identifica a un usario de tipo `Seller` |


### 10. Llevar a cabo la publicación de un nuevo producto en promoción

```http
POST /products/promo-post
```

#### Payload

| Parámetro | Tipo | Descripción                                                                      |
|-------|------|----------------------------------------------------------------------------------|
| userId | Integer | Número que identifica a un usario de tipo `Seller`                               |
| date | LocalDate | Fecha de la publicación en formato dd-MM-yyyy                                    |
| detail | Product | Detalle del producto                                                             |
| category | Integer | Identificador que sirve para conocer la categoría a la que pertenece un producto |
| price | Double | Precio del producto                                                              |
| has_promo | boolean | Campo true o false para determinar si un producto está en promoción o no                                                              |
| discount | Double | En caso de que un producto estuviese en promoción ,establece el monto de descuento.                                                              |



Ejemplo:

```http
{
    "user_id": 234,
    "date": "29-04-2021",
    "product": {
        "product_id": 1,
        "product_name": "Silla Gamer",
        "type": "Gamer",
        "brand": "Racer",
        "color": "Red & Black",
        "notes": "Special Edition"
    },
    "category": 100,
    "price": 1500.50,
    "has_promo": true,
    "discount": 0.25
}
```

### 11. Obtener la cantidad de productos en promoción de un determinado vendedor

```http
GET /products/promo-post/count?user_id={userId}
```

#### Response

```http
{  
   "user_id" : 234,
   "user_name": "vendedor1",
   "promo_products_count": 23
}

```

#### Filtros/Parámetros:

| Parámetro        | Tipo    | Descripción                                                            |
|------------------|---------|------------------------------------------------------------------------|
| userId           | Integer | Número que identifica a un usario de tipo `Seller`                     |
| userName         | String  | Cadena de caracteres que representa el nombre del usuario              |
| promo_products_count | Integer | Cantidad numérica de productos en promoción de un determinado usuario. |

### 12. Obtener la lista de productos en promoción de un determinado vendedor

```http
GET /products/promo-post/list?user_id={userId}
```

#### Response

```http
{
    "user_id": 234,
    "user_name": "vendedor1",
    "posts": [
        {
            “user_id”: 234,
            "post_id": 18,
            "date": "29-04-2021",
            "product": {
                "product_id": 1,
                "product_name": "Silla Gamer",
                "type": "Gamer",
                "brand": "Racer",
                "color": "Red & Black",
                "notes": "Special Edition"
            },
            "category": "100",
            "price": 15000.50,
            "has_promo": true,
            "discount": 0.25
        }
    ]
}


```

#### Filtros/Parámetros:

| Parámetro | Tipo | Descripción                                                                      |
|-------|------|----------------------------------------------------------------------------------|
| userId | Integer | Número que identifica a un usario de tipo `Seller`                               |
| date | LocalDate | Fecha de la publicación en formato dd-MM-yyyy                                    |
| detail | Product | Detalle del producto                                                             |
| category | Integer | Identificador que sirve para conocer la categoría a la que pertenece un producto |
| price | Double | Precio del producto                                                              |
| has_promo | boolean | Campo true o false para determinar si un producto está en promoción o no                                                              |
| discount | Double | En caso de que un producto estuviese en promoción ,establece el monto de descuento.                                                              |

### 13. Eliminar publicación de vendedor

```http
DEL /users/userId/delete_post/postId
```

#### Filtros/Parámetros:

| Parámetro | Tipo    | Descripción                                        |
|-----------|---------|----------------------------------------------------|
| userId    | Integer | Número que identifica a un usario de tipo `Seller` |
| postId    | Integer | Número que identifica a una publicación            |

### 14. Actualizar publicación de vendedor

```http
PUT /users/userId/update_post/postId
```

#### Filtros/Parámetros:

| Parámetro | Tipo    | Descripción                                        |
|-----------|---------|----------------------------------------------------|
| userId    | Integer | Número que identifica a un usario de tipo `Seller` |
| postId    | Integer | Número que identifica a una publicación            |

#### Payload

| Parámetro | Tipo | Descripción                                                                                     |
|-------|------|-------------------------------------------------------------------------------------------------|
| date | LocalDate | Fecha de la publicación en formato dd-MM-yyyy                                    |
| detail | Product | Detalle del producto                                                                            |
| category | Integer | Identificador que sirve para conocer la categoría a la que pertenece un producto                |
| price | Double | Precio del producto                                                                             |
| userId    | Integer | Número que identifica a un usario de tipo `Seller` |
| postId    | Integer | Número que identifica a una publicación            |
| has_promo | boolean | Campo true o false para determinar si un producto está en promoción o no [Opcional]             |
| discount | Double | En caso de que un producto estuviese en promoción ,establece el monto de descuento. [Opcional]  |



Ejemplo:

```http
{
    "date": "2024-04-18",
    "product": {
        "product_id": 1,
        "product_name": "Silla Gamer",
        "type": "Gamer",
        "brand": "Racer",
        "color": "Red & Black",
        "notes": "Special Edition"
    },
    "category": 100,
    "price": 20000000000.0504034,
    "user_id": 124,
    "post_id": 0
    }
```

