package org.example;

public class PracticaExcepciones {
    public static void main(String[] args) {
        int a = 0;
        int b = 300;

        // PARTE 1: control de la excepción y mostrar mensaje final.
        try {
            double division = b / a;
        } catch (Exception e) {
            System.out.println("Se ha producido un error");
        } finally {
            System.out.println("Programa finalizado");
        }

        // PARTE 2:
        try {
            double division = b / a;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado 2da excepcion");
        }
    }
}

