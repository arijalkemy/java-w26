# pf-be-hisp-w26-t10-imbachi

# MercadoLibre - Frescos

Bienvenido al sistema de gestión de productos frescos de MercadoLibre. Este proyecto tiene como objetivo expandir el negocio del Marketplace de MercadoLibre para incluir productos que requieren refrigeración, conocidos como productos frescos. A continuación, se detallan las funcionalidades y desafíos que aborda este sistema:

---

## Desafíos y Funcionalidades


1. **Ingreso de Productos al Warehouse de Fulfillment**
    - Registrar la entrada de nuevos lotes de productos frescos en el stock del depósito.
    - Asignar ubicaciones específicas dentro del warehouse según las necesidades de refrigeración y almacenamiento de cada producto.


2. **Gestión de Almacenamiento y Picking**
    - Organizar los productos frescos en áreas refrigeradas del depósito para asegurar su integridad.
    - Facilitar el proceso de picking, donde los colaboradores recolectan los productos para las órdenes de compra.


3. **Gestión de Productos por Vencer**
    - Detectar productos próximos a su fecha de vencimiento y tomar las acciones correspondientes (devolución, liquidación, descuento, etc.).


4. **Consulta y Gestión de Stock**
    - Consultar el stock disponible en cada warehouse de MercadoLibre.
    - Identificar en qué warehouse específico se encuentra un producto fresco determinado.


5. **Registro de Órdenes de Compra**
    - Registrar las órdenes de compra para que los colaboradores del fulfillment puedan preparar y despachar los pedidos.

---

## Proceso de Funcionamiento

- **Ingreso de Productos**: Los vendedores envían sus productos frescos al warehouse de fulfillment de MercadoLibre, donde se registran en el sistema y se asignan ubicaciones adecuadas según sus requisitos de almacenamiento.

- **Gestión de Stock y Ubicación**: Cada producto fresco se etiqueta con información crítica como fecha de caducidad y número de lote, además de ubicarse en áreas específicas dentro del depósito para su correcto mantenimiento.

- **Órdenes de Compra y Despacho**: Cuando se realiza una compra en el Marketplace, se genera una orden de compra que los colaboradores del fulfillment preparan mediante procesos de picking y packing, adaptados para productos frescos.

---

## Endpoints

### Autenticación

- **POST /auth/login**
    - Descripción: Autenticación de usuarios.
    - Ejemplo de solicitud:
      ```json
      {
        "username": "jlaura",
        "password": "12345"
      }
      ```

### Gestión de Inbound Orders

- **POST /api/v1/fresh-products/inboundorder**
    - Descripción: Registrar una nueva orden de entrada.
    - Ejemplo de solicitud:
      ```json
      {
        "inbound_order": {
          "order_number": "1020",
          "order_date": "2024-06-17",
          "section": {
            "section_code": "1",
            "warehouse_code": "1"
          },
          "batch_stock": [
            {
              "batch_number": "1",
              "product_id": "1",
              "current_temperature": "32.1",
              "minimum_temperature": "31.0",
              "initial_quantity": "4",
              "current_quantity": "7",
              "manufacturing_date": "2024-06-17",
              "manufacturing_time": "09:00:05",
              "due_date": "2025-06-17"
            }
          ]
        }
      }
      ```

- **PUT /api/v1/fresh-products/inboundorder**
    - Descripción: Actualizar una orden de entrada existente.
    - Ejemplo de solicitud:
      ```json
      {
        "inbound_order": {
          "order_number": "1020",
          "order_date": "2024-06-17",
          "section": {
            "section_code": "1",
            "warehouse_code": "1"
          },
          "batch_stock": [
            {
              "batch_number": "1989",
              "product_id": "1",
              "current_temperature": "42.1",
              "minimum_temperature": "41.0",
              "initial_quantity": "4",
              "current_quantity": "7",
              "manufacturing_date": "2024-06-17",
              "manufacturing_time": "09:00:05",
              "due_date": "2025-06-17"
            }
          ]
        }
      }
      ```

### Listado de Productos Frescos

- **GET /api/v1/fresh-products/list?category=FF**
    - Descripción: Obtener una lista de productos frescos por categoría.
    - Ejemplo de solicitud:
      ```http
      GET http://localhost:8080/api/v1/fresh-products/list?category=FF
      ```

### Órdenes de Compra

- **POST /api/v1/fresh-products/orders**
    - Descripción: Registrar una nueva orden de compra.
    - Ejemplo de solicitud:
      ```json
      {
        "purchase_order": {
          "date": "16-06-2024",
          "buyer_id": "11",
          "order_status": {
            "status_code": "shopping_cart"
          },
          "products": [
            {
              "product_id": "100",
              "quantity": "3"
            }
          ]
        }
      }
      ```

- **GET /api/v1/fresh-products/orders/1**
    - Descripción: Obtener los detalles de una orden de compra específica.
    - Ejemplo de solicitud:
      ```http
      GET http://localhost:8080/api/v1/fresh-products/orders/1
      ```

- **PUT /api/v1/fresh-products/orders/1**
    - Descripción: Actualizar una orden de compra existente.
    - Ejemplo de solicitud:
      ```json
      {
        "purchase_order": {
          "date": "1995-10-10T00:00:00Z",
          "buyer_id": 1,
          "order_status": {
            "status_code": "shopping_cart"
          },
          "products": [
            {
              "product_id": 1,
              "quantity": 12
            },
            {
              "product_id": 2,
              "quantity": 30
            }
          ]
        }
      }
      ```

### Gestión de Stock

