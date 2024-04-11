package org.example;

public class PracticaException {
    private int a = 0;
    private int b = 300;

    public void CalcularCociente() {
        try {
            int value = b/a;
        } catch (Exception e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
