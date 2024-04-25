

# Bonus (Desarrollo individual extra)

## US 0012

Obtener listado de productos que tienen en promoción los vendedores
seguidos por un usuario, informando también el precio con descuento.

Esto es una extensión del requerimiento US 0006.

Method: GET  
URL: `/products/followed/{userId}/list?has_promo=true`  
Ejemplo: `/products/4/followed/list?has_promo=true`  

Response:
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
      "price": 2800.69,
      "discount": 0.1,
      "price_with_discount": 2520.62
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
      "price": 15000.50,
      "discount": 0.15,
      "price_with_discount": 12750.43
    }
  ]
}
```
