package org.example;

import org.example.series.SerieDeEnteros;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SerieDeEnteros serieDeDos = new SerieDeEnteros(2);

        System.out.println(serieDeDos.siguiente());
        System.out.println(serieDeDos.siguiente());
        System.out.println(serieDeDos.siguiente());
        System.out.println(serieDeDos.siguiente());

        serieDeDos.reiniciar();
        System.out.println(serieDeDos.siguiente());
        System.out.println(serieDeDos.siguiente());

        serieDeDos.setear(5);
        System.out.println(serieDeDos.siguiente());
        System.out.println(serieDeDos.siguiente());
    }
}
