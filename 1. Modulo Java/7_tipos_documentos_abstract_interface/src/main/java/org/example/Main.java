package org.example;

import org.example.clases.CV;
import org.example.clases.Informe;
import org.example.clases.Libro;
import org.example.clases.Persona;
import org.example.interfaces.IImprimible;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona("Matias", "Pinto", 26);

        CV cv = new CV(persona, new ArrayList<>(List.of("Futbol", "Bicicleta")));
        Libro libro = new Libro("SdlA", "Tolkien", "Fantasia", 500);
        Informe  informe = new Informe("Lorem ipsum", "Mati", "Fausto", 100);

        System.out.println("CV:");
        IImprimible.imprimir(cv);
        System.out.println();

        System.out.println("LIBRO:");
        IImprimible.imprimir(libro);
        System.out.println();

        System.out.println("INFORME:");
        IImprimible.imprimir(informe);
        System.out.println();

    }
}