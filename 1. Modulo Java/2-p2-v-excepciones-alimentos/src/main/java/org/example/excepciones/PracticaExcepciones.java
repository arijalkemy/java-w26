package org.example.excepciones;

public class PracticaExcepciones {

    private int a = 0;
    private int b = 300;

    /*
    public float cociente(int a, int b){
        float cociente;
        try {
            cociente = b / a;
        } catch (ArithmeticException e) {
            cociente = 0;
            System.out.println("Se ha producido un error.");
        } finally {
            System.out.println("Programa finalizado.");
        }
        return cociente;
    }
     */

    public float cociente(int a, int b){
        float cociente = 0;

        if (a == 0) {
            throw new IllegalArgumentException("El divisor no puede ser cero");
        }

        try {
            cociente = b / a;
        } catch (ArithmeticException e) {
            System.out.println("Se ha producido un error.");
        } finally {
            System.out.println("Programa finalizado.");
        }
        return cociente;
    }


}
