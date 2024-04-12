package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int iteraciones = 4;

        SerieInteger serieInteger = new SerieInteger(0,2);
        System.out.println("Serie de 2: ");
        for (int i = 0; i < iteraciones; i++) {
            System.out.println(serieInteger.obtenerValorSiguiente());
        }

        serieInteger.cambiarValorInicial(1);
        System.out.println("\nValor inicial 1: ");
        for (int i = 0; i < iteraciones; i++) {
            System.out.println(serieInteger.obtenerValorSiguiente());
        }

        SerieDouble serieDouble = new SerieDouble(0.0,3.0);
        System.out.println("\nSerie de 3 (con doubles): ");
        for (int i = 0; i < iteraciones; i++) {
            System.out.println(serieDouble.obtenerValorSiguiente());
        }


    }
}
