package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ejercico_uno();
        ejercico_dos();
    }

    public static void ejercico_uno(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite el DNI del empleado");
        String dni = teclado.next();
        System.out.println("Digite el sueldo base del empleado");
        double sueldoBase = teclado.nextInt();

        double sueldoConAumento;

        if (sueldoBase <= 20000) {
            sueldoConAumento=sueldoBase*1.20;
        }
        else {
            if (sueldoBase > 20000 && sueldoBase <= 45000){
                sueldoConAumento=sueldoBase*1.10;
            }
            else {
                sueldoConAumento=sueldoBase*1.05;
            }
        }

        System.out.println ("El nuevo sueldo del empleado con dni "+dni+" es de: " + String.format("%.2f",sueldoConAumento));
        System.out.println();
        System.out.println("-----------------------------------");
    }

    public static void ejercico_dos() {
        int[] serviciosCli = {1, 1, 2, 2, 2, 1, 2}; //vector de 7 posiciones con tipos de servicios
        double totalFactura;

        for (int i = 0; i < serviciosCli.length; i++) {
            if (serviciosCli[i] == 1) {
                totalFactura = 1500;
                System.out.println("El tipo de servicio es: " + serviciosCli[i]);
                System.out.println("El monto de la factura es de: " + totalFactura);
            } else {
                totalFactura = 1500 + 700;
                System.out.println("El tipo de servicio es: " + serviciosCli[i]);
                System.out.println("El monto de la factura es de: " + totalFactura);
            }
        }
    }
}