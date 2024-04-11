package org.example;

public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public int division() {
        try {
            if (a == 0)
                throw new IllegalArgumentException("No se puede dividir por cero");
            return b / a;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
