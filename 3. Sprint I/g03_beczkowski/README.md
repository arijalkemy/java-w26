# Grupo 03 - Parte individual - Sprint 1 - SocialMeli

En este proyecto desarrollaremos un API la nueva herramienta de Mercado Libre, __SocialMeli__.

## Integrantes

- Camila Beczkowski

## Tabla de contenidos

- [Entidades](#entidades)
    - [Publication](#1-publication)
- [Endpoints](#endpoints)
  - [Cear una publicación promo](#10-dar-de-alta-una-publicación-de-promo)
  - [Obtener cantidad de publicaciones promo de un vendedor](#11-obtener-el-resultado-de-la-cantidad-de-publicaciones-con-promo-de-un-vendedor)
  - [Listado de publicaciones con promo de un vendedor](#12-listado-de-publicaciones-con-promo-de-un-vendedor)

## Entidades

### 1. Publication

Es la publicación de un producto que realiza un vendedor.

#### Atributos


| Campo     | Tipo      | Descripción                                          |
|-----------|-----------|------------------------------------------------------|
| post_id   | Integer   | Identificador de la publicación                      |
| user_id   | Integer   | Identificador del usuario que realizó la publicación |
| date      | LocalDate | Fecha de la publicación                              |
| product   | Product   | Producto que se está vendiendo                       |
| category  | Integer   | Identificador de la categoría del producto           |
| price     | Double    | Precio del producto                                  |
| has_promo | boolean   | Bandera para definir si tiene promoción              |
| discount  | Double    | Descuento de la publicación                          |


## Endpoints

### 10. Dar de alta una publicación de promo

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

### 11. Obtener el resultado de la cantidad de publicaciones con promo de un vendedor

```http
GET /products/promo-post/count
```
#### Response
```http
{
    "user_id": 234,
    "user_name": "vendedor1",
    "promo_products_count": 23
}
```

#### Filtros/Parámetros:

| Parámetro | Tipo | Descripción |
|-------|------|----------------------------------------------------------------|
| userId | Integer | Número que identifica a un usario de tipo `Seller` |

### 12. Listado de publicaciones con promo de un vendedor

```http
GET /products/promo-post/list
```
#### Response
```http
{
    "user_id": 1,
    "user_name": "nombre_vendedor_1",
    "posts": [
        {
            "date": "2021-04-29",
            "product": {
                "type": "Gamer",
                "brand": "Racer",
                "color": "Red & Black",
                "notes": "Special Edition",
                "product_id": 1,
                "product_name": "Silla Gamer"
            },
            "category": 100,
            "price": 1500.5,
            "discount": 0.25,
            "user_id": 1,
            "post_id": 0,
            "has_promo": true
        }
    ]
}
```

#### Filtros/Parámetros:

| Parámetro | Tipo | Descripción |
|-------|------|----------------------------------------------------------------|
| userId | Integer | Número que identifica a un usario de tipo `Seller` |

### 13. Obtener el resultado de la cantidad de publicaciones con promo de todos los vendedores

```http
GET /products/promo-post/count/list
```
#### Response
```http
[
    {
        "user_id": 1,
        "user_name": "nombre_vendedor_1",
        "promo_products_count": 1
    },
    {
        "user_id": 2,
        "user_name": "nombre_vendedor_1",
        "promo_products_count": 2
    }
]
```
### 14. Listado de publicaciones con promo mayor al descuento ingresado

```http
GET /products/promo-post/list/{discount}
```
#### Response
```http
[
    {
        "user_id": 1,
        "user_name": "nombre_vendedor_1",
        "posts": [
            {
                "date": "2021-04-29",
                "product": {
                    "type": "Gamer",
                    "brand": "Racer",
                    "color": "Red & Black",
                    "notes": "Special Edition",
                    "product_id": 4,
                    "product_name": "Silla Gamer"
                },
                "category": 100,
                "price": 1500.5,
                "discount": 0.26,
                "user_id": 1,
                "post_id": 2,
                "has_promo": true
            }
        ]
    },
    {
        "user_id": 2,
        "user_name": "nombre_vendedor_1",
        "posts": [
            {
                "date": "2021-04-29",
                "product": {
                    "type": "Gamer",
                    "brand": "Racer",
                    "color": "Red & Black",
                    "notes": "Special Edition",
                    "product_id": 4,
                    "product_name": "Silla Gamer"
                },
                "category": 100,
                "price": 1500.5,
                "discount": 0.26,
                "user_id": 2,
                "post_id": 0,
                "has_promo": true
            },
            {
                "date": "2021-04-29",
                "product": {
                    "type": "Gamer",
                    "brand": "Racer",
                    "color": "Red & Black",
                    "notes": "Special Edition",
                    "product_id": 4,
                    "product_name": "Silla Gamer"
                },
                "category": 100,
                "price": 1500.5,
                "discount": 0.26,
                "user_id": 2,
                "post_id": 1,
                "has_promo": true
            }
        ]
    }
]
```

#### Filtros/Parámetros:

| Parámetro | Tipo   | Descripción                                                                        |
|-----------|--------|------------------------------------------------------------------------------------|
| discount  | Double | Número de descuento para filtrar las publicaciones, deben ser mayor o igual a este |