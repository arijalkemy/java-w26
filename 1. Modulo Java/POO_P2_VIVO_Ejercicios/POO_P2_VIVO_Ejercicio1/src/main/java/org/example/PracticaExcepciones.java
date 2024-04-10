package org.example;

public class PracticaExcepciones {
    private int a;
    private int b;

    public PracticaExcepciones() {
        this.a = 0;
        this.b = 100;
    }

    public void calcularCociente(){
        int resul;
        try{
            resul = b/a;
        }
        catch(ArithmeticException e){
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        finally {
            System.out.println("Programa finalizado");
        }
    }

}