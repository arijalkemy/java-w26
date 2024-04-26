package com.bootcamp;

import java.util.Scanner;

public class EjercicioCiudades {

    public static void main(String[] args) {

        String ciudades[] = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int temperaturas[][] = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};
        double tempMinima, tempMaxima;
        String ciudadMinima, ciudadMaxima;

        tempMinima = temperaturas[0][0];
        ciudadMinima = ciudades[0];
        tempMaxima = temperaturas[0][0];
        ciudadMaxima = ciudades[0];

        for (int f = 0; f <= 9; f++) {
            for (int c = 0; c <= 1; c++) {
                if (temperaturas[f][c] < tempMinima) {
                    tempMinima = temperaturas[f][c];
                    ciudadMinima = ciudades[f];
                }
                if (temperaturas[f][c] > tempMaxima) {
                    tempMaxima = temperaturas[f][c];
                    ciudadMaxima = ciudades[f];
                }
            }
        }
        System.out.println(ciudadMinima + " es la ciudad con la menor temperatura, con un valor de: " + tempMinima);
        System.out.println(ciudadMaxima + " es la ciudad con la mayor temperatura máxima de, con un valor de: " + tempMaxima);
    }
}