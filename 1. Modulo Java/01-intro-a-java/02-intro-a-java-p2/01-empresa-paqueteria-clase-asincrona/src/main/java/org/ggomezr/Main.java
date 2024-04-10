package org.ggomezr;

public class Main {
    public static void main(String[] args) {
        double sueldoBase = 21000; //monto de ejemplo
        String dni = "12345678"; //dni de ejemplo
        double sueldoConAumento = 0.0;

        if (sueldoBase <= 20000) {
            sueldoConAumento = (sueldoBase * 0.20) + sueldoBase;
        }
        else {
            if (sueldoBase > 20000 && sueldoBase <= 45000){
                sueldoConAumento = (sueldoBase * 0.10) + sueldoBase;
            }
            else {
                sueldoConAumento = (sueldoBase * 0.05) + sueldoBase;
            }
        }

        System.out.println ("El nuevo sueldo del empleado es de: " + sueldoConAumento);
    }
}