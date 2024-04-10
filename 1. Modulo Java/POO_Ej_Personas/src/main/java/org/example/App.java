package org.example;
public class App 
{

    //Ejercicio 3
    public static void main( String[] args )
    {
        /*
        Ejercicio 4 - No es posible crear una clase persona solo con nombre y edad, ya que no
        tenemos un constructor para esos parametros
         */

        Persona p1 = new Persona();
        Persona p2 = new Persona("Ignacio",27,"1234");
        Persona p3 = new Persona("Jose", 55,"1235",88.0f,1.95f);

        //Ejercicio 6

        System.out.println(p3.getMensajePeso());
        System.out.println(p3.getMensajeEdad());
        System.out.println(p3.toString());
    }
}
