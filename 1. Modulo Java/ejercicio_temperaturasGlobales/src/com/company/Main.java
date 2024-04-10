package com.company;

public class Main {

    public static void main(String[] args) {

        // Declaración de variables
        String[] ciudades = new String[]{"Londres", "Madrid","Nueva York","Buenos Aires","Asunción","Sao Paulo","Lima","Santiago de Chile","Lisboa","Tokio"};
        int[][] temperaturas = new int[][]{
                {-2, 33},
                {-3, 32},
                {-8, 27},
                {4, 37},
                {6, 42},
                {5, 43},
                {0, 39},
                {-7, 26},
                {-1, 31},
                {-10, 35}
        };

        int menorTemperatura = temperaturas[0][0];
        int mayorTemperatura = temperaturas[0][1];
        String ciudadMayorTemperatura = ciudades[0];
        String ciudadMenorTemperatura = ciudades[0];

        // Se recorre el array de ciudades
        for (int i = 0; i < ciudades.length; i++) {

            // Se valida que  la temperatura en i es menor a menorTemperatura
            if (temperaturas[i][0] < menorTemperatura) {
                menorTemperatura = temperaturas[i][0];
                ciudadMenorTemperatura = ciudades[i];
            }

            // Se valida que  la temperatura en i es mayor a mayorTemperatura
            if (temperaturas[i][1] > mayorTemperatura) {
                mayorTemperatura = temperaturas[i][1];
                ciudadMayorTemperatura = ciudades[i];
            }
        }

        // Se muestran resultados en consola
        System.out.println("La mayor temperatura la tuvo " + ciudadMayorTemperatura + " con " + mayorTemperatura + " °C");
        System.out.println("La menor temperatura la tuvo " + ciudadMenorTemperatura + " con " + menorTemperatura + " °C");
    }
}