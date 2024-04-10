package org.example;

public class ExceptionsPractice {
    private int numA = 0;
    private int numB = 300;

    public ExceptionsPractice() {
    }

    public int getDivision() {
        int result = 0;
        try {
            result = numB / numA;
        } catch (Exception ex) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
        return result;
    }
}
