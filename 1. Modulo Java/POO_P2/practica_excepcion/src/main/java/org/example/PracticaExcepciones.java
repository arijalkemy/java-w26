package org.example;

public class PracticaExcepciones {
    int a = 0;
    int b = 300;

    public void mostrarExcepecion() {
        try{
            double resultado = b/a;
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Programa finalizado");
        }
    }

    public void lanzarExcepecion() {
        try{
            double resultado = b/a;
        }catch (ArithmeticException e){
            throw new IllegalArgumentException("No se puede dividir por 0");
        }finally {
            System.out.println("Programa finalizado");
        }
    }
}
