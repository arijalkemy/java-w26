# pf-be-hisp-w26-t01-ditta


Esta API es responsable de la gestión de almacenes. Dispone de dos principales endpoints para crear y modificar la información asociada a los almacenes.

## Autenticación

Para interactuar con los endpoints, es necesaria la autenticación.

**Credenciales:**
- Email: juan@gmail.com
- Contraseña: juan


## Endpoints

### User Story de los endpoints mencionados abajo:
https://docs.google.com/document/d/1uYDwtLpEAV2Vk7wny8gsXbVdqyblaYWuQJXwBkrElFw/edit?usp=sharing

### POST /api/v1/fresh-products/sections

Este endpoint permite la creación de una nueva sección dentro del warehouse del usuario logueado.

**Request:**

json
{
	“id_section”:”Integer”,
	“category”: “Integer”,
	“max_batch_capacity” :”Integer”	
}



### GET /api/v1/fresh-products/sections

Este endpoint permite obtener datos de las secciones del warehouse del usuario logueado.


**Response:**

json
{
"idSection": "Integer",
"nameWarehouse": "String",
"nameCategory": "String",
"maxBatchCapacity": "Integer"
}



## Modelo de Datos

### Clases de Request y Response

**SectionRequestDTO**
- `idSection`: Número de seccion
- `idCategory`: Número de categoria
- `maxBatchCapacity`: Capacidad máxima de lote

**SectionResponseDTO**
- `idSection`: Número de seccion
- `nameWarehouse`: Nombre del warehouse
- `nameCategory`: Nombre de la categoria
- `maxBatchCapacity`: Capacidad máxima de lote


## Uso

Utiliza herramientas como Postman o CURL para interactuar con la API. Asegúrate de incluir las credenciales adecuadas para los roles de usuario correspondientes.

## Consideraciones de Seguridad

Asegúrate de que las credenciales de usuario no sean expuestas y que la comunicación con la API se realice a través de HTTPS, protegiendo así la privacidad e integridad de los datos transmitidos.

