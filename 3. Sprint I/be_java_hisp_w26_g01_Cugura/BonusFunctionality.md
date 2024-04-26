# Bonus Functionality

## **US 0012**

### Obtener un listado de todos los productos en promoción de un determinado vendedor

### Sign

<table>
<tr>
<td> Method </td> <td> SIGN </td>
</tr>
<tr>
<td> GET </td> <td> /products/promo-post/list?user_id={userId} </td>
</tr>
<tr>
<td> RESPONSE </td>
<td>

```json
{

    "user_id": 234,

    "user_name": "vendedor1",

    "posts": [

        {

            “user_id”: 234

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

</tr>
</table>

### Filtros/Parámetros

| Parámetros   | Tipo      | Descripción/Ejemplo                                                                                                      |
| ------------ | --------- | ------------------------------------------------------------------------------------------------------------------------ |
| user_id      | int       | Número que identifica a cada usuario                                                                                     |
| user_name    | String    | Cadena de caracteres que representa el nombre del usuario                                                                |
| post_id      | int       | Número identificatorio de cada una de las publicaciones                                                                  |
| date         | LocalDate | Fecha de la publicación en formato dd-MM-yyyy                                                                            |
| product_id   | int       | Número identificatorio de un producto asociado a una publicación                                                         |
| product_name | String    | Cadena de caracteres que representa el nombre de un producto                                                             |
| type         | String    | Cadena de caracteres que representa el tipo de un producto                                                               |
| brand        | String    | Cadena de caracteres que representa la marca de un producto                                                              |
| color        | String    | Cadena de caracteres que representa el color de un producto                                                              |
| notes        | String    | Cadena de caracteres para colocar notas u observaciones de un producto                                                   |
| category     | int       | Identificador que sirve para conocer la categoría a la que pertenece un producto. Por ejemplo: 100: Sillas, 58: Teclados |
| price        | double    | Precio del producto                                                                                                      |
| has_promo    | boolean   | Campo true o false para determinar si un producto está en promoción o no                                                 |
| discount     | double    | En caso de que un producto estuviese en promoción, establece el monto de descuento.                                      |
