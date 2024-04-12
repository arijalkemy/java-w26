package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SerieDos<Integer> serieDos = new SerieDos<>(2);

        for (int i = 0; i < 5; i++) {
            System.out.println("Serie de dos: " + serieDos.getValorActual());
            serieDos.siguienteValorSerie();
        }
        System.out.println("Ultimo valor: " + serieDos.getValorActual());

        System.out.println("----------------------");

        SerieTres<Double> serieTres = new SerieTres<>(20.0);

        for (int i = 0; i < 5; i++) {
            System.out.println("Serie de tres: " + serieTres.getValorActual());
            serieTres.siguienteValorSerie();
        }
        System.out.println("Ultimo valor: " + serieTres.getValorActual());
    }
}
