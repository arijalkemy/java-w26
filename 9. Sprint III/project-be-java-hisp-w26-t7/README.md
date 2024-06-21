# project-be-java-hisp-w26-t7

# Spring Boot App model for Java 17

## Diagrama Entidad Relacion

![image](https://github.com/melisource/fury_project-be-java-hisp-w26-t7/assets/164009961/780313aa-cec3-45b5-b4da-2091eb0dc29c)

## Diagrama Relacional

![image](https://github.com/melisource/fury_project-be-java-hisp-w26-t7/assets/164009961/c8833520-593b-432f-bc97-1c7c0a228648)

## Arquitectura Multicapa

![image](https://github.com/melisource/fury_project-be-java-hisp-w26-t7/assets/164009961/af6fb8d2-7a0c-4e55-a230-4e8dd5e11c85)

## Despliegue de la API

![image](https://github.com/melisource/fury_project-be-java-hisp-w26-t7/assets/164009961/d4c9c289-0f0a-48fc-9b52-0f19ab735aae)

## Diagrama de clases

![image](https://github.com/melisource/fury_project-be-java-hisp-w26-t7/assets/164009961/11913196-2991-4515-8ef3-25677f3c0827)

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