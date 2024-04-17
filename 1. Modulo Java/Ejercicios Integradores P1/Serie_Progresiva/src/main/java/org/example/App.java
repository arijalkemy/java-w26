package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Enteros serieEnteros = new Enteros(2, 2);
        System.out.println("Enteros");
        for (int i = 0; i < 5; i++) {
            System.out.println(serieEnteros.valorSiguiente());
        }


        Flotantes serieFlotantes = new Flotantes(1.5f, 0.5f);
        System.out.println("Flotantes");
        for (int i = 0; i < 5; i++) {
            System.out.println(serieFlotantes.valorSiguiente());
        }
    }
}
