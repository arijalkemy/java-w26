README
# Proyecto final Equipo 6 - PARTE INDIVIDUAL

Se agrega la funcionalidad para registrar un usuario siendo SUPERADMIN.
Se agrega la funcionalidad para transladar batches de un warehouse a otro y actualizar su estado.


Se agregan 3 endpoints nuevos:
1. POST /api/v1/users/register -> Registra a un usuario siendo SUPERADMIN
2. POST /api/v1/fresh-products/outboundorder -> Para iniciar la transferencia de batches de un warehouse a otro
3. PUT /api/v1/fresh-products/outboundorder/{order_number}?status={status} -> Para actualizar el estado de una orden
de transferencia

Request JSON endpoint 1:
{
    "username": "supervisor1",
    "name": "supervisor1",
    "password": "supervisor1",
    "rol": "SUPERVISOR"
}

Request JSON endpoint 2:
{
    "outbound_order": {
        "outbound_order_number": 2,
        "warehouse_origin_code": 2,
        "warehouse_destination_code": 1,
        "batches": [
            {"batch_number": 1},
            {"batch_number": 2}
        ]
    }
}