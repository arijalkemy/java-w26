package org.example;

import org.example.seriesNumericas.Por3Medios;
import org.example.seriesNumericas.SerieNumerica;
import org.example.seriesNumericas.Suma3;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Por3Medios por3Medios = new Por3Medios(1.0);
        System.out.println(por3Medios.getValue());
        System.out.println(por3Medios.getValue());
        System.out.println(por3Medios.getValue());

        Suma3 suma3 = new Suma3(0);
        System.out.println(suma3.getValue());
        System.out.println(suma3.getValue());
        System.out.println(suma3.getValue());
        System.out.println(suma3.getValue());
    }
}
