package org.example;

/**
 * Una empresa de paquetería desea realizar una actualización de los sueldos de sus empleados.
 * Para ello, desean la creación de un programa que al asignar un dni y un monto determine
 * si al empleado en cuestión le corresponde o no un aumento.
 * Para ello tiene en cuenta las siguientes condiciones:
 * <p>
 * a) Si el sueldo es menor o igual a $20.000 le corresponde un 20% de aumento.
 * <p>
 * b) Si el sueldo es mayor a $20.000 pero menor o igual a $45.000 le corresponde un 10% de aumento.
 * <p>
 * c) Si el sueldo es mayor a $45.000 le corresponde un 5% de aumento.
 * <p>
 * Un programador comenzó con el planteo, pero necesita un poco de ayuda para determinar las condiciones
 * para cada uno de los casos y qué acciones deberían hacerse...
 * ¿Podrías ayudarlo a terminar?
 */
public class Ejercicio2_1 {

    public static void main(String[] args) {

        double sueldoBase = 21000; //monto de ejemplo
        String dni = "12345678"; //dni de ejemplo
        double sueldoConAumento = 0;

        // Después de escribir el enunciado allá arriba, Copilot me resolvió el resto, mil disculpas.
        if (sueldoBase <= 20_000) {
            sueldoConAumento = sueldoBase * 1.20;
        }
        else if (sueldoBase > 20_000 && sueldoBase <= 45_000) {
            sueldoConAumento = sueldoBase * 1.10;
        }
        else if (sueldoBase > 45_000) {
            sueldoConAumento = sueldoBase * 1.05;
        }

        System.out.println ("El nuevo sueldo del empleado es de: " + sueldoConAumento);

    }

}
