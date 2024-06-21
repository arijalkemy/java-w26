# **pf-be-hisp-w26-t01-cassini**

Esta API es responsable de la gestión de almacenes. Dispone de 3 endpoints principales utilizados para poder llevar a cabo un
control de la temperatura de los lotes disponibles y poder visualizar aquellos que se encuentren por encima de la temperatura mínima, y un tercero
que permite modificar la temperatura actual del lote en caso que haber efectuado una acción correctiva.


## Autenticación

Para interactuar con los endpoints, es necesaria la autenticación. Los usuarios con rol Admin tienen acceso completo, mientras que los usuarios con otros roles, como Buyer, pueden tener restricciones de acceso.

Credenciales de administrador:

Email: juan@gmail.com
Contraseña: juan
Credenciales de comprador (sin permisos de administrador):

Email: eliana@gmail.com
Contraseña: juan

## Endpoints

User Story de los endpoints mencionados abajo:
https://drive.google.com/file/d/1EaAJfVMtg3KpliS0CFg2AHnKhILUS1AV/view

GET /api/v1/fresh-products/batch/{idProduct}/wrongTemperature/list
Este endpoint permite obtener una lista de lotes que tenga una temperatura actual por encima de la temperatura mínima aceptada.

Opcional
/api/v1/fresh-products/batch/{idProduct}/wrongTemperature/list?order={L, T, C}
Al endpoint anterior se le puede agregar el ordenamiento para que a la lista de lotes obtenida se los pueda ordenar por
L=lote
T= temperatura
C= cantidad actual

Response:

json {
product_id: 1,
batch_stock: [
{
batch_number: 1,
current_temperature: 25.0,
minimum_temperature: 20.0,
degrees_above_minimum: 5.0,
current_quantity: 70
},
{
batch_number: 5,
current_temperature: 24.0,
minimum_temperature: 17.0,
degrees_above_minimum: 7.0,
current_quantity: 30
},
{
batch_number: 6,
current_temperature: 24.0,
minimum_temperature: 17.0,
degrees_above_minimum: 7.0,
current_quantity: 12
}
]
}


PUT /api/v1/fresh-products/batch/{idBatch}
Este endpoint permite modificar el lote con id {idBatch} actualizando la temperatura como acción correctiva tomada por el representante.

Request:

json {
new_temperature: 16.0
}
Response:
{
batch_number: 1,
product_id: 1,
current_temperature: 16.0,
minimum_temperature: 20.0,
initial_quantity: 100,
current_quantity: 70,
manufacturing_date: 05-10-2022,
manufacturing_time: 05-10-2022T10:00:00,
due_date: 01-04-2025
}


Modelo de Datos
Clases de Request y Response

GET
Response
BatchWrongTemperatureRespDTO

product_id: Id de producto
batch_stock: Lista de BatchWrongTemperatureDTO

BatchWrongTemperatureDTO
batch_number: nro de lote
current_temperature: temperatura actual
minimum_temperature: temperatura mínima
degrees_above_minimum: grados por encima de lo permitido
current_quantity: cantidad actual

UPDATE

BatchWrongTemperatureDTO

new_temperature: nueva temperatura del lote después de la acción correctiva

BatchStockDTO

batch_number: número de lote
product_id: id de producto
current_temperature: temperatura actual después de la modificación
minimum_temperature: mínima temperatura aceptada
initial_quantity: cantidad inicial del lote
current_quantity: cantidad actual del lote
manufacturing_date: fecha de elaboración
manufacturing_time: hora de elaboración
due_date: fecha de vencimiento


Utiliza herramientas como Postman o CURL para interactuar con la API. Asegúrate de incluir las credenciales adecuadas para los roles de usuario correspondientes.

Consideraciones de Seguridad
Asegúrate de que las credenciales de usuario no sean expuestas y que la comunicación con la API se realice a través de HTTPS, protegiendo así la privacidad e integridad de los datos transmitidos.
