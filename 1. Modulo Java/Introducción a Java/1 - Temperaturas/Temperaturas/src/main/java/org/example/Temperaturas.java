package org.example;
public class Temperaturas {
    public static void main(String[] args) {

        // Datos de las ciudades
        String[] ciudades = {
                "Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción",
                "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"
        };
        // Temperaturas mínimas y máximas actualizadas para cada ciudad
        int[][] temperaturas = {
                {-2, 33}, // Londres
                {-3, 32}, // Madrid
                {-8, 27}, // Nueva York
                {4, 37}, // Buenos Aires
                {6, 42}, // Asunción
                {5, 43}, // São Paulo
                {0, 39}, // Lima
                {-7, 26}, // Santiago de Chile
                {-1, 31}, // Lisboa
                {-10, 35} // Tokio
        };

        // Encuentra la temperatura mínima y máxima globales y las ciudades correspondientes
        int minGlobal = temperaturas[0][0], maxGlobal = temperaturas[0][1];
        String ciudadMinGlobal = ciudades[0], ciudadMaxGlobal = ciudades[0];

        for (int i = 0; i < ciudades.length; i++) {
            if (temperaturas[i][0] < minGlobal) {
                minGlobal = temperaturas[i][0];
                ciudadMinGlobal = ciudades[i];
            }
            if (temperaturas[i][1] > maxGlobal) {
                maxGlobal = temperaturas[i][1];
                ciudadMaxGlobal = ciudades[i];
            }
        }

        System.out.println("La temperatura mínima global fue en " + ciudadMinGlobal + ", con " + minGlobal + " ºC");
        System.out.println("La temperatura máxima global fue en " + ciudadMaxGlobal + ", con " + maxGlobal + " ºC");
    }
}
