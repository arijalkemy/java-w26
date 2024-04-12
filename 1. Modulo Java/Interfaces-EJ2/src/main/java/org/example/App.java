package org.example;

import org.example.documentos.Curriculum;
import org.example.documentos.Informe;
import org.example.documentos.LibroPDF;

public class App
{
    public static void main( String[] args )
    {
        Curriculum curriculum = new Curriculum("Curriculum", "Vitae", 30, "Java");
        curriculum.imprimir();

        LibroPDF libroPDF = new LibroPDF(200, "Autor", "Libro", "Ficción");
        libroPDF.imprimir();

        Informe informe = new Informe("Informe", 10, "Autor", "Revisor");
        informe.imprimir();
    }
}
