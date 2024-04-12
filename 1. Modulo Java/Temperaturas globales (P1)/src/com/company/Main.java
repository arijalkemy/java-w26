package com.company;

public class Main {

    public static void main(String[] args) {
        String[] ciudades = {"Londres","Madrid","Nueva York","Buenos Aires","Asuncion","Sao Paulo","Lima","Santiago de Chile","Lisboa","Tokio"};
        int[][] temperaturas = {{-2,33},{-3,32},{-8,27},{4,37},{6,42},{5,43},{0,39},{-7,26},{-1,31},{-10,35}};
        int lowestTemp = temperaturas[0][0];
        int highestTemp = temperaturas[0][1];
        String countryWithLowestTemp = ciudades[0];
        String countryWithHighestTemp = ciudades[0];
        for(int i = 0; i < temperaturas.length; i++){
            if(lowestTemp > temperaturas[i][0]){
                lowestTemp = temperaturas[i][0];
                countryWithLowestTemp = ciudades[i];
            }
            if(highestTemp < temperaturas[i][1]){
                highestTemp = temperaturas[i][1];
                countryWithHighestTemp = ciudades[i];
            }
        }
        System.out.println("The country with the highest temp is " + countryWithHighestTemp + " temp: " + highestTemp);
        System.out.println("The country with the lowest temp is " + countryWithLowestTemp + " temp: " + lowestTemp);
    }    
}
