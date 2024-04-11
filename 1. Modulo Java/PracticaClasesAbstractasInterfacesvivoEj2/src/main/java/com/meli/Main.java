package com.meli;

import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;

public class Main {
    public static void main(String[] args) {
        List<String> habilidades= new ArrayList<>();
        habilidades.add("Java");
        habilidades.add("Spring");
        habilidades.add("Hibernate");
        habilidades.add("Angular");


        System.out.println("----- Curriculum -----");
        Curriculum curriculum = new Curriculum("Juan", "Perez", 30, habilidades);
        curriculum.imprimir();

        System.out.println("----- Libro -----");
        Libro libro = new Libro("El señor de los anillos", "J.R.R. Tolkien", 1000, "Fantasia");
        libro.imprimir();

        System.out.println("----- Informes -----");
        Informes informe = new Informes(100,50,"Juan Perez", "Andres Perez");
        informe.imprimir();







    }
}