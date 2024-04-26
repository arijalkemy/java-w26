# Social MELI

## Diagrama

---
## Endpoints

---

### TRABAJO EN EQUIPO 

### US 0001

Poder realizar la acción de “Follow” (seguir) a un determinado vendedor
<table>
  <tbody>
    <tr>
      <th>Method</th>
      <th>Url</th>
      <th>Response</th>
    </tr>
    <tr>
      <td align="center">Post</td>
      <td align="center"> /users/:userId/follow/:userIdToFollow </td>
      <td>
        <ul>
          <li>200 (Todo OK)</li>
          <li>400 (Bad Request)</li>
        </ul>
      </td>
    </tr>
  </tbody>
</table>

### US 0002

Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
<table>
  <tbody>
    <tr>
      <th>Method</th>
      <th>Url</th>
      <th>Response</th>
    </tr>
    <tr>
      <td align="center">Get</td>
      <td align="center"> /users/:userId/followers/count </td>
<td>

```json
{
  "user_id": 234,
  "user_name": "vendedor1",
  "followers_count": 35
}
```

<ul>
          <li>200 (Todo OK)</li>
          <li>400 (Bad Request)</li>
          <li>404 (Not Found)</li>
          <li>406 (Not Acceptable)</li>
        </ul>
</td>
    </tr>
  </tbody>
</table>

### US 0003

Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
<table>
  <tbody>
    <tr>
      <th>Method</th>
      <th>Url</th>
      <th>Response</th>
    </tr>
    <tr>
      <td align="center">Get</td>
      <td align="center"> /users/:userId/followers/list </td>
<td>

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

</td>
    </tr>
  </tbody>
</table>

### US 0004

Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
<table>
  <tbody>
    <tr>
      <th>Method</th>
      <th>Url</th>
      <th>Response</th>
    </tr>
    <tr>
      <td align="center">Get</td>
      <td align="center"> /users/:userId/followed/list </td>
<td>

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

</td>
    </tr>
  </tbody>
</table>

### US 0005

Dar de alta una nueva publicación
<table>
  <tbody>
    <tr>
      <th>Method</th>
      <th>Url</th>
      <th>Payload</th>
      <th>Response</th>
    </tr>
    <tr>
      <td align="center">Post</td>
      <td align="center"> /products/post </td>
<td>

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

</td>
    <td align="center">
        <ul>
          <li>200 (Todo OK)</li>
          <li>400 (Bad Request)</li>
        </ul>  
    </td>
    </tr>
  </tbody>
</table>

### US 0006

Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas (
para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).
<table>
  <tbody>
    <tr>
      <th>Method</th>
      <th>Url</th>
      <th>Response</th>
    </tr>
    <tr>
      <td align="center">Get</td>
      <td align="center"> /products/followed/:userId/list </td>
<td>

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

</td>
    </tr>
  </tbody>
</table>

### US 0007

Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
<table>
  <tbody>
    <tr>
      <th>Method</th>
      <th>Url</th>
    </tr>
    <tr>
      <td align="center">Post</td>
      <td align="center"> /users/:userId/unfollow/:userIdToUnfollow </td>
    </tr>
  </tbody>
</table>

### US 0008

Ordenamiento alfabético ascendente y descendente
<table>
  <tbody>
    <tr>
      <th>Method</th>
      <th>Url</th>
    </tr>
    <tr>
      <td align="center">Get</td>
      <td align="center">
        <ul>
          <li> /users/:userId/followers/list?order=name_asc </li>
          <li> /users/:userId/followers/list?order=name_desc </li>
        </ul>
      </td>
    </tr>
  </tbody>
</table>

### US 0009

Ordenamiento por fecha ascendente y descendente
<table>
  <tbody>
    <tr>
      <th>Method</th>
      <th>Url</th>
    </tr>
    <tr>
      <td align="center">Get</td>
      <td align="center">
        <ul>
          <li> /products/followed/:userId/list?order=date_asc </li>
          <li> /products/followed/:userId/list?order=date_desc </li>
        </ul>
      </td>
    </tr>
  </tbody>
