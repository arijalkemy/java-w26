package org.example;

public class Main {
    public static void main(String[] args) {

        String[] ciudades = {
            "Londres",
            "Madrid",
            "Nueva York",
            "Buenos Aires",
            "Asunción",
            "Sao Paulo",
            "Lima",
            "Santiago de Chile",
            "Lisboa",
            "Tokio"
        };

        int[][] temperaturasXCiudad = {
            { -2, 33 },
            { -3, 32 },
            { -8, 27 },
            { 4, 37 },
            { 6, 42 },
            { 5, 43 },
            { 0, 39 },
            { -7, 26 },
            { -1, 31 },
            { -10, 35 },
        };

        String lowTempCity = ciudades[0];
        String highTempCity = ciudades[0];
        int lowTempC = temperaturasXCiudad[0][0];
        int highTempC = temperaturasXCiudad[0][1];

        for(int i = 1; i < ciudades.length; i++) {
            if(temperaturasXCiudad[i][0] < lowTempC) {
                lowTempC = temperaturasXCiudad[i][0];
                lowTempCity = ciudades[i];
            }

            if(temperaturasXCiudad[i][1] > highTempC) {
                highTempC = temperaturasXCiudad[i][1];
                highTempCity = ciudades[i];
            }
        }

        System.out.println("La temperatura menor la tuvo " + lowTempCity + ", con " + lowTempC + " °C");
        System.out.println("La temperatura mayor la tuvo " + highTempCity + ", con " + highTempC + " °C");

    }
}

