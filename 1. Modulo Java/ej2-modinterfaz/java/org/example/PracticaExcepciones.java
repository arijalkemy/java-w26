package org.example;

public class PracticaExcepciones {
    private int a;
    private int b;
    public PracticaExcepciones(){
        this.a = 0;
        this.b = 300;
    }
    public void calcularCociente(){
        try{
            System.out.println(this.b/this.a);
        }catch (ArithmeticException e){
            throw new IllegalArgumentException("No se puede dividir por cero");
        }finally {
            System.out.println("Se ha terminado la ejecución");
        }
    }

}