</table>

---
### TRABAJO INDIVIDUAL

### US 0010

Llevar a cabo la publicación de un nuevo producto en promoción
<table>
  <tbody>
    <tr>
      <th>Method</th>
      <th>Url</th>
      <th>Payload</th>
      <th>Response</th>
    </tr>
    <tr>
      <td align="center">Post</td>
      <td align="center"> /products/promo-post </td>
<td>

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

</td>
    <td align="center">
        <ul>
          <li>200 (Todo OK)</li>
          <li>400 (Bad Request)</li>
        </ul>  
    </td>
    </tr>
  </tbody>
</table>

### US 0011

Obtener la cantidad de productos en promoción de un determinado vendedor

<table>
  <tbody>
    <tr>
      <th>Method</th>
      <th>Url</th>
      <th>Response</th>
    </tr>
    <tr>
      <td align="center">Get</td>
      <td align="center"> /products/promo-post/count?user_id={userId} </td>
<td>

```json
{
  "user_id": 234,
  "user_name": "vendedor1",
  "promo_products_count": 23
}
```

</td>
    </tr>
  </tbody>
</table>

### TRABAJO OPCIONAL

### US 0012

Obtener un listado de todos los productos en promoción de un determinado vendedor

<table>
  <tbody>
    <tr>
      <th>Method</th>
      <th>Url</th>
      <th>Response</th>
    </tr>
    <tr>
      <td align="center">Get</td>
      <td align="center"> /products/promo-post/list?user_id=# </td>
<td>

```json
[
  {
    "user_id": 1,
    "post_id": 1,
    "date": "15-11-2023",
    "product": {
      "product_id": 1,
      "product_name": "Chair",
      "type": "Furniture",
      "brand": "Furniture Co.",
      "color": "White",
      "notes": "Comfortable chair for home or office"
    },
    "category": 1,
    "price": 99.99,
    "has_promo": true,
    "discount": 0.3
  },
  {
    "user_id": 1,
    "post_id": 3,
    "date": "17-12-2023",
    "product": {
      "product_id": 3,
      "product_name": "Sofa",
      "type": "Furniture",
      "brand": "Furniture Co.",
      "color": "Gray",
      "notes": "Modern sofa for living room"
    },
    "category": 1,
    "price": 499.99,
    "has_promo": true,
    "discount": 0.5
  },
  {
    "user_id": 1,
    "post_id": 4,
    "date": "18-11-2023",
    "product": {
      "product_id": 4,
      "product_name": "Lamp",
      "type": "Decor",
      "brand": "Decor Store",
      "color": "White",
      "notes": "Elegant lamp for home decor"
    },
    "category": 1,
    "price": 29.99,
    "has_promo": true,
    "discount": 0.7
  }
]
```
<ul>
          <li>200 (Todo OK)</li>
          <li>400 (Bad Request)</li>
          <li>404 (Not Found)</li>
          <li>406 (Not Acceptable)</li>
        </ul>
</td>
    </tr>
  </tbody>
</table>

### US 0013

Obtener un listado de todos los productos de un determinado vendedor

<table>
  <tbody>
    <tr>
      <th>Method</th>
      <th>Url</th>
      <th>Response</th>
    </tr>
    <tr>
      <td align="center">Get</td>
      <td align="center"> /products/postsByUser?user_id=# </td>
<td>

