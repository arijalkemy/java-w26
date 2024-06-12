package org.example;

public class App {
    public static void main(String[] args) {
        // ciudades
        String[] ciudades = {
                "Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción",
                "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"
        };

        // temperaturas (mínima, máxima)
        int[][] temperaturas = {
                {-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42},
                {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}
        };

        // almacenar la menor y mayor temperatura y sus ciudades
        int minTemp = Integer.MAX_VALUE;
        int maxTemp = Integer.MIN_VALUE;
        String minTempCity = "";
        String maxTempCity = "";

        // recorrer la matriz para encontrar la menor y mayor temperatura
        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i][0] < minTemp) {
                minTemp = temperaturas[i][0];
                minTempCity = ciudades[i];
            }
            if (temperaturas[i][1] > maxTemp) {
                maxTemp = temperaturas[i][1];
                maxTempCity = ciudades[i];
            }
        }

        // resultados
        System.out.println("La menor temperatura la tuvo " + minTempCity + ", con " + minTemp + " ºC.");
        System.out.println("La mayor temperatura la tuvo " + maxTempCity + ", con " + maxTemp + " ºC.");
    }
}

