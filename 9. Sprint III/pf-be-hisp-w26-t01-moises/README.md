# pf-be-hisp-w26-t01-moises


## Autenticación

Para interactuar con los endpoints, es necesaria la autenticación. En el caso del endpoint desarrollado, se requere el uso de un `Buyer` con pedidos de compra existentes.


**Credenciales de comprador:**
- Email: eliana@gmail.com
- Contraseña: eliana

## Endpoints

### User Story de los endpoints mencionados abajo:
https://drive.google.com/file/d/12XS4gZPNTvA1vtpYqrVThBKVfFjWqVvX/view?usp=sharing

### GET /api/v1/fresh-products/orders/own?sort={date,total}

Este endpoint permite la consulta de pedidos de compra correspondientes a un buyer. Se filtraran en base al token que se envia para autenticar la peticion. Se ordenaran a partir del parametro sort

**Response:**

json
```
[
 {
     "id_purchase_order": "Integer",
     "date":"yyyy-MM-dd",
     "order_status": {
         "status_code": "String"
     },
     "products":[
         {
             "name":"String",
             "quantity":"Integer"
         }
     ],
     "total_price": "Double"	
 }
]
```

## Uso

Utiliza herramientas como Postman o CURL para interactuar con la API. Asegúrate de incluir las credenciales adecuadas para los roles de usuario correspondientes.

## Consideraciones de Seguridad

Asegúrate de que las credenciales de usuario no sean expuestas y que la comunicación con la API se realice a través de HTTPS, protegiendo así la privacidad e integridad de los datos transmitidos.
