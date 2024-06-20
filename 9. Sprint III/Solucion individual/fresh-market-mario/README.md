# Gestión de Devoluciones - API de MercadoLibre

Esta API ofrece una solución integral para la gestión de devoluciones de productos frescos en la plataforma de MercadoLibre. Permite a los compradores solicitar devoluciones cuando los productos no llegan en condiciones óptimas, así como a los colaboradores revisar, actualizar y gestionar el estado de estas devoluciones. Además, proporciona funcionalidades para que los compradores consulten el estado de sus solicitudes y para que los colaboradores visualicen y filtren todas las devoluciones disponibles.

## Funcionalidades Principales

- **Creación de Solicitud de Devolución:** Los compradores pueden solicitar devoluciones proporcionando los detalles del pedido y el motivo de la devolución.

- **Revisión de Solicitud de Devolución:** Los colaboradores pueden revisar y actualizar el estado de las solicitudes de devolución, incluyendo comentarios sobre la acción realizada.

- **Consulta de Estado de Solicitud de Devolución:** Los compradores pueden verificar el estado de sus solicitudes de devolución, mostrando detalles como motivo, comentarios y marca de tiempo.

- **Listado de Solicitudes de Devolución:** Los colaboradores pueden visualizar todas las solicitudes de devolución disponibles, con la opción de filtrar por estado si es necesario.

## Endpoints Disponibles

### Crear una solicitud de devolución
- Método: POST
- URI: /api/v1/fresh-products/return
- Código de la User Story: ml-return-crud-01

### Revisar solicitud de devolución
- Método: PUT
- URI: /api/v1/fresh-products/return/{returnId}
- Código de la User Story: ml-return-crud-02

### Consultar Estado de Solicitud de Devolución
- Método: GET
- URI: /api/v1/fresh-products/return/{returnId}
- Código de la User Story: ml-return-crud-03

### Listar todas las solicitudes de devolución
- Métodos:
  - GET /api/v1/fresh-products/return
  - GET /api/v1/fresh-products/return?status={status}
- Código de la User Story: ml-return-crud-04

## Contratos y Especificaciones

Se proporcionan plantillas URI, descripciones de los endpoints, representaciones JSON de request y response, así como códigos de User Story asociados a cada funcionalidad. Para más detalles sobre cómo interactuar con cada endpoint, consulta la documentación completa en el archivo de especificaciones.
