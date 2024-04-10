package org.example;

public class Main {
    public static void main(String[] args) {

        Persona personaVacia = new Persona();
        Persona personaAMedias = new Persona("Mateo", 23, "12312345");
        Persona personaCompleta = new Persona("Exequiel", 23, "12123123", 75, 1.75);
        // Persona personaSinEdad = new Persona("Juan", 25);
        // Esto no funciona porque no existe un constructor para estos parámetros
    }
}

