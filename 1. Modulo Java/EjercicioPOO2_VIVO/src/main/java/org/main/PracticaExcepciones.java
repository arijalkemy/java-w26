package org.main;

public class PracticaExcepciones {
    int a = 0;
    int b = 300;

    public void division() {
        try {
            System.out.println(b / a);
        } catch (IllegalArgumentException e) {
            IllegalArgumentException ex = new IllegalArgumentException("No se puede dividir por cero");
        }finally {
            System.out.println("Programa finalizado");
        }
    }
}
