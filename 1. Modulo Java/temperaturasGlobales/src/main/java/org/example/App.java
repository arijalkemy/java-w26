package org.example;

public class App {
    public static void main(String[] args) {

        String[] ciudades = new String[10];
        ciudades[0] = "Londres";
        ciudades[1] = "Madrid";
        ciudades[2] = "Nueva York";
        ciudades[3] = "Buenos Aires";
        ciudades[4] = "Asunción";
        ciudades[5] = "São Paulo";
        ciudades[6] = "Lima";
        ciudades[7] = "Santiago de Chile";
        ciudades[8] = "Lisboa";
        ciudades[9] = "Tokio";

        int[][] temperatures = {{-2, 33}, {-3, 32}, {-8, 27},
                {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26},
                {-1, 31}, {-10, 35}};

        int min = 0;
        int max = 0;
        int maxTemp = 0;
        int minTemp = 0;

        for (int i = 0; i < ciudades.length; i++) {
            if (temperatures[i][0] < min) {
                min = temperatures[i][0];
                minTemp = i;
            }
            ;
            if (temperatures[i][1] > max) {
                max = temperatures[i][1];
                maxTemp = i;
            }
            ;
        }

        System.out.println("Temperarura maxima de " + ciudades[maxTemp] + " es " + max + "ºC");
        System.out.println("Temperatura minuma de " + ciudades[minTemp] + " es " + min + "ºC");
    }
}