```json
[
  {
    "user_id": 1,
    "post_id": 1,
    "date": "15-11-2023",
    "product": {
      "product_id": 1,
      "product_name": "Chair",
      "type": "Furniture",
      "brand": "Furniture Co.",
      "color": "White",
      "notes": "Comfortable chair for home or office"
    },
    "category": 1,
    "price": 99.99,
    "has_promo": true,
    "discount": 0.3
  },
  {
    "user_id": 1,
    "post_id": 2,
    "date": "16-11-2023",
    "product": {
      "product_id": 2,
      "product_name": "Desk",
      "type": "Furniture",
      "brand": "Furniture Co.",
      "color": "Black",
      "notes": "Sturdy desk for work or study"
    },
    "category": 2,
    "price": 199.99,
    "has_promo": false,
    "discount": 0.0
  },
  {
    "user_id": 1,
    "post_id": 3,
    "date": "17-12-2023",
    "product": {
      "product_id": 3,
      "product_name": "Sofa",
      "type": "Furniture",
      "brand": "Furniture Co.",
      "color": "Gray",
      "notes": "Modern sofa for living room"
    },
    "category": 1,
    "price": 499.99,
    "has_promo": true,
    "discount": 0.5
  },
  {
    "user_id": 1,
    "post_id": 4,
    "date": "18-11-2023",
    "product": {
      "product_id": 4,
      "product_name": "Lamp",
      "type": "Decor",
      "brand": "Decor Store",
      "color": "White",
      "notes": "Elegant lamp for home decor"
    },
    "category": 1,
    "price": 29.99,
    "has_promo": true,
    "discount": 0.7
  }
]
```
<ul>
          <li>200 (Todo OK)</li>
          <li>400 (Bad Request)</li>
          <li>404 (Not Found)</li>
          <li>406 (Not Acceptable)</li>
        </ul>
</td>
    </tr>
  </tbody>
</table>

### US 0014

Obtener todos los productos publicados

<table>
  <tbody>
    <tr>
      <th>Method</th>
      <th>Url</th>
      <th>Response</th>
    </tr>
    <tr>
      <td align="center">Get</td>
      <td align="center"> /products </td>
<td>

```json
[
  {
    "user_id": 1,
    "post_id": 1,
    "date": "15-11-2023",
    "product": {
      "product_id": 1,
      "product_name": "Chair",
      "type": "Furniture",
      "brand": "Furniture Co.",
      "color": "White",
      "notes": "Comfortable chair for home or office"
    },
    "category": 1,
    "price": 99.99,
    "has_promo": true,
    "discount": 0.3
  },
  {
    "user_id": 1,
    "post_id": 2,
    "date": "16-11-2023",
    "product": {
      "product_id": 2,
      "product_name": "Desk",
      "type": "Furniture",
      "brand": "Furniture Co.",
      "color": "Black",
      "notes": "Sturdy desk for work or study"
    },
    "category": 2,
    "price": 199.99,
    "has_promo": false,
    "discount": 0.0
  },
  {
    "user_id": 1,
    "post_id": 3,
    "date": "17-12-2023",
    "product": {
      "product_id": 3,
      "product_name": "Sofa",
      "type": "Furniture",
      "brand": "Furniture Co.",
      "color": "Gray",
      "notes": "Modern sofa for living room"
    },
    "category": 1,
    "price": 499.99,
    "has_promo": true,
    "discount": 0.5
  },
  {
    "user_id": 1,
    "post_id": 4,
    "date": "18-11-2023",
    "product": {
      "product_id": 4,
      "product_name": "Lamp",
      "type": "Decor",
      "brand": "Decor Store",
      "color": "White",
      "notes": "Elegant lamp for home decor"
    },
    "category": 1,
    "price": 29.99,
    "has_promo": true,
    "discount": 0.7
  },
  {
    "user_id": 2,
    "post_id": 5,
    "date": "03-03-2024",
    "product": {
      "product_id": 5,
      "product_name": "Table",
      "type": "Furniture",
      "brand": "Furniture Co.",
      "color": "Red",
      "notes": "Solid wood table for dining"
    },
    "category": 3,
    "price": 299.99,
    "has_promo": false,
    "discount": 0.0
  },
  {
    "user_id": 2,
    "post_id": 6,
    "date": "04-04-2024",
    "product": {
      "product_id": 6,
      "product_name": "TV Stand",
      "type": "Furniture",
      "brand": "Furniture Co.",
      "color": "Walnut",
      "notes": "TV stand with storage shelves"
    },
    "category": 1,
    "price": 199.99,
    "has_promo": false,
    "discount": 0.0
  },
  {
    "user_id": 3,
    "post_id": 7,
    "date": "21-04-2024",
    "product": {
      "product_id": 7,
      "product_name": "Bookshelf",
      "type": "Furniture",
      "brand": "Furniture Co.",
      "color": "Cherry",
      "notes": "Classic bookshelf for home library"
    },
    "category": 2,
    "price": 149.99,
    "has_promo": true,
    "discount": 0.2
  },
  {
    "user_id": 4,
    "post_id": 8,
    "date": "22-04-2024",
    "product": {
      "product_id": 8,
      "product_name": "Mirror",
      "type": "Decor",
      "brand": "Decor Store",
      "color": "Silver",
      "notes": "Decorative mirror for wall"
    },
    "category": 1,
    "price": 49.99,
    "has_promo": false,
    "discount": 0.0
  },
  {
    "user_id": 4,
    "post_id": 9,
    "date": "23-11-2023",
    "product": {
      "product_id": 9,
      "product_name": "Bed",
      "type": "Furniture",
      "brand": "Furniture Co.",
      "color": "White",
      "notes": "Comfortable bed for a good night's sleep"
    },
    "category": 3,
    "price": 699.99,
    "has_promo": true,
    "discount": 0.95
  },
  {
    "user_id": 4,
    "post_id": 10,
    "date": "24-04-2024",
    "product": {
      "product_id": 10,
      "product_name": "Chair",
      "type": "Furniture",
      "brand": "Furniture Co.",
      "color": "Red",
      "notes": "Modern chair with metal legs"
    },
    "category": 1,
    "price": 79.99,
    "has_promo": false,
    "discount": 0.0
  }
]
```

