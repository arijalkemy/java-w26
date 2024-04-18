package org.example;

public class PracticaExcepciones {

    private int a = 0;
    private int b = 300;

    public void calcularCociente (){
        try{
            int cosciente = this.b / this.a;

        }
        catch (IllegalArgumentException e)
        {
            throw new IllegalArgumentException("No se puede dividir por 0 ");
        }
        finally {
            System.out.println("Programa finalizado");
        }
    }
}
