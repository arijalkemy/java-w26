package org.example;

public class Main {
    public static void main(String[] args) {
        //Ejercicio 1. Sueldos
        double sueldoBase = 21000; //monto de ejemplo
        String dni = "12345678"; //dni de ejemplo
        double sueldoConAumento;

        if (sueldoBase<=20000) {
            sueldoConAumento = sueldoBase*1.2;
        }
        else {
            if (sueldoBase>20000&&sueldoBase<=45000){
                sueldoConAumento = sueldoBase*1.1;
            }
            else {
                sueldoConAumento = sueldoBase*1.05;
            }
        }
        System.out.println("Ejercio 1. Sueldos");
        System.out.println ("El nuevo sueldo del empleado es de: " + sueldoConAumento);
        //------------
        //Ejercicio 2
        System.out.println("");
        System.out.println("Ejercio 2. Costos");
        int[] serviciosCli = {1,1,2,2,2,1,2}; //vector de 7 posiciones con tipos de servicios Se modifica para hacerlo vector
        double totalFactura;

        for (int i= 0;i<serviciosCli.length;i++) {
            if (serviciosCli[i]==1) {
                totalFactura = 1500;
                System.out.println ("El tipo de servicio es: " + serviciosCli[i]);
                System.out.println ("El monto de la factura es de: " + totalFactura);
            }
            else {
                totalFactura = 1500+700;
                System.out.println ("El tipo de servicio es: " + serviciosCli[i]);
                System.out.println ("El monto de la factura es de: " + totalFactura);
            }
        }

    }
}
