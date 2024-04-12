package org.example;

public class PracticaExcepciones {
    private int a;
    private int b;

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

    public PracticaExcepciones(int a, int b){
        this.a = a;
        this.b = b;
    }

    public double calcularCociente(){
        try{
            if(a == 0)
                throw new IllegalArgumentException("No se puede dividir por cero");

            return b/a;
        }catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }finally {
            System.out.println("Programa finalizado");
        }
        return 0;
    }
}
