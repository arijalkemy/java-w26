package org.example.ejercicio2;

public class Main {

    public static void main(String[] args) {

        SerieNumericaSuma serieNumericaSuma = new SerieNumericaSuma(2);
        serieNumericaSuma.setValorInicialSerie(1);

        System.out.println("\nSerie numérica Integer que suma 2, inicializada en 1:");
        System.out.println(serieNumericaSuma.siguienteValorSerie());
        System.out.println(serieNumericaSuma.siguienteValorSerie());
        System.out.println(serieNumericaSuma.siguienteValorSerie());
        System.out.println(serieNumericaSuma.siguienteValorSerie());

        SerieNumericaMultiplicacion serieNumericaMultiplicacion = new SerieNumericaMultiplicacion(3);
        serieNumericaMultiplicacion.setValorInicialSerie(2.5);

        System.out.println("\nSerie numérica Double que multiplica por 3, inicializada en 2.5:");
        System.out.println(serieNumericaMultiplicacion.siguienteValorSerie());
        System.out.println(serieNumericaMultiplicacion.siguienteValorSerie());
        System.out.println(serieNumericaMultiplicacion.siguienteValorSerie());
        System.out.println(serieNumericaMultiplicacion.siguienteValorSerie());
    }

}
