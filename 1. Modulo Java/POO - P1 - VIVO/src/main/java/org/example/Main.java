package org.example;

import jdk.internal.org.jline.terminal.TerminalBuilder;
public class Main
{
    //3.Creá una clase nueva llamada Main, donde declares un método main
    // como te enseñamos anteriormente. Esto nos permitirá ejecutar nuestra aplicación.

    //4.En la clase Main que acabamos de crear, dentro del método main()
    // te pedimos que crees un objeto de tipo Persona por cada constructor
    // que hayamos definido en la clase, recuerda poner un nombre significativo
    // a las variables donde vas a asignar cada objeto.
    // ¿Cómo lo harías? A continuación vamos a crear otro objeto de tipo persona
    // y vamos a construirlo pasando solamente un valor para el nombre y otro para la edad
    // en el constructor. ¿Es esto posible? ¿Qué sucede si tratamos de hacer esto?
    public static void main( String[] args )
    {
        Persona personita1 = new Persona();

        Persona personita2 = new Persona("laion",10, "123456");

        Persona personita3 = new Persona("shailo",15,"123456",20.5,1.6);

        //Persona personaConflictiva = new Persona("laion",10); no es posible ya que no se encuentra declarado en el constructor de esa manera.


//6.Desde la clase Main vamos a calcular el IMC de la última persona que creamos
// (la que creamos correctamente mediante el constructor que recibe todos los atributos como parámetro).
// También vamos a averiguar si es mayor de edad o no; ten en cuenta que en ambos casos,
// dependiendo de los resultados retornados por los métodos, debes imprimir un mensaje
// acorde para el usuario. Finalmente queremos mostrar todos los datos de esa persona
// imprimiendo dicha información por consola. El formato en que vas a mostrar los datos
// y los mensajes quedan a tu criterio, pero debe ser legible y descriptivo para quien
// ve la salida del programa.
//
//Referencias:
//Índice de masa corporal (IMC)         Nivel de peso
//Por debajo de 20                      Bajo peso
//Entre 20 y 25 inclusive               Peso saludable
//Mayor de 25                           Sobrepeso
       int imc = personita3.calcularIMC();
        System.out.println("Indice de masa corporal (IMC):" + imc );

        boolean adulto = personita3.esMayorDeEdad();
        System.out.println("Es mayor de edad: " + adulto);

        System.out.println("datos de la persona: " + personita3.toString());
    }



}
