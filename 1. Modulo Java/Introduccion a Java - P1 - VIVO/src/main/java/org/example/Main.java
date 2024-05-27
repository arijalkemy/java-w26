package org.example;

import com.sun.jdi.Value;

public class Main {
    public static void main(String[] args) {
        //Insertar los datos después de la creación
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

        //Insertar los datos en la creación
        int[][] temperaturas = {
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

        int indexMinimo = 0;
        int indexMaxino = 0;

        for (int i = 1; i < temperaturas.length; i++) {
            //Verifcar si es temperatura minima
            if (temperaturas[i][0] < temperaturas[indexMinimo][0]) {
                indexMinimo = i;
            }
            //Verificar si es temperatura Máxima
            if (temperaturas[i][1] > temperaturas[indexMaxino][1]) {
                indexMaxino = i;
            }
        }
        System.out.println("Temp min:" +temperaturas[indexMinimo][0]+ "ciudad: "+ciudades[indexMinimo]);
        System.out.println("Temp max:" +temperaturas[indexMaxino][1]+ "ciudad: "+ciudades[indexMaxino]);

    }
}