- **GET /api/v1/fresh-products/1/batch/list?order=L**
    - Descripción: Listar lotes de productos frescos ordenados por algún criterio.
    - Ejemplo de solicitud:
      ```http
      GET http://localhost:8080/api/v1/fresh-products/1/batch/list?order=L
      ```

- **GET /api/v1/fresh-products/1/warehouse/list**
    - Descripción: Listar los productos frescos disponibles en un warehouse específico.
    - Ejemplo de solicitud:
      ```http
      GET http://localhost:8080/api/v1/fresh-products/1/warehouse/list
      ```

- **GET /api/v1/fresh-products/batch/list/due-date/50**
    - Descripción: Listar lotes de productos frescos próximos a vencer.
    - Ejemplo de solicitud:
      ```http
      GET http://localhost:8080/api/v1/fresh-products/batch/list/due-date/50
      ```

### Gestión de Productos

- **POST /api/v1/fresh-products/product**
    - Descripción: Registrar un nuevo producto fresco.
    - Ejemplo de solicitud:
      ```json
      {
        "id": "15",
        "name": "Item Generico",
        "price": 20.0,
        "category": 2
      }
      ```

---

Este sistema está diseñado para optimizar la gestión y distribución de productos frescos dentro de MercadoLibre, asegurando que los usuarios tengan acceso a productos de alta calidad y en óptimas condiciones. ¡Gracias por colaborar con nosotros para democratizar el comercio electrónico en LATAM!

---

**Equipo de Desarrollo de MercadoLibre** 
- **Nicolas Imbachi**
- **Nicolas Hoyos**
- **Mateo Caldera**
- **Luis Meza**
- **Juan Gonzalez**
- **Jose Guzman**
- **John Garcia**

*Fecha: 19-06-2024*

---
# Fury Information

### SCOPE

The suffix of each Fury **SCOPE** is used to know which properties file to use, it is identified from the last '-' of the name of the scope.

If you want to run the application from your development IDE, you need to configure the environment variable **SCOPE=local** in the app luncher.

The properties of **application.yml** are always loaded and at the same time they are complemented with **application-<SCOPE_SUFFIX>.yml** properties. If a property is in both files, the one that is configured in **application-<SCOPE_SUFFIX>.yml** has preference over the property of **application.yml**.

For example, for the **SCOPE** 'items-loader-test' the **SCOPE_SUFFIX** would be 'test' and the loaded property files will be **application.yml** and **application-test.yml**

### Web Server

Each Spring Boot web application includes an embedded web server. For servlet stack applications, Its supports three web Servers:
  * Tomcat (maven dependency: `spring-boot-starter-tomcat`)
  * Jetty (maven dependency: `spring-boot-starter-jetty`)
  * Undertow (maven dependency: `spring-boot-starter-undertow`)

This project is configured with Jetty, but to exchange WebServer, it is enough to configure the dependencies mentioned above in the pom.xml file.

### Main

The main class for this app is Application, where Spring context is initialized and SCOPE_SUFFIX is generated.

### Error Handling

We also provide basic handling for exceptions in ControllerExceptionHandler class.

## API Documentation

This project uses OpenAPI to automate the generation of machine and human readable specifications for JSON APIs written using Spring. OpenAPI works by examining an application, once, at runtime to infer API semantics based on spring configurations, class structure and various compile time java Annotations.

You can change this configuration in SpringDocConfig class.

### Fury Specs Hub

To simplify the management and maintainability of your API specs, we present [Fury Specs Hub](https://furydocs.io/specs-hub/latest/guide/#/). Fury Specs Hub is a new service from Fury that aims to be a one-stop solution for API definition. With Specs Hub, you will be able to:
- Define your APIs using OpenAPI or AsyncAPI.
- Automate the configuration and generation of your API specs with the help of new commands from the Fury CLI.
- Have all your specs in one place for visualization and management.
- Share them with other teams.
- Find available APIs based on the information you need.
- Usage documentation [Fury Specs Hub - Getting started](https://furydocs.io/specs-hub/latest/guide/#/tutorial/).

#### Usage guide fast reference

1. [Installing the Specs Hub plugin for Fury CLI.](https://furydocs.io/specs-hub/latest/guide/#/tutorial/install-specs-hub-furycli)
2. [Installing the OpenAPI plugin and initializing a basic configuration.](https://furydocs.io/specs-hub/latest/guide/#/tutorial/install-open-api)
3. [Generating your first API specification.](https://furydocs.io/specs-hub/latest/guide/#/tutorial/generate-open-api-spec)
4. [Validating your API specification.](https://furydocs.io/specs-hub/latest/guide/#/tutorial/validate-specs)
5. [Uploading your first specification.](https://furydocs.io/specs-hub/latest/guide/#/tutorial/upload-spec)
6. [Viewing your specification in Fury web.](https://furydocs.io/specs-hub/latest/guide/#/tutorial/view-spec)
7. [Managing your specification in Fury web.](https://furydocs.io/specs-hub/latest/guide/#/tutorial/manage-spec)

## [Release Process](https://release-process.furycloud.io/#/)

### Usage

1. Specify the correct tag for your app in your `Dockerfile` and `Dockerfile.runtime`, according to the desired Java runtime version.

```
# Dockerfile
FROM hub.furycloud.io/mercadolibre/java:17-mini
```

You can find all available tags for your `Dockerfile` [here](https://github.com/mercadolibre/fury_java-mini#supported-tags)

```
# Dockerfile.runtime
FROM hub.furycloud.io/mercadolibre/java:17-runtime-mini
```

You can find all available tags for your `Dockerfile.runtime` [here](https://github.com/mercadolibre/fury_java-mini-runtime#supported-tags)

2. Start coding!

### Questions

[Release Process Issue Tracker](https://github.com/mercadolibre/fury_release-process/issues)
