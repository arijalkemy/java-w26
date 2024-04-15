package org.miprimerproyecto;
public class App {
    public static void main(String[] args) {

        String[] ciudad = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperatura = new int[10][2]; // col1 son las temp min y col2 temp max
        int min = 9999;
        int max = -1;
        int cMin = 0;
        int cMax = 0;
        //Carga de las temperaturas en la matriz
        temperatura[0][0] = -2;
        temperatura[0][1] = 33;
        temperatura[1][0] = -3;
        temperatura[1][1] = 32;
        temperatura[2][0] = -8;
        temperatura[2][1] = 27;
        temperatura[3][0] = 4;
        temperatura[3][1] = 37;
        temperatura[4][0] = 6;
        temperatura[4][1] = 42;
        temperatura[5][0] = 5;
        temperatura[5][1] = 43;
        temperatura[6][0] = 0;
        temperatura[6][1] = 39;
        temperatura[7][0] = -7;
        temperatura[7][1] = 26;
        temperatura[8][0] = -1;
        temperatura[8][1] = 31;
        temperatura[9][0] = -10;
        temperatura[9][1] = 35;

        //buscar la temp minima y maxima y guardar dichos valores con las referencias a las ciudades
        for (int i = 0; i < 10; i++) {
            if (temperatura[i][0] < min) {
                min = temperatura[i][0];
                cMin = i;
            }
            if (temperatura[i][1] > max) {
                max = temperatura[i][1];
                cMax = i;
            }
        }
        System.out.println("La ciudad con la temperatura menor fue " + ciudad[cMin] + " con una temperatura minima de: " + min);

        System.out.println("La ciudad con la temperatura mayor fue "+ciudad[cMax]+" con una temperatura minima de: "+max);

    }
}