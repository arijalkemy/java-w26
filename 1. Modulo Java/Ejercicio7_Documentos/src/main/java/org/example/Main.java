package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> habilidades = new ArrayList<>();
        habilidades.add("Ponchar cables");
        habilidades.add("Arreglar cosas");
        habilidades.add("Circuitos");
        Curriculum curriculum = new Curriculum("Pedro Ortiz", "123123124", "Ing Eléctrico", habilidades);
        LibroPDF libroPDF = new LibroPDF(10, "Libro Random", "Autor Random", "Titulo Random", "Genero Random");
        Informe informe = new Informe("adfjañsddfjlasdjflasdjfoijqerjq", 54234, "Autor Random", "Alguien");

        System.out.println("Tipo - Curriculum");
        System.out.println("------------------------------");
        curriculum.imprimir();
        System.out.println("------------------------------");
        System.out.println("Tipo - Libro en PDF");
        System.out.println("------------------------------");
        libroPDF.imprimir();
        System.out.println("------------------------------");
        System.out.println("Tipo - Informes");
        System.out.println("------------------------------");
        informe.imprimir();
    }
}