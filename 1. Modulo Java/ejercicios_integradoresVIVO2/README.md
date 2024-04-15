# Ejercicio SaveTheRopa S.A.

## Enunciado

SaveTheRopa S.A es una empresa que desea implementar un sistema informático de guardarropas a nivel mundial. El sistema permite a una persona guardar sus pertenencias en el guardarropas y luego retirarlas de manera sencilla con solo presentar el número identificador que recibe al guardarlas.
Las pertenencias se representan en el sistema mediante algo abstracto llamado prenda, que tiene marca y modelo, de modo que si la persona pierde el número también podría en algún momento poder llegar a reclamarlo con dicha información. Sin embargo, el reclamo será modelado en otro momento. Para la primera implementación del guardarropas necesitamos realizar lo siguiente:


1. Crear la clase Prenda que contenga los atributos marca y modelo.

2. Crear la clase GuardaRopa que contenga como atributos un diccionario (o MAP) y un contador que se utilizará como identificador. Las claves del diccionario serán de tipo entero y como valor una lista de prendas.

3. Crear el método public Integer guardarPrendas(List<Prenda> listaDePrenda), en la Clase GuardaRopa, que recibe una lista de prendas y devuelve el número identificador en donde quedaron asignadas las prendas, es decir la clave del diccionario en donde guardamos las mismas.

4. Crear el método public void mostrarPrendas() en la Clase GuardaRopa que imprime por pantalla todas las prendas que quedan en el guardarropas junto con el número que les corresponde.

5. Crear el método public List<Prenda> devolverPrendas(Integer numero), en la Clase GuardaRopa que devuelve la lista de prendas que están guardadas bajo ese número.

6. Crear en la clase Main un escenario en el cual alguien guarde dos prendas, reciba el código y luego consulta por sus prendas guardadas.

## Resolución 

> 📂 ejercicioRopa

### Conceptos Aplicados 

- Colecciones
- Mapas
- POO


#Ejercicio Dakar

## Enunciado
Hacer punto por punto ordenadamente, sin saltear.

Realizar los diagramas de clase correspondientes en cada paso y aplicar los cambios a medida que vamos resolviendo los distintos puntos.

1. Crear la clase vehículo que tenga los siguientes atributos:
 - Velocidad
 - Aceleración
 - AnguloDeGiro
 - Patente
 - Peso
 - Ruedas

2. Modelar la clase Carrera que tiene los siguientes atributos:
 - Distancia
 - PremioEnDolares
 - Nombre
 - CantidadDeVehiculosPermitidos
 - Lista de Vehiculos

3. Se quiere agregar dos nuevas categorías de Vehiculos:
 - Autos
 - Motos

    Los autos pesan 1.000 kilos y las motos 300 kilos, los autos tienen 4 ruedas y las motos 2.


4. Una carrera además tiene un conjunto de vehículos que participarán de la misma. 
   Entonces, ahora la carrera va a tener la responsabilidad de poder agregar a un vehículo, por lo que debemos definir los siguientes métodos:
   ```
    public void darDeAltaAuto(velocidad,aceleracion,AnguloDeGiro,patente);
    public void darDeAltaMoto(velocidad,aceleracion,AnguloDeGiro,patente);
    ```
    Ambos métodos agregan un vehículo siempre y cuando haya cupo.


5. También vamos a tener la posibilidad de eliminar a un vehículo mediante dos métodos:
    ```
    public void eliminarVehiculo(vehículo);
    public void eliminarVehiculoConPatente(String unaPatente);
   ```
    

6. Queremos poder definir el ganador de una carrera:

    El ganador será aquel que tenga el máximo valor determinado por la siguiente fórmula:

    Velocidad * ½ Aceleracion / (AnguloDeGiro*(Peso-Cantidad de Ruedas * 100)

7. Las carreras también cuentan con vehículos socorristas que ante alguna emergencia van y reparan a un vehículo. Como los autos son muy diferentes a las motos, existen dos clases distintas de vehículos socorristas. Uno de estos solo sabe socorrer autos y otro solo sabe socorrer motos.
   - Agregar las clases:
   ```
    SocorristaAuto
    SocorristaMoto
   ```
   
   - Agregar los métodos:
    ```
    SocorristaAuto → public void socorrer(Auto unAuto)
    SocorristaMoto → public void socorrer(Moto unaMoto)
   ```
    Cuando un socorrista se acerca a un auto imprime por pantalla “Socorriendo auto” y el número de patente, cuando socorre a una moto este imprime por pantalla “Socorriendo moto” y el número de patente.

    - Agregar a la clase carrera un socorrista de autos y uno de motos,.
    - Agregar a la carrera la responsabilidad de socorrer una moto y un auto:
    ```
    public void socorrerAuto(String patente);
    public void socorrerMoto(String patente);
    ```

## Resolución

> 📂 ejercicioDakar

### Conceptos Aplicados 

- Lambda
- Herencia
- Polimorfismo
