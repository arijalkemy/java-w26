package com.company;

public class Main {

    public static void main(String[] args) {

        String cities[] = new String[10];
        cities[0] = "Londres";
        cities[1] = "Madrid";
        cities[2] = "Nueva York";
        cities[3] = "Buenos Aires";
        cities[4] = "Asunción";
        cities[5] = "Sao Paulo";
        cities[6] = "Lima";
        cities[7] = "Santiago de Chile";
        cities[8] = "Lisboa";
        cities[9] = "Tokio";

        int temperatures[][] = new int[10][2];

        temperatures[0][0] = -2;
        temperatures[1][0] = -3;
        temperatures[2][0] = -8;
        temperatures[3][0] = 4;
        temperatures[4][0] = 6;
        temperatures[5][0] = 5;
        temperatures[6][0] = 0;
        temperatures[7][0] = -7;
        temperatures[8][0] = -1;
        temperatures[9][0] = -10;
        temperatures[0][1] = 33;
        temperatures[1][1] = 32;
        temperatures[2][1] = 27;
        temperatures[3][1] = 37;
        temperatures[4][1] = 42;
        temperatures[5][1] = 43;
        temperatures[6][1] = 39;
        temperatures[7][1] = 26;
        temperatures[8][1] = 31;
        temperatures[9][1] = 35;


        String ciudades[] = {"Londres","Madrid","Nueva York","Buenos Aires","Asunción","São Paulo","Lima","Santiago de Chile","Lisboa","Tokio"};
        int temperaturas[][] = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};


        int tempMayor = temperatures[0][0];
        int tempMenor = temperatures[0][0];
        int ubicacionMayor = 0;
        int ubicacionMenor = 0;

        for(int f=0; f<temperatures.length; f++) {
            for(int c=0; c<temperatures[f].length; c++) {
                if(temperatures[f][c]>=tempMayor) {
                    tempMayor = temperatures[f][c];
                    ubicacionMayor = f;
                } else if(temperatures[f][c]<=tempMenor){
                    tempMenor = temperatures[f][c];
                    ubicacionMenor = f;
                }
            }
        }

        System.out.println("La temperatura más alta es "+tempMayor+" en la ciudad de "+cities[ubicacionMayor]);
        System.out.println("La temperatura más baja es "+tempMenor+" en la ciudad de "+cities[ubicacionMenor]);
    }
}
