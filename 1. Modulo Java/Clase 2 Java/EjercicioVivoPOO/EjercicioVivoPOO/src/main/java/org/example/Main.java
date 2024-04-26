package org.example;

public class Main {
    public static void main(String[] args) {

        PracticaExcepciones practicaExcepciones= new PracticaExcepciones();
        try {
            practicaExcepciones.calcularCociente();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Programa finalizado");
        }

    }
}