</td>
    </tr>
  </tbody>
</table>

### US 0015

Obtener productos filtrados por color

<table>
  <tbody>
    <tr>
      <th>Method</th>
      <th>Url</th>
      <th>Response</th>
    </tr>
    <tr>
      <td align="center">Get</td>
      <td align="center"> /products/filter/color/{color} </td>
<td>

```json
[
  {
    "user_id": 2,
    "post_id": 5,
    "date": "03-03-2024",
    "product": {
      "product_id": 5,
      "product_name": "Table",
      "type": "Furniture",
      "brand": "Furniture Co.",
      "color": "Red",
      "notes": "Solid wood table for dining"
    },
    "category": 3,
    "price": 299.99,
    "has_promo": false,
    "discount": 0.0
  },
  {
    "user_id": 4,
    "post_id": 10,
    "date": "24-04-2024",
    "product": {
      "product_id": 10,
      "product_name": "Chair",
      "type": "Furniture",
      "brand": "Furniture Co.",
      "color": "Red",
      "notes": "Modern chair with metal legs"
    },
    "category": 1,
    "price": 79.99,
    "has_promo": false,
    "discount": 0.0
  }
]
```
<ul>
          <li>200 (Todo OK)</li>
          <li>400 (Bad Request)</li>
          <li>204 (No Content)</li>
        </ul>
</td>
    </tr>
  </tbody>
</table>

### US 0016

Obtener Productos filtrados por categoría

<table>
  <tbody>
    <tr>
      <th>Method</th>
      <th>Url</th>
      <th>Response</th>
    </tr>
    <tr>
      <td align="center">Get</td>
      <td align="center"> /products/filter/category/{category} </td>
<td>

