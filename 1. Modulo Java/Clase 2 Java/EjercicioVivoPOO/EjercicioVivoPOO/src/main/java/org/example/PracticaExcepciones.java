package org.example;

public class PracticaExcepciones {
    private int a =0;
    private int b=300;

// Ejercicio 1
    public void calcularCociente(){
        try {
            double calculo= b/a;
        }catch (ArithmeticException e){
            //System.out.println("se ha producito un error");
            throw new IllegalArgumentException("No se puede dividir por cero");

        }

    }

}
