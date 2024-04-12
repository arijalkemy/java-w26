package org.example;

import org.example.seriesNumericas.SerieDeDouble;
import org.example.seriesNumericas.SerieDeEnteros;
import org.example.seriesNumericas.SerieNumerica;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SerieNumerica<Integer> serieDe3 = new SerieDeEnteros(0, 3);
        serieDe3.setInitValue(1);
        serieDe3.reset();
        System.out.println("Primer intento: " + serieDe3.getValue());
        System.out.println("Segundo intento: " + serieDe3.getValue());
        System.out.println("Tercer intento: " + serieDe3.getValue());
        System.out.println("Cuarto intento: " + serieDe3.getValue());

        SerieDeDouble serieDeDouble = new SerieDeDouble(0.0, 1.5);
        System.out.println("Primer intento: " + serieDeDouble.getValue());
        System.out.println("Segundo intento: " + serieDeDouble.getValue());
        System.out.println("Tercer intento: " + serieDeDouble.getValue());
        System.out.println("Cuarto intento: " + serieDeDouble.getValue());
    }
}
