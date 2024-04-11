package org.example;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Curriculum cv = new Curriculum("Maca", "Caridad", List.of("Empatía", "Proactividad", "Ingenio"));
        LibroPDF pdf = new LibroPDF(5, "Maca", "Cinco palabras", "Ficción");
        Informes informe = new Informes("Había una vez...", 10, "Maca", "Arturo");
        IImprimir.imprimir(cv);
        IImprimir.imprimir(pdf);
        IImprimir.imprimir(informe);
    }
}
