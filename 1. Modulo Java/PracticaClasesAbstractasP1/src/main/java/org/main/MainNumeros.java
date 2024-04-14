package org.main;

import org.entities.numerosP1.ClasePrototipo;
import org.entities.numerosP1.IntegerProgresivo;

/**
 * Hello world!
 *
 */
public class MainNumeros
{
    public static void main( String[] args )
    {
        ClasePrototipo serieIntegers = new IntegerProgresivo(3);
        serieIntegers.siguienteNumero();
        System.out.println(serieIntegers.getActual());
        serieIntegers.siguienteNumero();
        System.out.println(serieIntegers.getActual());
        serieIntegers.siguienteNumero();
        System.out.println(serieIntegers.getActual());
        serieIntegers.siguienteNumero();
        System.out.println(serieIntegers.getActual());

        serieIntegers.reiniciarSerie();
        serieIntegers.siguienteNumero();
        System.out.println(serieIntegers.getActual());
        serieIntegers.siguienteNumero();
        System.out.println(serieIntegers.getActual());
        serieIntegers.siguienteNumero();
        System.out.println(serieIntegers.getActual());
        serieIntegers.siguienteNumero();
        System.out.println(serieIntegers.getActual());

        serieIntegers.establecerNumeroInicial(1);
        serieIntegers.siguienteNumero();
        System.out.println(serieIntegers.getActual());
        serieIntegers.siguienteNumero();
        System.out.println(serieIntegers.getActual());
        serieIntegers.siguienteNumero();
        System.out.println(serieIntegers.getActual());
        serieIntegers.siguienteNumero();
        System.out.println(serieIntegers.getActual());
    }
}
