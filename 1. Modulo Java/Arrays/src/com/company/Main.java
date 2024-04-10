package com.company;

public class Main {

    public static void main(String[] args) {
        String[] ciudades = {"Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asunción",
                "São Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio"};

        //0 = minima, 1 = maxima
        int[][] temperaturas = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        int minIdx = 0;
        int maxIdx = 0;

        for(int i = 0; i < ciudades.length; i++){
            if(temperaturas[minIdx][0] > temperaturas[i][0]){
                minIdx = i;
            }
            if(temperaturas[maxIdx][1] < temperaturas[i][1]){
                maxIdx = i;
            }
        }

        System.out.printf("La menor temperatura es de %d y se registró en %s.%n", temperaturas[minIdx][0], ciudades[minIdx]);
        System.out.printf("La mayor temperatura es de %d y se registró en %s.%n", temperaturas[maxIdx][1], ciudades[maxIdx]);
    }
}
