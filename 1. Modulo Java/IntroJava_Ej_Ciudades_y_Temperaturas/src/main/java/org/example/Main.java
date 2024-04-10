package org.example;

public class Main {
    public static void main(String[] args) {

        String[] vectorCiudades = new String[10];
        cargarVectorCiudades(vectorCiudades);

        int[][] matrizTemperaturas = new int[10][2];
        cargarMatrizTemperaturas(matrizTemperaturas);

        String ciudadMenorTemperatura = vectorCiudades[0];
        String ciudadMayorTemperatura = vectorCiudades[0];

        int menortemperatura = matrizTemperaturas[0][0];
        int mayorTemperatura = matrizTemperaturas[0][1];




        for(int i = 1; i < 10; i++){
                if(matrizTemperaturas[i][0] < menortemperatura){
                    menortemperatura = matrizTemperaturas[i][0];
                    ciudadMenorTemperatura = vectorCiudades[i];
                }
                if(matrizTemperaturas[i][1] > mayorTemperatura){
                    mayorTemperatura = matrizTemperaturas[i][1];
                    ciudadMayorTemperatura = vectorCiudades[i];
                }
        }

        System.out.println("La ciudad de mayor temperatura historica es: " + ciudadMayorTemperatura +
        " con " + mayorTemperatura + " grados");
        System.out.println("La ciudad con menor temperatura historica es: " + ciudadMenorTemperatura +
        " con " + menortemperatura + " grados");
    }



    public static void cargarVectorCiudades(String[] vCiudades){
        vCiudades[0] = "Londres";
        vCiudades[1] = "Madrid";
        vCiudades[2] = "Nueva York";
        vCiudades[3] = "Buenos Aires";
        vCiudades[4] = "Asunción";
        vCiudades[5] = "Sao Pablo";
        vCiudades[6] = "Lima";
        vCiudades[7] = "Santiago de Chile";
        vCiudades[8] = "Lisboa";
        vCiudades[9] = "Tokyo";
    }

    public static void cargarMatrizTemperaturas(int[][] mTemperaturas){
        mTemperaturas[0][0] =  -2;
        mTemperaturas[0][1] =  33;
        mTemperaturas[1][0] =  -3;
        mTemperaturas[1][1] =  32;
        mTemperaturas[2][0] =  -8;
        mTemperaturas[2][1] =  27;
        mTemperaturas[3][0] =  4;
        mTemperaturas[3][1] =  37;
        mTemperaturas[4][0] =  6;
        mTemperaturas[4][1] =  42;
        mTemperaturas[5][0] =  5;
        mTemperaturas[5][1] =  43;
        mTemperaturas[6][0] =  0;
        mTemperaturas[6][1] =  39;
        mTemperaturas[7][0] =  -7;
        mTemperaturas[7][1] =  26;
        mTemperaturas[8][0] =  -1;
        mTemperaturas[8][1] =  31;
        mTemperaturas[9][0] =  -10;
        mTemperaturas[9][1] =  35;
    }
    
}