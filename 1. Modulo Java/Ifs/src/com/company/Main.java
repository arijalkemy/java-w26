package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        servicios();
    }

    private static void servicios() {
        int[] serviciosCli = {1,1,2,2,2,1,2}; //vector de 7 posiciones con tipos de servicios
        double totalFactura;

        for (int i = 0; i < serviciosCli.length; i++) {
            if (serviciosCli[i] == 1) {
                totalFactura = 1500;
                System.out.println ("El tipo de servicio es: " + serviciosCli[i]);
                System.out.println ("El monto de la factura es de: " + totalFactura);
            }
            else {
                totalFactura = 1500 + 700;
                System.out.println ("El tipo de servicio es: " + serviciosCli[i]);
                System.out.println ("El monto de la factura es de: " + totalFactura);
            }
        }

    }

    private static void calcSueldo(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el sueldo:");
        double sueldo = scanner.nextDouble(); //monto de ejemplo

        String dni = "12345678"; //dni de ejemplo
        double sueldoConAumento;

        if (sueldo <= 20000) {
            sueldoConAumento = sueldo * 1.2;
        }
        else {
            if (sueldo > 20000 && sueldo <= 45000){
                sueldoConAumento = sueldo * 1.1;
            }
            else {
                sueldoConAumento = sueldo*1.05;
            }
        }

        System.out.println ("El nuevo sueldo del empleado es de: " + sueldoConAumento);
    }
}
