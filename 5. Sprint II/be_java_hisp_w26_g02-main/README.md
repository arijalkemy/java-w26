# Bootcamp w26 Java - Repositorio del primer sprint - Grupo 2


## Integrantes
| Apellido |  Nombre | Usuario de Github |
|----------|----------|----------|
| Bendezu Gonzalez    | Jonathan Leonel   | jleonelbendezu   |
| Carazo  Basualdo | Agustina Florencia  | agustinacarazo   |
| Caridad | Macarena  | macarenacaridad |
| Chiaravalli | Agustin  | AaChiaravalli  |
| Juarez | Agustin Ezequiel  | agusjua00  |
| Lastra | Levian Francisco   | levianfrancisco   |


## Requerimientos técnicos funcionales

#### US 0001: Poder realizar la acción de “Follow” (seguir) a un determinado vendedor

| Type                          | Method   | URI                                    |
|-------------------------------|----------|----------------------------------------|
| Requerimiento Inicial (Desarrollo GRUPAL) | POST  | /users/{userId}/follow/{userIdToFollow} |
  
**Ejemplo:** `/users/123/follow/234`

**Response:**
- Status Code 200 (todo OK) - bodyless or dto
- Status Code 400 (Bad Request) - bodyless or dto

**Filtros/Parámetros:**
| Parámetros   | Tipo | Descripción/Ejemplo                    |
|--------------|------|----------------------------------------|
| userId       | int  | Número que identifica al usuario actual |
| userIdToFollow | int | Número que identifica al usuario a seguir |

#### US 0002: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor

| Type  | Method | URI                                    |
|----------|---------|----------------------------------------|
| Requerimiento Inicial (Desarrollo GRUPAL) | GET  | /users/{userId}/followers/count        |

**Ejemplo:** `/users/234/followers/count/`

**Response:**
```json
{
    "user_id": 234,
    "user_name": "vendedor1",
    "followers_count": 35
}
```

**Filtros/Parámetros:**
| Parámetros | Tipo | Descripción/Ejemplo                       |
|------------|------|-------------------------------------------|
| userId     | int  | Número que identifica a cada usuario      |

#### US 0003: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)

| Type     | Method  | URI                                    |
|----------|-----------|----------------------------------------|
| Requerimiento Inicial (Desarrollo GRUPAL) | GET  | /users/{userId}/followers/list         |

**Ejemplo:** `/users/234/followers/list`

**Response:**
```json
{
    "user_id": 234,
    "user_name": "vendedor1",
    "followers": [
        {
            "user_id": 4698,
            "user_name": "usuario1"
        },
        {
            "user_id": 1536,
            "user_name": "usuario2"
        },
        {
            "user_id": 2236,
            "user_name": "usuario3"
        }
    ]
}
```

**Filtros/Parámetros:**
| Parámetros | Tipo | Descripción/Ejemplo                       |
|------------|------|-------------------------------------------|
| userId     | int  | Número que identifica a cada usuario      |

#### US 0004: Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)

| Type     | Method  | URI                                    |
|----------|---------|----------------------------------------|
| Requerimiento Inicial (Desarrollo GRUPAL)  | GET  | /users/{userId}/followed/list         |

**Ejemplo:** `/users/4698/followed/list`

**Response:**
```json
{
    "user_id": 4698,
    "user_name": "usuario1",
    "followed": [
        {
            "user_id": 234,
            "user_name": "vendedor1"
        },
        {
            "user_id": 6932,
            "user_name": "vendedor2"
        },
        {
            "user_id": 6631,
            "user_name": "vendedor3"
        }
    ]
}
```

**Filtros/Parámetros:**
| Parámetros | Tipo | Descripción/Ejemplo                       |
|------------|------|-------------------------------------------|
| userId     | int  | Número que identifica a cada usuario      |

#### US 0005: Dar de alta una nueva publicación

| Type     | Method  | URI                                    |
|----------|---------|----------------------------------------|
| Requerimiento Inicial (Desarrollo GRUPAL) | POST  | /products/post                         |

