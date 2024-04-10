package org.example;


public class Temperaturas{

    public static void main(String[] args) {
        String ciudades[] = {
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

        int temperaturas[][] = {
                {-2, -3, -8, 4, 6, 5, 0, -7, -1, -10},
                {33, 32, 27, 37, 42, 43, 39, 26, 31, 35}
        };

        int minCiudad[] = {0, temperaturas[0][0]};//[Posicion ciudad ,valor minimo]
        int maxCiudad[] = {0, temperaturas[1][0]};//[Posicion ciudad ,valor maximo]

        for(int i = 1; i < ciudades.length; i++){
            if(temperaturas[0][i] < minCiudad[1]){
                minCiudad[0] = i;
                minCiudad[1] = temperaturas[0][i];
            }
            if(temperaturas[1][i] > maxCiudad[1]){
                maxCiudad[0] = i;
                maxCiudad[1] = temperaturas[1][i];
            }
        }

        System.out.println("Ciudad más fría: " + ciudades[minCiudad[0]] + " con temperatura " + minCiudad[1]);
        System.out.println("Ciudad más caliente: " + ciudades[maxCiudad[0]] + " con temperatura " + maxCiudad[1]);



    }

}