package org.example;

public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public void calcularDivision(){
        try{
            double resultado = 0;
            resultado = b/a;
        }catch (ArithmeticException e){
             throw new IllegalArgumentException("No se puede dividir por cero");
             //System.out.println("Se ha producido un error");
        }
        finally {
            System.out.println("Programa finalizado");
        }
    }
}