**Payload:**
```json
{
    "user_id": 123,
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
    "price": 1500.50
}
```

**Response:**
- Status Code 200 (todo OK)
- Status Code 400 (Bad Request)

**Filtros/Parámetros:**
| Parámetros | Tipo    | Descripción/Ejemplo                       |
|------------|---------|-------------------------------------------|
| user_id    | int     | Número que identifica a cada usuario      |
| date       | LocalDate| Fecha de la publicación en formato dd-MM-yyyy |
| product_id | int     | Número identificatorio de un producto asociado a una publicación |
| product_name | String | Cadena de caracteres que representa el nombre de un producto |
| type       | String  | Cadena de caracteres que representa el tipo de un producto |
| brand      | String  | Cadena de caracteres que representa la marca de un producto |
| color      | String  | Cadena de caracteres que representa el color de un producto |
| notes      | String  | Cadena de caracteres para colocar notas u observaciones de un producto |
| category   | int     | Identificador que sirve para conocer la categoría a la que pertenece un producto. Por ejemplo: 100: Sillas, 58: Teclados |
| price      | double  | Precio del producto                        |

#### US 0006: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero)

| Type     | Method  | URI                                    |
|----------|---------|----------------------------------------|
| Requerimiento Inicial (Desarrollo GRUPAL)  | GET  | /products/followed/{userId}/list      |

**Ejemplo:** `/products/followed/4698/list`

**Response:**
```json
{
    "user_id": 4698,
    "posts": [
        {
            "user_id": 123,
            "post_id": 32,
            "date": "01-05-2021",
            "product": {
                "product_id": 62,
                "product_name": "Headset RGB Inalámbrico",
                "type": "Gamer",
                "brand": "Razer",
                "color": "Green with RGB",
                "notes": "Sin Batería"
            },
            "category": 120,
            "price": 2800.69
        },
        {
            "user_id": 234,
            "post_id": 18,
            "date": "29-04-2021",
            "product": {
                "product_id": 1,
                "productName": "Silla Gamer",
                "type": "Gamer",
                "brand": "Racer",
                "color": "Red & Black",
                "notes": "Special Edition"
            },
            "category": 100,
            "price": 15000.50
        }
    ]
}
```

**Filtros/Parámetros:**
| Parámetros | Tipo | Descripción/Ejemplo                       |
|------------|------|-------------------------------------------|
| userId     | int  | Número que identifica a cada usuario      |

#### US 0007: Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor

| Type | Method | URI                                    |
|----------|-----|----------------------------------------|
| Requerimiento Inicial (Desarrollo GRUPAL)  | POST | /users/{userId}/unfollow/{userIdToUnfollow} |

**Ejemplo:** `/users/234/unfollow/123`

**Filtros/Parámetros:**
| Parámetros     | Tipo | Descripción/Ejemplo                    |
|----------------|------|----------------------------------------|
| userId         | int  | Número que identifica al usuario actual |
| userIdToUnfollow | int | Número que identifica al usuario a dejar de seguir |

#### US 0008: Ordenamiento alfabético ascendente y descendente

| Type  | Method  | URI                                             |
|----------|--------|-------------------------------------------------|
| Requerimiento Inicial (Desarrollo GRUPAL)  | GET  | /users/{UserID}/followers/list?order=name_asc   |
| Requerimiento Inicial (Desarrollo GRUPAL)  | GET  | /users/{UserID}/followers/list?order=name_desc  |
| Requerimiento Inicial (Desarrollo GRUPAL)  | GET  | /users/{UserID}/followed/list?order=name_asc    |
| Requerimiento Inicial (Desarrollo GRUPAL)  | GET  | /users/{UserID}/followed/list?order=name_desc   |

**order:**
- name_asc: Alfabético ascendente.
- name_desc: Alfabético descendente.

*Nota: Este ordenamiento aplica solo para US-003 y US-004.*

#### US 0009: Ordenamiento por fecha ascendente y descendente

