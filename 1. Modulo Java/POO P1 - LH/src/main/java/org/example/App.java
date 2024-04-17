package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Automovil carro = new Automovil("KIA", "Rojo", 34000);
        System.out.println(carro.mostrarMarcaYColor());
    }




}
