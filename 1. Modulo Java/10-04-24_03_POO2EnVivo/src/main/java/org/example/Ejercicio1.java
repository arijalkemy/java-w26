package org.example;

public class Ejercicio1 {
    public static void main(String[] args) {
        int a = 0;
        int b = 300;

        try {
            if (a == 0) {
                throw new IllegalArgumentException("No se puede dividir por cero");
            }
            int cociente = b / a;
            System.out.println("El cociente es: " + cociente);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}


