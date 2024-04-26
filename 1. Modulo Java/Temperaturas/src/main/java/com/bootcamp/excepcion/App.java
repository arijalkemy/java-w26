package com.bootcamp.excepcion;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
            String[] ciudades = { "Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Paulo",
                    "Lima", "Santiago de Chile", "Lisboa", "Tokio" };
            int[][] temperaturas = {
                    { -2, 33 },
                    { -3, 32 },
                    { -8, 27 },
                    { 4, 37 },
                    { 6, 42 },
                    { 5, 43 },
                    { 0, 39 },
                    { -7, 26 },
                    { -1, 31 },
                    { -10, 35 }
            };
    
            String ciudadMin = "";
            String ciudadMax = "";
            int tempMin = temperaturas[0][0];
            int tempMax = temperaturas[0][1];
    
            for (int i = 1; i < temperaturas.length; i++) {
                if (temperaturas[i][0] < tempMin) {
                    ciudadMin = ciudades[i];
                    tempMin = temperaturas[i][0];
                }
                if (temperaturas[i][1] > tempMax) {
                    ciudadMax = ciudades[i];
                    tempMax = temperaturas[i][1];
                }
            }
    
            System.out.println("La ciudad con la temperatura más alta es: " + ciudadMax + " con " + tempMax + " grados");
            System.out.println("La ciudad con la temperatura más baja es: " + ciudadMin + " con " + tempMin + " grados");
    }
}
