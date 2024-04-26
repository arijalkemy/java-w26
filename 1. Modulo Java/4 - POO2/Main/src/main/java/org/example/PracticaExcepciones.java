package org.example;

public class PracticaExcepciones {
    public int a = 0;
    public int b = 300;

    public PracticaExcepciones() {
    }

    public int calcularCociente(){
        try{
            return this.b/this.a;
        }
        catch (ArithmeticException e){
            System.out.println("Se ha producido un error");
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
    }
}
