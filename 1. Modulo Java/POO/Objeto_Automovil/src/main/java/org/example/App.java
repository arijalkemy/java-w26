package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Automovil coche1 = new Automovil();
        Automovil coche2 = new Automovil("Toyota", "rojo", 43567);

        System.out.println(coche2.mostrarMarcaYColor());
        System.out.println(coche2.mostrarKilometraje());
    }
}
