package org.example;

public class PracticaExcepciones {

    public static void main(String[] args) {
        int a = 0;
        int b = 300;
        int c;

        /*try {
            c = b / a;
            System.out.println("Resultado: " + c);
        } catch (Exception e) {
            System.out.println("Se ha producido un error: " + e.getMessage());
        } finally {
            System.out.println("Programa finalizado");
        }*/

        try {
            if (a == 0) {
                throw new IllegalArgumentException("No se puede dividir por cero");
            }
            c = b / a;
            System.out.println("Resultado: ");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Programa finalizado");
        }

        try {
            c = b / a;
            System.out.println("Resultado: ");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }

    }

}
