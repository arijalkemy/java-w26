# project-be-java-hisp-w26-t7

# Spring Boot App model for Java 17

## Diagrama Entidad Relacion

![image](https://github.com/arijalkemy/java-w26/assets/166527186/f90f1c74-2c74-47d1-afe4-72e1dd656987)


## Diagrama Relacional

![image](https://github.com/arijalkemy/java-w26/assets/166527186/a28bde82-7256-4796-9347-026997df934b)

## Arquitectura Multicapa

![image](https://github.com/arijalkemy/java-w26/assets/166527186/a26eab57-2066-41ed-8be1-c66031027096)

## Despliegue de la API

![image](https://github.com/arijalkemy/java-w26/assets/166527186/d4473fc7-61cd-44e6-abfd-cf9756358058)

## Diagrama de clases

![image](https://github.com/arijalkemy/java-w26/assets/166527186/864f9a47-3966-42b5-9b1e-3dd79c34066f)

## Requerimiento 1

Es necesario tener un token de REPRESENTATIVE

<table>
    <thead>
        <tr>
            <th>Method</th>
            <th>Endpoint</th>
            <th>Body</th>
            <th>Response</th>
        </tr>
    </thead>
    <tr>
        <td>POST</td>
<td>

`/api/v1/fresh-products/inboundorder`

</td>
<td>

```
{
    "inbound_order": {
        "order_number": 1,
        "order_date": "10-06-2024",
        "section": {
            "section_code": 7,
            "warehouse_code": 3
        },
        "batch_stock": [
            {
                "batch_number": 20,
                "product_id": 2,
                "current_temperature": 4.4,
                "minimum_temperature": 4.3,
                "initial_quantity": 10,
                "current_quantity": 10,
                "manufacturing_date": "01-04-2024",
                "manufacturing_time": "01-04-2024 12:30:32",
                "due_date": "25-02-2025"
            },
            {
                "batch_number": 30,
                "product_id": 3,
                "current_temperature": 3.4,
                "minimum_temperature": 2.3,
                "initial_quantity": 30,
                "current_quantity": 30,
                "manufacturing_date": "19-04-2024",
                "manufacturing_time": "23-04-2024 12:30:32",
                "due_date": "30-01-2025"
            }
        ]
    }
}
```

</td>
<td>
<ul>
<li>
201 Created
</li>
<li>
404 Not Found
</li>
<li>
401 Unauthorized
</li>
<li>
403 Forbidden
</li>
</ul>
</td>
    </tr>
    <tr>
        <td>PUT</td>
<td>

`/api/v1/fresh-products/inboundorder`

</td>
<td>

```
{
    "inbound_order": {
        "order_number": 1,
        "order_date": "10-06-2024",
        "section": {
            "section_code": 7,
            "warehouse_code": 3
        },
        "batch_stock": [
            {
                "batch_number": 20,
                "product_id": 2,
                "current_temperature": 4.4,
                "minimum_temperature": 4.3,
                "initial_quantity": 10,
                "current_quantity": 10,
                "manufacturing_date": "01-04-2024",
                "manufacturing_time": "01-04-2024 12:30:32",
                "due_date": "25-02-2025"
            },
            {
                "batch_number": 30,
                "product_id": 3,
                "current_temperature": 3.4,
                "minimum_temperature": 2.3,
                "initial_quantity": 30,
                "current_quantity": 30,
                "manufacturing_date": "19-04-2024",
                "manufacturing_time": "23-04-2024 12:30:32",
                "due_date": "30-01-2025"
            }
        ]
    }
}
```

</td>
<td>
<ul>
<li>
201 Created
</li>
<li>
404 Not Found
</li>
<li>
401 Unauthorized
</li>
<li>
403 Forbidden
</li>
</ul>
</td>
    </tr>
</table>

## Requerimiento 2

<table>
    <thead>
        <tr>
            <th>Method</th>
            <th>Endpoint</th>
            <th>Body</th>
            <th>Response</th>
        </tr>
    </thead>
    <tr>
        <td>GET</td>
<td>

`/api/v1/fresh-products/list`

</td>
<td>N/A</td>
<td>
<ul>
<li>
200 OK
</li>
<li>
404 Not Found
</li>
<li>
401 Unauthorized
</li>
<li>
403 Forbidden
</li>
</ul>
</td>
    </tr>
    <tr>
        <td>GET</td>
<td>

`/api/v1/fresh-products/list?category={FS, RF, FF}`

</td>
<td>N/A</td>
<td>
<ul>
<li>
200 OK
</li>
<li>
404 Not Found
</li>
<li>
401 Unauthorized
</li>
<li>
403 Forbidden
</li>
</ul>
</td>
    </tr>
<tr>
        <td>POST</td>
<td>

`/api/v1/fresh-products/orders`

</td>
<td>

```
{
    "purchase_order": {
        "date": "13-06-2024",
        "buyer_id": 4,
        "order_status": {
            "status_code": "carrito"
        },
        "products": [
            {
                "product_id": 1,
                "quantity": 5
            }
        ]
    }
}
```

</td>
<td>
<ul>
<li>
201 Created
</li>
<li>
404 Not Found
</li>
<li>
401 Unauthorized
</li>
<li>
403 Forbidden
</li>
</ul>
</td>
    </tr>
<tr>
        <td>GET</td>
<td>

`/api/v1/fresh-products/orders/:idOrder`

</td>
<td>N/A</td>
<td>
<ul>
<li>
200 OK
</li>
<li>
404 Not Found
</li>
<li>
401 Unauthorized
</li>
<li>
403 Forbidden
</li>
</ul>
</td>
    </tr>
<tr>
        <td>PUT</td>
<td>

`/api/v1/fresh-products/orders/:idOrder`

</td>
<td>

```
{
    "purchase_order": {
        "date": "13-06-2024",
        "buyer_id": 1,
        "order_status": {
            "status_code": "carrito"
        },
        "products": [
            {
                "product_id": 1,
                "quantity": 9
            }
        ]
    }
}
```

</td>
<td>
<ul>
<li>
201 Created
</li>
<li>
404 Not Found
</li>
<li>
401 Unauthorized
</li>
<li>
403 Forbidden
</li>
</ul>
</td>
    </tr>
</table>

### Requerimiento 3

<table>
    <thead>
        <tr>
            <th>Method</th>
            <th>Endpoint</th>
            <th>Body</th>
            <th>Response</th>
        </tr>
    </thead>
    <tr>
        <td>GET</td>
<td>

`/api/v1/fresh-products/:idProduct}/batch/list`

</td>
<td>N/A</td>
<td>
<ul>
<li>
200 OK
</li>
<li>
404 Not Found
</li>
<li>
401 Unauthorized
</li>
<li>
403 Forbidden
</li>
</ul>
</td>
    </tr>
    <tr>
        <td>GET</td>
<td>

`/api/v1/fresh-products/:idProduct}/batch/list?order={L, C, F}`

</td>
<td>N/A</td>
<td>
<ul>
<li>
200 OK
</li>
<li>
404 Not Found
</li>
<li>
401 Unauthorized
</li>
<li>
403 Forbidden
</li>
</ul>
</td>
    </tr>
</table>

### Requerimiento 4

<table>
    <thead>
        <tr>
            <th>Method</th>
            <th>Endpoint</th>
            <th>Body</th>
            <th>Response</th>
        </tr>
    </thead>
    <tr>
        <td>GET</td>
<td>

`/api/v1/fresh-products/:idProduct/warehouse/list`

</td>
<td>N/A</td>
<td>
<ul>
<li>
200 OK
</li>
<li>
404 Not Found
</li>
<li>
401 Unauthorized
</li>
<li>
403 Forbidden
</li>
</ul>
</td>
    </tr>
</table>

### Requerimiento 5

<table>
    <thead>
        <tr>
            <th>Method</th>
            <th>Endpoint</th>
            <th>Body</th>
            <th>Response</th>   
        </tr>
    </thead>
    <tr>
        <td>GET</td>
<td>

`/api/v1/fresh-products/batch/list/due-date/:cantDays`

</td>
<td>N/A</td>
<td>
<ul>
<li>
200 OK
</li>
<li>
404 Not Found
</li>
<li>
401 Unauthorized
</li>
<li>
403 Forbidden
</li>
</ul>
</td>
    </tr>
<tr>
        <td>GET</td>
<td>

`/api/v1/fresh-products/batch/list/due-date/:cantDays?category={FS, RF, FF}&order={date_asc, date_desc}`

</td>
<td>N/A</td>
<td>
<ul>
<li>
200 OK
</li>
<li>
404 Not Found
</li>
<li>
401 Unauthorized
</li>
<li>
403 Forbidden
</li>
</ul>
</td>
    </tr>
</table>

### Autorizacion

Creamos un endpoint a manera de ejemplo para generar los tokens
<table>
    <thead>
        <tr>
            <th>Method</th>
            <th>Endpoint</th>
            <th>Body</th>
        </tr>
    </thead>
    <tr>
        <td>GET</td>
<td>

`/authenticate/:role/:id`

</td>
<td>N/A</td>
    </tr>
</table>

## Bonus

### Requerimiento 6

<table>
<thead>
<tr>
<th>Method</th>
<th>Endpoint</th>
<th>Body</th>
<th>Response</th>
</tr>
</thead>
<tr>
<td>POST</td>
<td>

`/api/v1/fresh-products/:sellerId`

</td>
<td>

```
{
    "products":[
        {
            "price": 12.2,
            "description": "Lemon",
            "storage_type": "Fresco"
        },
        {
            "price": 23.5,
            "description": "Carne",
            "storage_type": "Congelado"
        }
    ]
}
```

</td>
<td>
<ul>
<li>
201 Created
</li>
<li>
404 Not Found
</li>
<li>
401 Unauthorized
</li>
<li>
403 Forbidden
</li>
</ul>
</td>
    </tr>
<tr>
<td>PUT</td>
<td>

`/api/v1/fresh-products/:sellerId`

</td>
<td>

```
{
    "products":[
        {
            "price": 23.5,
            "description": "Carne",
            "storage_type": "Congelado"
        },
        {
            "price": 57.9,
            "description": "Naranja",
            "storage_type": "Congelado"
        }
    ]
}
```

</td>
<td>
<ul>
<li>
201 Created
</li>
<li>
404 Not Found
</li>
<li>
401 Unauthorized
</li>
<li>
403 Forbidden
</li>
</ul>
</td>
    </tr>
</table>

### Requerimiento 7
<table>
<thead>
<tr>
<th>Method</th>
<th>Endpoint</th>
<th>Body</th>
<th>Response</th>
</tr>
</thead>
<tr>
<td>DELETE</td>
<td>

`/api/v1/fresh-products/inboundorder/batch/:batchNumber/product/:productId`

</td>
<td>N/A</td>
<td>
<ul>
<li>
200 OK
</li>
<li>
404 Not Found
</li>
<li>
401 Unauthorized
</li>
<li>
403 Forbidden
</li>
</ul>
</td>
    </tr>
<tr>
<td>GET</td>
<td>

`/api/v1/fresh-products/batch/section/{sectionId}/temperature-average`

</td>
<td>N/A</td>
<td>
<ul>
<li>
200 OK
</li>
<li>
404 Not Found
</li>
<li>
401 Unauthorized
</li>
<li>
403 Forbidden
</li>
</ul>
</td>
    </tr>
</table>
