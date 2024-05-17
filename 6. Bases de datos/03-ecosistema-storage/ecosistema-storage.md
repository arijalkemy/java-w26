# Ecosistema Storage

## Ejercicios Parte 1
1. Si tengo que almacenar archivos binarios (recibos) para mi sistema de procesamiento de Billing. ¿Qué tipo de base de datos debo utilizar? ¿Por qué?
    - Para almacenar archivos binarios como recibos en un sistema de procesamiento de facturación, se podria considerar utilizar una base de datos orientada a documentos o una base de datos de objetos. Dos opciones comunes son MongoDB y Amazon DynamoDB.

2. Si tengo que guardar todos los datos de los usuarios de MELI ¿Qué tipo de base de datos debo utilizar? ¿Por qué?
    - Para almacenar todos los datos de los usuarios de Mercado Libre, que probablemente incluyan una combinación de datos estructurados y no estructurados, se podria considerar una base de datos relacional, ya que ofrecen una estructura tabular que facilita el almacenamiento y la consulta de datos altamente relacionados.

## Ejercicios Parte 2

3. Tengo que  crear una aplicación que se encarga de manejar la gestión de dinero en cuenta de los usuarios de Mercado Pago. 
Cuando un usuario paga, luego de validar que tiene saldo, tengo que registrar el pago y decrementar su saldo.
Cuando un usuario deposita dinero, tengo que incrementar su saldo. 
Asimismo, con cada pago aprobado, y usando los valores del pago y el usuario varias aplicaciones de Fraude calculan modelos de riesgo de los usuarios. 
Desde una perspectiva de base de datos 
¿Qué utilizarías? ¿Por qué? ¿Se te ocurre más de una forma de hacerlo?

    - **Base de datos relacional:**

        - **Transacciones ACID:** Las bases de datos relacionales son ideales cuando se necesita garantizar la integridad de los datos y la consistencia a través de transacciones ACID, lo cual es crucial cuando se trata de operaciones financieras como pagos y depósitos.
        - **Modelado de datos estructurado:** Si los datos tienen una estructura bien definida y es necesario realizar consultas complejas que involucren relaciones entre diferentes entidades (por ejemplo, usuarios, transacciones, saldo, etc.), una base de datos relacional puede ser la mejor opción.
        - **Escalabilidad:** Si bien las bases de datos relacionales pueden no ser tan escalables horizontalmente como las bases de datos NoSQL, aún pueden manejar grandes volúmenes de datos si están bien diseñadas y optimizadas.

    - **Base de datos NoSQL:**

        - **Escalabilidad horizontal:** Si se anticipa un gran volumen de transacciones y es necesario una alta escalabilidad horizontal para manejar cargas de trabajo distribuidas en múltiples nodos, una base de datos NoSQL podría ser más adecuada.
        - **Flexibilidad de esquema:** Si los datos son semi-estructurados o no tienen una estructura fija, una base de datos NoSQL permite una mayor flexibilidad de esquema, lo que facilita la adaptación a cambios en los requisitos de datos.
        - **Rendimiento:** Las bases de datos NoSQL a menudo ofrecen un rendimiento superior en operaciones de lectura/escritura a gran escala, lo que puede ser beneficioso para aplicaciones con alta concurrencia y velocidad.

    - **Uso de tecnologías específicas de pagos:** Algunos proveedores de servicios de pago, como Mercado Pago, ofrecen soluciones específicas de base de datos y almacenamiento para manejar transacciones financieras de manera segura y eficiente. Estas soluciones suelen estar optimizadas para cumplir con los requisitos específicos de la industria de pagos y pueden ofrecer características como cumplimiento normativo, seguridad avanzada y análisis de datos integrados.

4. Tengo que crear una aplicación que guarda datos de envíos.
Para cada envío tengo que guardar algunos datos clave como shippingId, comprador, vendedor, producto, costo total, transportista y ruta. 
Asimismo, asociado con eso, se debe guardar una foto de la orden de envío. Usualmente el equipo accede a esta data por el shippingId. 
Además de esto, necesitan obtener en ocasiones, informaciones sobre los envíos para un comprador o vendedor en particular y agrupar por ellos el costo total generado.
Finalmente, por cuestiones regulatorias, deben saber hasta por 10 años por que ruta se envió un producto. 
Desde una perspectiva de base de datos, 
¿Qué utilizarías? ¿Por qué? ¿Se te ocurre más de una forma de hacerlo?

    - **Base de datos relacional para datos estructurados:**

        - Utilizar una base de datos relacional como PostgreSQL o MySQL para almacenar los datos clave de los envíos, como shippingId, comprador, vendedor, producto, costo total, transportista y ruta.
        - Crear una tabla principal llamada "Envíos" que contenga las columnas mencionadas anteriormente. Cada fila en esta tabla representaría un envío único, identificado por su shippingId.
        - Para asociar la foto de la orden de envío con cada envío, 
        almacenar la ruta de la imagen en una columna separada en la tabla de Envíos, o bien, utilizar una tabla de relación para asociar múltiples imágenes con un envío.

    - **Almacenamiento de objetos para archivos binarios (fotos de la orden de envío):**

        - Utilizar un servicio de almacenamiento de objetos como Amazon S3 o Azure Blob Storage para almacenar las fotos de las órdenes de envío.
        - Asociar cada imagen con su respectivo shippingId, nombrar los objetos de almacenamiento de forma que incluyan el shippingId en su nombre, para facilitar la recuperación de las imágenes asociadas a un envío específico.

    - **Consulta y agregación de datos:**

        - Utilizar consultas SQL en la base de datos relacional para obtener información sobre envíos para un comprador o vendedor en particular, y agrupar los datos por ellos para calcular el costo total generado.
        - Para cumplir con los requisitos regulatorios de mantener datos de ruta de envío por hasta 10 años, se debe asegurar tener un mecanismo de respaldo y archivado adecuado para los datos de la tabla de Envíos en la base de datos relacional.
