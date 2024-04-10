package org.example;

public class PracticaExcepciones {
    public static void main(String[] args) {
        int a = 0, b = 300;

        // Item 1.1)
        try {
            int res = b / a;
            System.out.println("res: " + res);
        } catch (Exception e) {
            System.out.println("Se ha producido un error");
        } finally {
            System.out.println("Programa finalizado");
        }

        // Item 1.2)
        try {
            if (a == 0) throw new IllegalArgumentException("No se puede dividir por cero");
            int res = b / a;
            System.out.println("res: " + res);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}