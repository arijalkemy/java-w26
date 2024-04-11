package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<IImprimible> imprimibles = new ArrayList<IImprimible>();
        ArrayList<String> habilidades = new ArrayList<String>();
        habilidades.add("2 años de experiencia en Java");
        habilidades.add("Manejo de bases de datos relacionales");
        habilidades.add("Trabajo en equipo");
        imprimibles.add(new Curriculum("John Doe", habilidades));

        imprimibles.add(new LibroPDF(
                "Harry Potter y la Piedra Filosofal",
                "J. K. Rowling",
                "Fantasía",
                1200
        ));
        imprimibles.add(new Informe(
                "Este es un informe muy muy muy muy muy muy muy muy muy muy muy muy muy largo ",
                100,
                "Yo",
                "También yo"));

        imprimibles.forEach(IImprimible::imprimir);
    }
}

