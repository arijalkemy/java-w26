package org.ejercicio2.clases;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Persona persona = new Persona("Jose", "Perez");
        List<String> habilidades = new ArrayList<>();
        habilidades.add("Leer");
        habilidades.add("Escribir");

        Curriculum curriculum = new Curriculum(persona, habilidades);
        System.out.println("\nImprimiendo Curriculum...");
        curriculum.imprimir();

        Libro libro = new Libro(persona, 150, "El viaje loco", "Fantasía");
        System.out.println("\nImprimiendo Libro...");
        libro.imprimir();

        Persona revisor = new Persona("Alvaro", "Mendez");
        Informe informe = new Informe(
            "Esto se va a descontroolaaaar.",
            1,
            persona,
            revisor
        );
        System.out.println("\nImprimiendo Informe...");
        informe.imprimir();
    }

}