| Type     | Method | Type | URI                                             |
|----------|--------|------|-------------------------------------------------|
| Requerimiento Inicial (Desarrollo GRUPAL)  | GET  | /products/followed/{userId}/list?order=date_asc    |
| Requerimiento Inicial (Desarrollo GRUPAL)  | GET  | /products/followed/{userId}/list?order=date_desc   |

**order:**
- date_asc: Fecha ascendente (de más antigua a más nueva)
- date_desc: Fecha descendente (de más nueva a más antigua)

*Nota: Este ordenamiento aplica solo para la US-006.*

### Requerimientos incrementales (Desarrollo INDIVIDUAL)

#### US 0010: Llevar a cabo la publicación de un nuevo producto en promoción

| Tyoe     | Method  | URI                                             |
|----------|---------|-------------------------------------------------|
| Requerimiento Incremental (Desarrollo INDIVIDUAL)  | POST | /products/promo-post                        |

**Payload:**
```json
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

**Response:**
- Status Code 200 (OK)
- Status Code 400 (Bad request)

**Filtros/Parámetros:**
| Parámetros     | Tipo | Descripción/Ejemplo                    |
|----------------|------|----------------------------------------|
| user_id        | int  | Número que identifica a cada usuario   |
| date           | LocalDate | Fecha de la publicación en formato dd-MM-yyyy |
| product_id     | int  | Número identificatorio de un producto asociado a una publicación |
| product_name   | String | Cadena de caracteres que representa el nombre de un producto |
| type           | String | Cadena de caracteres que representa el tipo de un producto |
| brand          | String | Cadena de caracteres que representa la marca de un producto |
| color          | String | Cadena de caracteres que representa el color de un producto |
| notes          | String | Cadena de caracteres para colocar notas u observaciones de un producto |
| category       | int  | Identificador que sirve para conocer la categoría a la que pertenece un producto. Por ejemplo: 100: Sillas, 58: Teclados |
| price          | double| Precio del producto                     |
| has_promo      | boolean| Campo true o false para determinar si un producto está en promoción o no |
| discount       | double| En caso de que un producto estuviese en promoción, establece el monto de descuento |

#### US 0011: Obtener la cantidad de productos en promoción de un determinado vendedor

| Type     | Method  | URI                                             |
|----------|---------|-------------------------------------------------|
| Requerimiento Incremental (Desarrollo INDIVIDUAL)  | GET  | /products/promo-post/count?user_id={userId}   |

**Response:**
```json
{
    "user_id": 234,
    "user_name": "vendedor1",
    "promo_products_count": 23
}
```

**Filtros/Parámetros:**
| Parámetros         | Tipo | Descripción/Ejemplo                    |
|--------------------|------|----------------------------------------|
| user_id            | int  | Número que identifica a cada usuario   |
| user_name          | String| Cadena de caracteres que representa el nombre del usuario |
| promo_products_count| int | Cantidad numérica de productos en promoción de un determinado usuario |

### Ejemplo Requerimiento Bonus (Desarrollo INDIVIDUAL)

#### US 0012: Obtener un listado de todos los productos en promoción de un determinado vendedor

| Type     | Method | URI                                             |
|----------|--------|-------------------------------------------------|
| Requerimiento Incremental (Desarrollo INDIVIDUAL) | GET  | /products/promo-post/list?user_id={userId}    |

**Response:**
```json
{
    "user_id": 234,
    "user_name": "vendedor1",
    "posts": [
        {
            "user_id": 234,
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

**Filtros/Parámetros:**
| Parámetros         | Tipo | Descripción/Ejemplo                    |
|--------------------|------|----------------------------------------|
| user_id            | int  | Número que identifica a cada usuario   |
| user_name          | String| Cadena de caracteres que representa el nombre del usuario |
| post_id            | int  | Número identificatorio de cada una de las publicaciones |
| date               | LocalDate | Fecha de la publicación en formato dd-MM-yyyy |
| product_id         | int  | Número identificatorio de un producto asociado a una publicación |
| product_name       | String| Cadena de caracteres que representa el nombre de un producto |
| type               | String| Cadena de caracteres que representa el tipo de un producto |
| brand              | String| Cadena de caracteres que representa la marca de un producto |
| color              | String| Cadena de caracteres que representa el color de un producto |
| notes              | String| Cadena de caracteres para colocar notas u observaciones de un producto |
| category           | int  | Identificador que sirve para conocer la categoría a la que pertenece un producto. Por ejemplo: 100: Sillas, 58: Teclados |
| price              | double| Precio del producto |
| has_promo          | boolean| Campo true o false para determinar si un producto está en promoción o no |
| discount           | double| En caso de que un producto estuviese en promoción, establece el monto de descuento |



## Diagrama de clases planteado por el equipo

![Alt Text](./diagramaDeClases.png)


## Convenciones 

- Programar en ingles.
- Desarrollar orientado a las interfaces.
- Usar inyección por constructor. 

# Requerimientos técnicos funcionales Test (Punto A)

## User Stories

SocialMeli contaba anteriormente con las siguientes User Stories y requerimientos técnicos:

- US-0001: Poder realizar la acción de “Follow” (seguir) a un determinado vendedor
- US-0002: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
- US-0003: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
- US-0004: Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
- US-0005: Dar de alta una nueva publicación.
- US-0006: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).
- US-0007: Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
- US-0008: Ordenamiento alfabético ascendente y descendente.
- US-0009: Ordenamiento por fecha ascendente y descendente.

## Especificaciones técnicas de Desafío Anterior: Esp. de Req. técnicos funcionales - Sprint Nº 1 - Spring

### Datos/Parámetros

| Dato/Parámetro | Tipo    | Longitud | Descripción                                                      |
|----------------|---------|----------|------------------------------------------------------------------|
| user_id        | Integer |          | Número que identifica al usuario actual                          |
| user_id_to_follow | Integer |       | Número que identifica al usuario a seguir                        |
| user_name      | String  | 15       | Nombre de usuario asociado al user_id                            |
| followers_count| Integer |          | Cantidad de seguidores                                           |
| id_post        | Integer |          | Número identificatorio de cada una de las publicaciones           |
| date           | LocalDate|          | Fecha de la publicación en formato dd-MM-yyyy                     |
| product_id     | Integer |          | Número identificatorio de cada uno de los productos asociados a una publicación |
| product_name   | String  | 40       | Cadena de caracteres que representa el nombre de un producto     |
| type           | String  | 15       | Cadena de caracteres que representa el tipo de un producto       |
| brand          | String  | 25       | Cadena de caracteres que representa la marca de un producto      |
| color          | String  | 15       | Cadena de caracteres que representa el color de un producto      |
| notes          | String  | 80       | Cadena de caracteres para colocar notas u observaciones de un producto |
| category       | Integer |          | Identificador que sirve para conocer la categoría a la que pertenece un producto. Por ejemplo: 100: Sillas, 58: Teclados |
| price          | Double  | 10.000.000 (Max) | Precio del producto                                         |
| user_id_to_unfollow | Integer |     | Número que identifica al usuario a dejar de seguir                |
| order          | String  |          | Establece el ordenamiento. Puede poseer los valores: name_asc, name_desc, date_asc, date_desc |

### Resumen de Datos de entrada (todas las US):

#### Validaciones en campos (Todas las US):
| Dato/Parámetro | ¿Obligatorio? | Validación                                                                                                        | Mensaje de error                                                                                                                                                                                                                   |
|----------------|----------------|-------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| user_id        | Si             | Que el campo no esté vacío. Mayor 0                                                                               | El id no puede estar vacío. El id debe ser mayor a cero                                                                                                                                                                         |
| date           | SI             | Que el campo no esté vacío. La fecha no puede estar vacía.                                                       | La fecha no puede estar vacía.                                                                                                                                                                                                   |
| product_id     | SI             | Que el campo no esté vacío. Mayor 0                                                                              | La id no puede estar vacía. El id debe ser mayor a cero                                                                                                                                                                          |
| product_name   | SI             | Que el campo no esté vacío. Longitud máxima de 40 caracteres. Que no posea caracteres especiales (%,&,$,etc). | El campo no puede estar vacío. La longitud no puede superar los 40 caracteres. El campo no puede poseer caracteres especiales.                                                                                                 |
| type           | SI             | Que el campo no esté vacío. Longitud máxima de 15 caracteres. Que no posea caracteres especiales (%,&,$,etc).  | El campo no puede estar vacío. La longitud no puede superar los 15 caracteres. El campo no puede poseer caracteres especiales.                                                                                                  |
| brand          | SI             | Que el campo no esté vacío. Longitud máxima de 25 caracteres. Que no posea caracteres especiales (%,&,$,etc).  | La longitud no puede superar los 25 caracteres. El campo no puede estar vacío. El campo no puede poseer caracteres especiales.                                                                                                  |
| color          | SI             | Que el campo no esté vacío. Longitud máxima de 15 caracteres. Que no posea caracteres especiales (%,&,$,etc).  | El campo no puede estar vacío. La longitud no puede superar los 15 caracteres. El campo no puede poseer caracteres especiales.                                                                                                  |
| notes          | NO             | Longitud máxima de 80 caracteres. Que no posea caracteres especiales (%,&,$,etc), permite espacios.           | La longitud no puede superar los 80 caracteres. El campo no puede poseer caracteres especiales.                                                                                                                                  |
| category       | SI             | Que el campo no esté vacío.                                                                                      | El campo no puede estar vacío.                                                                                                                                                                                                  |
| price          | SI             | Que el campo no esté vacío. El precio máximo puede ser 10.000.000.                                              | El campo no puede estar vacío. El precio máximo por producto es de 10.000.000                                                                                                                                                  |

*Nota: Tener en cuenta que para la devolución de los mensajes de error es recomendable utilizar los status code correspondientes.*

## Tests Unitarios:

A continuación se solicita una serie de test unitarios a llevar a cabo; sin embargo, en caso de que se considere necesario implementar otros, esto es totalmente viable.

| Test  | Situaciones de entrada                                                                                                   | Comportamiento Esperado                                                                 |
|-------|---------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------|
| T-0001| Verificar que el usuario a seguir exista. (US-0001)                                                                      | - Se cumple: Permite continuar con normalidad. <br> - No se cumple: Notifica la no existencia mediante una excepción. |
| T-0002| Verificar que el usuario a dejar de seguir exista. (US-0007)                                                              | - Se cumple: Permite continuar con normalidad. <br> - No se cumple: Notifica la no existencia mediante una excepción. |
| T-0003| Verificar que el tipo de ordenamiento alfabético exista (US-0008)                                                         | - Se cumple: Permite continuar con normalidad. <br> - No se cumple: Notifica la no existencia mediante una excepción. |
| T-0004| Verificar el correcto ordenamiento ascendente y descendente por nombre. (US-0008)                                          | Devuelve la lista ordenada según el criterio solicitado                                   |
| T-0005| Verificar que el tipo de ordenamiento por fecha exista (US-0009)                                                           | - Se cumple: Permite continuar con normalidad. <br> - No se cumple: Notifica la no existencia mediante una excepción. |
| T-0006| Verificar el correcto ordenamiento ascendente y descendente por fecha. (US-0009)                                          | Verificar el correcto ordenamiento ascendente y descendente por fecha. (US-0009)         |
| T-0007| Verificar que la cantidad de seguidores de un determinado usuario sea correcta. (US-0002)                                 | Devuelve el cálculo correcto del total de la cantidad de seguidores que posee un usuario. |
| T-0008| Verificar que la consulta de publicaciones realizadas en las últimas dos semanas de un determinado vendedor sean efectivamente de las últimas dos semanas. (US-0006) | Devuelve únicamente los datos de las publicaciones que tengan fecha de publicación dentro de las últimas dos semanas a partir del día de la fecha. |
