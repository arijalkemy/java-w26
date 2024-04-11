package org.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Persona persona = new Persona("Jose", "Perez");
        List<String> habilidades = new ArrayList<>();
        habilidades.add("Leer");
        habilidades.add("Escribir");

        CurriculumImpl curriculum = new CurriculumImpl(persona, habilidades);
        curriculum.imprimir();


    }

}
