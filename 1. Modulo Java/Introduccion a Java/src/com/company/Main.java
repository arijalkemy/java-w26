package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// Ejercicios prácticos

    String apellido = "Gomez"; //Faltaban ""
    int edad = 35; //Tipo de dato incorrecto
    boolean boleano= false; //Tipo de dato incorrecto, falta nombre
    double sueldo = 45857.90; //Faltaba ;
    String nombre = "Julián"; //Tipo de dato incorrecto

    //Ejercicio en Vivo 1

    List<String> ciudades = new ArrayList<>();
    int indexAlto = Integer.MIN_VALUE;
    int indexBajo = Integer.MIN_VALUE;
    int temperaturaBaja = Integer.MAX_VALUE;
    int temperaturaAlta = Integer.MIN_VALUE;

    ciudades.add("Londres");
    ciudades.add("Madrid");
    ciudades.add("Nueva York");
    ciudades.add("Buenos Aires");
    ciudades.add("Asunción");
    ciudades.add("São Paulo");
    ciudades.add("Lima");
    ciudades.add("Santiago de Chile");
    ciudades.add("Lisboa");
    ciudades.add("Tokio");

    int[][] temperaturas = new  int[10][2];
    temperaturas[0][0] = -2; temperaturas[0][1] = 33;
    temperaturas[1][0] = -3; temperaturas[1][1] = 32;
    temperaturas[2][0] = -8; temperaturas[2][1] = 27;
    temperaturas[3][0] = 4; temperaturas[3][1] = 37;
    temperaturas[4][0] = 6; temperaturas[4][1] = 42;
    temperaturas[5][0] = 5; temperaturas[5][1] = 43;
    temperaturas[6][0] = 0; temperaturas[6][1] = 39;
    temperaturas[7][0] = -7; temperaturas[7][1] = 26;
    temperaturas[8][0] = -1; temperaturas[8][1] = 31;
    temperaturas[9][0] = -10; temperaturas[9][1] = 35;

    for(int i= 0; i<ciudades.size();i++){
        if(temperaturas[i][0]<temperaturaBaja){
            indexBajo =i;
            temperaturaBaja = temperaturas[i][1];
        }
        if(temperaturas[i][1]>temperaturaAlta){
            indexAlto = i;
            temperaturaAlta = temperaturas[i][1];
        }
    }
    System.out.println("Temperatura más baja es de "+temperaturas[indexBajo][0]+" En la ciudad de "+ ciudades.get(indexBajo));
    System.out.println("Temperatura más alta es de "+temperaturas[indexAlto][1]+" En la ciudad de "+ ciudades.get(indexAlto));
    //Ejercicio Práctico 2
        double sueldoBase = 21000; //monto de ejemplo
        String dni = "12345678"; //dni de ejemplo
        double sueldoConAumento;

        if (sueldoBase<=20000) {
            sueldoConAumento = sueldoBase*1.2;
        }
        else if(sueldoBase>20000&&sueldoBase<=45000){
            sueldoConAumento = sueldoBase*1.1;}
        else {
            sueldoConAumento= sueldoBase*1.05;
            }
        System.out.println ("El nuevo sueldo del empleado es de: " + String.format("%.2f",sueldoConAumento));
    }


}
