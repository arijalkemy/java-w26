package org.example;

public class Main {

    private static final String[] ciudades = {
        "Londres",
        "Madrid",
        "Nueva York",
        "Buenos Aires",
        "Asunción",
        "São Paulo",
        "Lima",
        "Santiago de Chile",
        "Lisboa",
        "Tokio"
    };

    private static final int[][] temperaturas = {
        { -2, 33 },
        { -3, 32 },
        { -8, 27 },
        { -4, 37 },
        { -6, 42 },
        { -5, 43 },
        { 0, 39 },
        { -7, 26 },
        { -1, 31 },
        { -10, 35 },
    };


    public static void main(String[] args) {

        Integer temperaturaMinima = null;
        Integer indiceTemperaturaMinima = null;
        Integer temperaturaMaxima = null;
        Integer indiceTemperaturaMaxima = null;

        for (int i = 0; i < temperaturas.length; i++) {

            if (temperaturaMinima == null || temperaturas[i][0] < temperaturaMinima) {
                temperaturaMinima = temperaturas[i][0];
                indiceTemperaturaMinima = i;
            }

            if (temperaturaMaxima == null || temperaturas[i][1] > temperaturaMaxima) {
                temperaturaMaxima = temperaturas[i][1];
                indiceTemperaturaMaxima = i;
            }
        }

        System.out.println(
            "La mayor temperatura es de " + temperaturaMaxima + "º" +
            " y sucedió en la ciudad de " + ciudades[indiceTemperaturaMaxima] + "."
        );
        System.out.println(
            "La menor temperatura es de " + temperaturaMinima + "º" +
            " y sucedió en la ciudad de " + ciudades[indiceTemperaturaMinima] + "."
        );
    }

}