# Requerimiento n°6

This code represents an enhancement of the code developed collaboratively by Group 4. The functionality to put a product on promotion was added, allowing an existing product to be set with a unique discount valid until a specified date. This action can be performed by a seller, making their product appear on the Mercado Libre marketplace and subsequently available to future buyers.


## Authors

- [@Facundo Molina Perera](https://github.com/fmolinaperer_meli)


## User Story
#### Escenario 1
* COMO Seller QUIERO registrar un producto existente   PARA que pueda ser registrado como un producto en promocion.
* ESCENARIO 1: El product está registrado
* DADO QUE El product está registrado Y El Seller está registrado Y Que el producto exista Y Que la fecha de fin de promo sea menor a la fecha de vencimiento del lote
* CUANDO El Seller coloca el producto en promoción
* ENTONCES El producto promo se registra en el sistema Y se asocia con la lista de productos en promoción

#### Escenario 2
* COMO Buyer QUIERO obtener la lista de productos en promoción PARA visualizar los productos en promoción
* ESCENARIO 1: Existen los productos en promoción
* DADO QUE Existen los productos Y El Buyer está registrado Y Que la lista de productos en promoción existan Y Que la fecha de fin de promo sea menor a la fecha de vencimiento del lote
* CUANDO El Buyer consulta la lista de productos en promoción
* ENTONCES Se muestra la lista de los productos en promoción
## API Reference

#### Set product as promo product

```http
  GET /api/v1/fresh-products//product/{id}/promo/{porcentage}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` | `Long` | **Required**. the product id |
| `porcentage` | `Double` | **Required**. the porcentage of discount 

#### Return:
{
“product_id": Long",
“product_type": product_type,
“product_description”: “string” ,
“product_price_original”: “Double” ,
“product_price_promo”: “Double” ,
“product_start_date”: “LocalDate” ,
“product_start_end”: “LocalDate”
}



#### Get list of promo product

```http
  GET /api/v1/fresh-products/product_promo/list
```


#### Return

Response
{  [
“product_id": Long",
“product_type": product_type,
“product_description”: “string” ,
“product_price_original”: “Double” ,
“product_price_promo”: “Double” ,
“product_start_date”: “LocalDate” ,
“product_start_end”: “LocalDate”
]
}

