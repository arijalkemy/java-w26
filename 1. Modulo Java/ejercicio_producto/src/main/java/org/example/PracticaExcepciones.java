package org.example;

public class PracticaExcepciones {
    private int a;
    private int b;

    public PracticaExcepciones(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void calcular() {
        try {
            if (b == 0) {
                throw new IllegalArgumentException("No se puede dividir por cero");
            }
            System.out.println(a / b);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
