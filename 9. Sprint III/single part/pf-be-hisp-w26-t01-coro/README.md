# pf-be-hisp-w26-t01-coro

# Parte singular, sprint 3

Este repositorio contiene todo lo referido al punto individual del sprint 3 del
desarrollador Juan Manuel Coro Reader.

Adjuntamos el [Der](hhttps://drive.google.com/file/d/1zT9KwaFFOLvse49S7XmNgVel78OaiqoO/view?usp=sharing).
El archivo [Sql] (https://drive.google.com/file/d/1Jfu3G0YtiryhjLVtEu_-LSOSl96_9n3b/view?usp=sharing) para pre cargar la base de datos.
El [Json] (https://drive.google.com/file/d/1Vz8ayCCS3IuDgz5bM7ahY5KYh_ewxEK6/view?usp=sharing) para importar en Postman.
y las [User-History] (https://drive.google.com/file/d/1wVRYLjH0HaO3xvxXBhKZfVB2D1nJEHO2/view?usp=sharing) referentes a este requerimiento.



## Requerimiento 6 individual

## Uso

Para probar este proyecto debemos correrlo con spring en local, esto nos creara una base de datos en memoria con H2, deberemos entrar a http://localhost:8081/h2-console y cargar el archivo Sql mencionado mas arriba.
Una vez cargado este archivo tendremos que registrarnos en el enpoint que importamos crearemos un usuario cmabiando a nuestro gusto los parametros en el body.
Con todo estio estamos listos para probar el proyecto

## Endpoint

En este caso se requirio de un solo endpoint, el cual se encuentra en una coleccion en postman que se puede importar a nuestro cliente usando el archivo mencionado mas arriba.

Para probarlo deberemos cambiar en la coleccion o la llamada de nombre "PostWarehouse" el valor de la autenticacion, con el token obtenido en el register en el paso anterior

#### {{Local}}/api/v1/fresh-products/warehouse -> probara el endpoint en local
#### {{Fury}}api/v1/fresh-products/warehouse -> probara el endpoint en fury

en el endpoint podremos encontrar el body ya cargado donde podremos editarlo a nuestro gusto, si el mail del usuario se encunetra cargado se asignara al warehouse que creemos, de caso contrario creara un nuevo usuario y lo asignara al warehouse .




## Agradecimiento

Con esto terminamos la etapa de bootcamp donde aprendi mucho y volvi a reencontrarme con un leguaje tan hermoso como java, ahora voy a frontar mis nuevos retos en meli con un hambre tremendo de seguir creciendo 😁🐉
