package org.example;

public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public void calcularCocienteUno(){
        try {
            int resultado = b / a;
        } catch (Exception exception){
            System.out.println("Se ha producido un error.");
        } finally {
            System.out.println("Programa finalizado");
        }
    }

    public void calcularCocienteDos(){
        try {
            int resultado = b / a;
        } catch (Exception exception){
            throw new IllegalArgumentException("No se puede dividir por cero.");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
