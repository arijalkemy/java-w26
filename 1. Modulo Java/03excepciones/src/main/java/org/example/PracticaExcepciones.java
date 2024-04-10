package org.example;

public class PracticaExcepciones {
    int a;
    int b;

    public PracticaExcepciones(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int calcularCociente() throws IllegalArgumentException {
        try {
            return b / a;
        } catch (Exception e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
    }
}
