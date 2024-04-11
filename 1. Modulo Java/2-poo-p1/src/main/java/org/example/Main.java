package org.example;

public class Main {
    public static void main(String[] args) {


        Persona personaVacio = new Persona();

        Persona personaAmedias = new Persona("Jose", "123454", 15 );

        Persona personaCompleta = new Persona("Pedro", "9876543", 34, 87.0, 1.89);

        //Persona personaConflictiva = new Persona("facundo", 10); Esto da error, ya que no existe dicho constructor y no se puede resolver el conflicto

        int valor=personaCompleta.calcularIMC();

        switch (valor) {
            case -1: System.out.println(personaCompleta.getNombre()+" tiene un bajo peso"); break;
            case 0: System.out.println(personaVacio.getNombre()+" tiene un peso saludable"); break;
            case 1: System.out.println(personaAmedias.getNombre()+" tiene sobrepeso"); break;
        }
    }
}