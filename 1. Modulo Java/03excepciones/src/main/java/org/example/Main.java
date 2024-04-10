package org.example;

public class Main {
    public static void main(String[] args) {
           PracticaExcepciones practica = new PracticaExcepciones(0, 300);
           try {
               int cociente = practica.calcularCociente();
               System.out.println("El cociente es: " + cociente);
           } catch (IllegalArgumentException e) {
               System.out.println(e.getMessage());
           } finally {
               System.out.println("Programa finalizado");
           }
    }
}

