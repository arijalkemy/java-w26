# Enunciados

## Series numéricas

Se desea crear al menos 2 clases que extiendan de una clase prototipo, que genera un valor en función, a una serie progresiva. La clase prototipo contendrá tres métodos. El primero de los métodos es el encargado de devolver un número que corresponderá al valor siguiente a la serie progresiva. Otro método para reiniciar la serie, y un último que recibirá un valor que servirá para establecer el valor inicial de la serie. Las clases deben estar preparadas para recibir cualquier tipo de dato numérico no primitivo.

Escenarios:

- Si se crea una serie de 2 cada vez que se llame el método valor siguiente devolverá:
  - Primera vez 2
  - Segunda vez 4
  - Tercera vez 6
  - Cuarta vez 8
  
  Así sucesivamente cada vez que se llama al método.

- Si por ejemplo se emplea el método para establecer un valor inicial 1, cada vez que se llame al método el valor siguiente devolverá:
  - Primera vez 3
  - Segunda vez 5
  - Tercera vez 7
  - Cuarta vez 9
  
  Así sucesivamente cada vez que se llama al método.

- De igual forma si es una serie de 3, cada vez que se llame al método el valor siguiente devolverá:
  - Primera vez 3
  - Segunda vez 6
  - Tercera vez 9
  - Cuarta vez 12
  
  Así sucesivamente cada vez que se llama al método.

## Supermercado "El económico"
Un supermercado desea implementar un sistema, que le permita almacenar los datos de sus clientes y distintas facturas de las compras que los mencionados realicen. Para esto,  necesita poder realizar operaciones de creación, consulta, eliminación o actualización de datos de  todos los clientes y sus respectivas facturas asociadas.

De cada cliente se registran: dni, nombre y apellido. Por otro lado, las facturas que se generan cuando un cliente hace una compra contienen a un cliente, una lista de ítems y el total de la compra. De cada item o producto se guarda el código, nombre, cantidad comprada y costo unitario.

Dada la complejidad que posee el sistema, el Project Manager que dirige el proyecto ha decidido realizarlo en dos sprints, donde cada uno de ellos tendrá como objetivo una entrega final de una serie de requerimientos.

### Parte I

Se necesita:

- Crear el modelo de clases clases que conforman, una factura, los cuales son: Cliente, Item, Factura.
- Crear 3 clientes y guardarlos en una collection.
- Recorrer la collection de clientes y mostrar por pantalla los datos de cada uno de ellos.
- Eliminar uno de los clientes de la lista y volver a consultar e imprimir todos los clientes restantes.
- Solicitar por teclado un número de dni de un cliente para buscarlo. En caso de que el cliente se encuentre en la lista, mostrar sus datos, caso contrario, mostrar un mensaje que informe dicha situación.

### Parte II
Luego de la primera entrega satisfactoria, el Project Manager en conjunto con un analista funcional recabaron nuevos requerimientos para llevar a cabo una segunda parte de desarrollo en un nuevo sprint. Éstos se citan a continuación:


- Crear una nueva factura.
- Antes de querer agregar una factura a una collection de facturas tener en cuenta que:
- Será necesario validar si el cliente asociado a la factura se encuentra registrado en la collection de clientes. En caso de que no, el mismo deberá ser creado.
- Será necesario crear una lista de items y asociarla a la factura creada.
- El campo total de la factura es un campo calculado, por lo cual, para poder asignar este valor deberemos recorrer la lista de items y realizar las operaciones matemáticas necesarias para obtener el total.

#### Bonus

- Con la finalidad de optimizar el código, se requiere la creación de una interfaz “CRUD” que sea capaz de contener, mediante genéricos, todos los métodos necesarios para realizar altas, bajas, modificaciones y consultas.
- Crear o utilizar las correspondientes clases que sean capaz de implementar los métodos de la interfaz creada en el punto anterior.
- Modificar el método main para que, en lugar de realizar todo el código de manera secuencial, se pueda modularizar mediante el llamado de métodos.


