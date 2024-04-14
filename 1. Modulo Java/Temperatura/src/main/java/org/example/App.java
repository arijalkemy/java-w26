package org.example;

public class App 
{
    public static void main( String[] args )
    {
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "Säo Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        int[][] temperaturas = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        int temperaturaMin = Integer.MAX_VALUE;
        int temperaturaMax = Integer.MIN_VALUE;
        String ciudadMin = "";
        String ciudadMax = "";


        for (int i = 0; i < ciudades.length; i++) {
            if (temperaturas[i][0] < temperaturaMin) {
                temperaturaMin = temperaturas[i][0];
                ciudadMin = ciudades[i];
            }

            if (temperaturas[i][1] > temperaturaMax) {
                temperaturaMax = temperaturas[i][1];
                ciudadMax = ciudades[i];
            }
        }

        System.out.println("La ciudad " + ciudadMin + " con temperatura: " + temperaturaMin);
        System.out.println("La ciudad " + ciudadMax + " con temperatura: " + temperaturaMax);
    }
}