```json
[
  {
    "user_id": 1,
    "post_id": 1,
    "date": "15-11-2023",
    "product": {
      "product_id": 1,
      "product_name": "Chair",
      "type": "Furniture",
      "brand": "Furniture Co.",
      "color": "White",
      "notes": "Comfortable chair for home or office"
    },
    "category": 1,
    "price": 99.99,
    "has_promo": true,
    "discount": 0.3
  },
  {
    "user_id": 1,
    "post_id": 3,
    "date": "17-12-2023",
    "product": {
      "product_id": 3,
      "product_name": "Sofa",
      "type": "Furniture",
      "brand": "Furniture Co.",
      "color": "Gray",
      "notes": "Modern sofa for living room"
    },
    "category": 1,
    "price": 499.99,
    "has_promo": true,
    "discount": 0.5
  },
  {
    "user_id": 1,
    "post_id": 4,
    "date": "18-11-2023",
    "product": {
      "product_id": 4,
      "product_name": "Lamp",
      "type": "Decor",
      "brand": "Decor Store",
      "color": "White",
      "notes": "Elegant lamp for home decor"
    },
    "category": 1,
    "price": 29.99,
    "has_promo": true,
    "discount": 0.7
  },
  {
    "user_id": 2,
    "post_id": 6,
    "date": "04-04-2024",
    "product": {
      "product_id": 6,
      "product_name": "TV Stand",
      "type": "Furniture",
      "brand": "Furniture Co.",
      "color": "Walnut",
      "notes": "TV stand with storage shelves"
    },
    "category": 1,
    "price": 199.99,
    "has_promo": false,
    "discount": 0.0
  },
  {
    "user_id": 4,
    "post_id": 8,
    "date": "22-04-2024",
    "product": {
      "product_id": 8,
      "product_name": "Mirror",
      "type": "Decor",
      "brand": "Decor Store",
      "color": "Silver",
      "notes": "Decorative mirror for wall"
    },
    "category": 1,
    "price": 49.99,
    "has_promo": false,
    "discount": 0.0
  },
  {
    "user_id": 4,
    "post_id": 10,
    "date": "24-04-2024",
    "product": {
      "product_id": 10,
      "product_name": "Chair",
      "type": "Furniture",
      "brand": "Furniture Co.",
      "color": "Red",
      "notes": "Modern chair with metal legs"
    },
    "category": 1,
    "price": 79.99,
    "has_promo": false,
    "discount": 0.0
  }
]
```
<ul>
          <li>200 (Todo OK)</li>
          <li>400 (Bad Request)</li>
          <li>204 (No Content)</li>
        </ul>
</td>
    </tr>
  </tbody>
</table>

### US 0017

Obtener Productos cuyo precio sea menor o igual al dado

<table>
  <tbody>
    <tr>
      <th>Method</th>
      <th>Url</th>
      <th>Response</th>
    </tr>
    <tr>
      <td align="center">Get</td>
      <td align="center"> /products/filter/price/{price} </td>
<td>

```json
[
  {
    "user_id": 1,
    "post_id": 1,
    "date": "15-11-2023",
    "product": {
      "product_id": 1,
      "product_name": "Chair",
      "type": "Furniture",
      "brand": "Furniture Co.",
      "color": "White",
      "notes": "Comfortable chair for home or office"
    },
    "category": 1,
    "price": 99.99,
    "has_promo": true,
    "discount": 0.3
  },
  {
    "user_id": 1,
    "post_id": 4,
    "date": "18-11-2023",
    "product": {
      "product_id": 4,
      "product_name": "Lamp",
      "type": "Decor",
      "brand": "Decor Store",
      "color": "White",
      "notes": "Elegant lamp for home decor"
    },
    "category": 1,
    "price": 29.99,
    "has_promo": true,
    "discount": 0.7
  },
  {
    "user_id": 4,
    "post_id": 8,
    "date": "22-04-2024",
    "product": {
      "product_id": 8,
      "product_name": "Mirror",
      "type": "Decor",
      "brand": "Decor Store",
      "color": "Silver",
      "notes": "Decorative mirror for wall"
    },
    "category": 1,
    "price": 49.99,
    "has_promo": false,
    "discount": 0.0
  },
  {
    "user_id": 4,
    "post_id": 10,
    "date": "24-04-2024",
    "product": {
      "product_id": 10,
      "product_name": "Chair",
      "type": "Furniture",
      "brand": "Furniture Co.",
      "color": "Red",
      "notes": "Modern chair with metal legs"
    },
    "category": 1,
    "price": 79.99,
    "has_promo": false,
    "discount": 0.0
  }
]
```
<ul>
          <li>200 (Todo OK)</li>
          <li>400 (Bad Request)</li>
          <li>204 (No Content)</li>
        </ul>
