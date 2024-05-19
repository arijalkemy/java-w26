# Ejercicio 8 - Normalización

## Escenario

Luego de un análisis realizado en un sistema de facturación, se ha detectado un mal diseño en la base de datos. La misma, cuenta con una tabla facturas que almacena datos de diferente naturaleza.

Como se puede observar, la tabla cuenta con datos que podrían ser normalizados y separados en diferentes entidades.

![Escenario](images/escenario.png)

## Ejercicio

Se solicita para el escenario anterior:

* Aplicar reglas de normalización y elaborar un modelo de DER que alcance la tercera forma normal (3FN).
* Describir con sus palabras cada paso de la descomposición y aplicación de las reglas para visualizar el planteo realizado.

## Solución

* Primera Forma Normal

Cliente:
* id_cliente **PK**
* nombre_cliente
* apellido_cliente
* direccion_cliente

Forma_Pago
* id_forma_pago **PK**
* descripcion

Factura:
* id_factura **PK**
* fecha_factura
* total
* id_cliente **FK**
* id_forma_pago **FK**

Detalle:
* id_detalle **PK**
* descripcion_articulo
* cantidad
* aporte
* iva
* id_factura **FK**