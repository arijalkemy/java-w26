package org.example;

import logica.Curriculum;
import logica.DocumentoImpl;
import logica.Informe;
import logica.LibroPDF;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        DocumentoImpl libroPDF = new LibroPDF(100, "JK Rowling", "Harry Potter y el prisionero de Azkaban", "Fantasía");
        DocumentoImpl informe = new Informe("lorem ipsum dolor sit amet", 10, "Marie Curie", "Albert Einstein");
        DocumentoImpl curriculum = new Curriculum("Tomás Donzis", "tomas.donzis@mercadolibre.com", 23, "12345678", new ArrayList<>());
        System.out.println("_______________ Documentos _________________");
        System.out.println("Extracción de información de libro PDF");
        libroPDF.imprimir();
        System.out.println("");
        System.out.println("Extracción de información de Informe");
        informe.imprimir();
        System.out.println("");
        System.out.println("Extracción de información de curriculum");
        curriculum.imprimir();
        System.out.println("");
        ((Curriculum)curriculum).agregarHabilidad("Nada");
        ((Curriculum)curriculum).agregarHabilidad("OOP");
        curriculum.imprimir();
    }
}
