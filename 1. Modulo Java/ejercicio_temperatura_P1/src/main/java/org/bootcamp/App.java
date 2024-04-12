package org.bootcamp;

/**
 * @author jsanchezpimi
 */
public class App {
    public static void main(String[] args) {
        // Se crean el vector con las ciudades
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción",
                "Säo Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        // Se crea matriz para las temperaturas
        int[][] temperaturas = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42},
                {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        // Se declaran las variables a utilizar
        int temperaturaMin = Integer.MAX_VALUE;
        int temperaturaMax = Integer.MIN_VALUE;
        String ciudadTempMin = "";
        String ciudadTempMax = "";

        // Se recorre y valida la temperatura minima y maxima
        for (int i = 0; i < ciudades.length; i++) {
            if (temperaturas[i][0] < temperaturaMin) {
                temperaturaMin = temperaturas[i][0];
                ciudadTempMin = ciudades[i];
            }

            if (temperaturas[i][1] > temperaturaMax) {
                temperaturaMax = temperaturas[i][1];
                ciudadTempMax = ciudades[i];
            }
        }

        // Se imprime el resultado
        System.out.println("La ciudad " + ciudadTempMin + " tuvo la menor temperatura con " + temperaturaMin + " °C.");
        System.out.println("La ciudad " + ciudadTempMax + " tuvo la mayor temperatura con " + temperaturaMax + " °C.");
    }
}