</td>
    </tr>
  </tbody>
</table>

### US 0018

Obtener productos cuyo precio esté entre los valores dados

<table>
  <tbody>
    <tr>
      <th>Method</th>
      <th>Url</th>
      <th>Response</th>
    </tr>
    <tr>
      <td align="center">Get</td>
      <td align="center"> /products/filter/price/{since}/{to} </td>
<td>

```json
[
  {
    "user_id": 1,
    "post_id": 1,
    "date": "15-11-2023",
    "product": {
      "product_id": 1,
      "product_name": "Chair",
      "type": "Furniture",
      "brand": "Furniture Co.",
      "color": "White",
      "notes": "Comfortable chair for home or office"
    },
    "category": 1,
    "price": 99.99,
    "has_promo": true,
    "discount": 0.3
  },
  {
    "user_id": 4,
    "post_id": 8,
    "date": "22-04-2024",
    "product": {
      "product_id": 8,
      "product_name": "Mirror",
      "type": "Decor",
      "brand": "Decor Store",
      "color": "Silver",
      "notes": "Decorative mirror for wall"
    },
    "category": 1,
    "price": 49.99,
    "has_promo": false,
    "discount": 0.0
  },
  {
    "user_id": 4,
    "post_id": 10,
    "date": "24-04-2024",
    "product": {
      "product_id": 10,
      "product_name": "Chair",
      "type": "Furniture",
      "brand": "Furniture Co.",
      "color": "Red",
      "notes": "Modern chair with metal legs"
    },
    "category": 1,
    "price": 79.99,
    "has_promo": false,
    "discount": 0.0
  }
]
```
<ul>
          <li>200 (Todo OK)</li>
          <li>400 (Bad Request)</li>
          <li>204 (No Content)</li>
        </ul>
</td>
    </tr>
  </tbody>
</table>

### US 0019

Obtener productos cuyo descuendo sea mayor o igual al dado

<table>
  <tbody>
    <tr>
      <th>Method</th>
      <th>Url</th>
      <th>Response</th>
    </tr>
    <tr>
      <td align="center">Get</td>
      <td align="center"> /products/filter/discount/{discount} </td>
<td>

```json
[
  {
    "user_id": 1,
    "post_id": 4,
    "date": "18-11-2023",
    "product": {
      "product_id": 4,
      "product_name": "Lamp",
      "type": "Decor",
      "brand": "Decor Store",
      "color": "White",
      "notes": "Elegant lamp for home decor"
    },
    "category": 1,
    "price": 29.99,
    "has_promo": true,
    "discount": 0.7
  },
  {
    "user_id": 4,
    "post_id": 9,
    "date": "23-11-2023",
    "product": {
      "product_id": 9,
      "product_name": "Bed",
      "type": "Furniture",
      "brand": "Furniture Co.",
      "color": "White",
      "notes": "Comfortable bed for a good night's sleep"
    },
    "category": 3,
    "price": 699.99,
    "has_promo": true,
    "discount": 0.95
  }
]
```
<ul>
          <li>200 (Todo OK)</li>
          <li>400 (Bad Request)</li>
          <li>204 (No Content)</li>
        </ul>
</td>
    </tr>
  </tbody>
</table>