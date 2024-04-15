package org.example;

public class PracticaExcepciones { //clase Practica Excepciones

    int a=0,b=300; // Definicion y asignacion de valores de las variables a y b
    public void calcular() {
        try {
            System.out.println(b / a);//operacion que nos generara la excepcion
        } catch (ArithmeticException e) {
            //System.out.println("Se ha producido un error"); //mensaje a imprimir al controlar la excepcion
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado"); //mensaje que se mostrara siempre al finalizar el programa
        }//bloque try catch

    }

}
