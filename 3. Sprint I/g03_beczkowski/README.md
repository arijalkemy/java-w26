# Grupo 03 - Parte individual - Sprint 1 - SocialMeli

En este proyecto desarrollaremos un API la nueva herramienta de Mercado Libre, __SocialMeli__.

## Integrantes

- Camila Beczkowski

## Tabla de contenidos

- [Entidades](#entidades)
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

### 1. Dar de alta una publicación de promo

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

### 2. Obtener el resultado de la cantidad de publicaciones con promo de un vendedor

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