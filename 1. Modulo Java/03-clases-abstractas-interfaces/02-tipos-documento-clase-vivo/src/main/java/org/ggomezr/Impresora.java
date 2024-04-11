package org.ggomezr;

public class Impresora {
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum("Geraldine", 20, "Java, Python, SQL");
        LibroPDF libroPDF = new LibroPDF(1200, "Stephen King", "IT", "Terror");
        Informe informe = new Informe("Informe sobre el cambio climatico", 27, "Dr. Smith", "Dr. Johnson");

        System.out.println("\n----- Impresion Curriculum -----\n");
        Imprimible.imprimir(curriculum);

        System.out.println("\n----- Impresion Libro PDF -----\n");
        Imprimible.imprimir(libroPDF);

        System.out.println("\n----- Impresion Informe -----\n");
        Imprimible.imprimir(informe);
    }
}