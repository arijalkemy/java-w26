package ej2;

import java.util.ArrayList;

public class MainDocs {
    public static void main(String[] args) {
        LibroPDF libroPDF = new LibroPDF(100, "JK Rowling", "Harry Potter y el prisionero de Azkaban", "Fantasía");
        Informe informe = new Informe("lorem ipsum dolor sit amet", 10, "Marie Curie", "Albert Einstein");
        Curriculum curriculum = new Curriculum("Tomás Donzis", "tomas.donzis@mercadolibre.com", 23, "12345678", new ArrayList<>());

        libroPDF.imprimir();
        informe.imprimir();
        curriculum.imprimir();

        curriculum.agregarHabilidad("Nada");
        curriculum.agregarHabilidad("OOP");
        curriculum.imprimir();
    }
}
