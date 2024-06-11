package org.example;

/**
 * Una empresa de paquetería desea realizar una actualización de los sueldos de sus empleados. Para ello, desean la
 * creación de un programa que al asignar un dni y un monto determine si al empleado en cuestión le corresponde o no
 * un aumento. Para ello tiene en cuenta las siguientes condiciones:
 * a) Si el sueldo es menor o igual a $20.000 le corresponde un 20% de aumento.
 * b) Si el sueldo es mayor a $20.000 pero menor o igual a $45.000 le corresponde un 10% de aumento.
 * c) Si el sueldo es mayor a $45.000 le corresponde un 5% de aumento.
 * Un programador comenzó con el planteo, pero necesita un poco de ayuda para determinar las condiciones para cada uno
 * de los casos y qué acciones deberían hacerse... ¿Podrías ayudarlo a terminar?
 */
public class Ejercicio3 {

    public static void main(String[] args) {
        Empleado empleado1 = new Empleado("12345678A", 18000);
        Empleado empleado2 = new Empleado("87654321B", 30000);
        Empleado empleado3 = new Empleado("11223344C", 50000);

        AumentoSueldo aumentoSueldo = new AumentoSueldo();
        aumentoSueldo.aplicarAumento(empleado1);
        aumentoSueldo.aplicarAumento(empleado2);
        aumentoSueldo.aplicarAumento(empleado3);

        System.out.println("Nuevo sueldo empleado 1: " + empleado1.getSueldo());
        System.out.println("Nuevo sueldo empleado 2: " + empleado2.getSueldo());
        System.out.println("Nuevo sueldo empleado 3: " + empleado3.getSueldo());
    }

    public static class Empleado {
        private final String dni;
        private double sueldo;

        public Empleado(String dni, double sueldo) {
            this.dni = dni;
            this.sueldo = sueldo;
        }

        public String getDni() {
            return dni;
        }

        public double getSueldo() {
            return sueldo;
        }

        public void setSueldo(double sueldo) {
            this.sueldo = sueldo;
        }
    }

    public static class AumentoSueldo {

        public void aplicarAumento(Empleado empleado) {
            double sueldoActual = empleado.getSueldo();
            double nuevoSueldo;

            if (sueldoActual <= 20000) {
                nuevoSueldo = sueldoActual * 1.20; // 20% de aumento
            } else if (sueldoActual <= 45000) {
                nuevoSueldo = sueldoActual * 1.10; // 10% de aumento
            } else {
                nuevoSueldo = sueldoActual * 1.05; // 5% de aumento
            }

            empleado.setSueldo(nuevoSueldo);
        }
    }
}
