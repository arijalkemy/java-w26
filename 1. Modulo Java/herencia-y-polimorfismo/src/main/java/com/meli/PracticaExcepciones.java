package com.meli;

public class PracticaExcepciones {
    private int a;
    private int b;

    public PracticaExcepciones() {
        this.a = 0;
        this.b = 300;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public Double calcularCociente() {
        Double cociente = 0.0;
        try {
            if (this.a == 0) {
                throw new IllegalArgumentException("No se puede dividir por: " + this.a);
            }
            cociente = (double) (this.b / this.a);
        }
        catch (ArithmeticException e) {
            System.out.println("Se ha producido un error al calcular el cociente");
        }
        return cociente;
    }
}
