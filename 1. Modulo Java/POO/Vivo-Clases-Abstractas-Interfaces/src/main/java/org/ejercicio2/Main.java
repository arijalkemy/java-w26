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

        Libro libro = new Libro(400, "J.R.R Tolkien", "El Señor de los Anillos", "Ficcion");
        LibrosEnPDFImpl libroPdf = new LibrosEnPDFImpl(libro);
        libroPdf.imprimir();

        Informes informe = new Informes("Jorge", 55, "ASDJASDLSAKJDLASKDJLASDJ ASLKDJLASKDJASL ASKDJLASJDSLAKDJ ALSDKASJD");
        Informesimpl informePDF = new Informesimpl(informe);
        informePDF.imprimir();


    }

}
