package org.example;

public class PracticaExcepciones {
    private int a;
    private int b;

    public PracticaExcepciones(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public void calcularCociente() {
//        if (a==0) {
//            throw new Exception("No se puede dividir por 0");
//        }
        try {
            System.out.println(b/a);
        } catch (Exception e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
        }
    }
}
