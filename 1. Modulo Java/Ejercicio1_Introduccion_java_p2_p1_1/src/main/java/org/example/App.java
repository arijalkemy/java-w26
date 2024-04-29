package org.example;

/**
 * Ejercicio practico estructuras de control
 *
 */
public class App 
{
    public static void main( String[] args ) {

        double sueldoBase = 21000; //monto de ejemplo
        String dni = "12345678"; //dni de ejemplo
        double sueldoConAumento;

        //Si el sueldo es menor o igual a $20.000 le corresponde un 20% de aumento
        if (sueldoBase <= 20000) {
            //Calculo nuevo sueldo
            sueldoConAumento = sueldoBase + sueldoBase * 0.2;
        } else {
            //Si el sueldo es mayor a $20.000 pero menor o igual a $45.000 le corresponde un 10% de aumento.
            if (sueldoBase > 20000 && sueldoBase <= 45000) {
                //Calculo nuevo sueldo
                sueldoConAumento = sueldoBase + sueldoBase * 0.1;
            }//Si el sueldo es mayor a $45.000 le corresponde un 5% de aumento.
            else {
                sueldoConAumento = sueldoBase + sueldoBase * 0.05;
            }
        }

        System.out.println("El nuevo sueldo del empleado es de: " + sueldoConAumento);

    }
}
