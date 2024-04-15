package org.example;

import org.example.clases.Curriculum;
import org.example.clases.Informe;
import org.example.clases.LibroEnPdf;
import org.example.interfaces.Imprimible;

import java.util.List;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        // se instancia cada tipo de documento
        LibroEnPdf harryPotter = new LibroEnPdf(2,"JK ROWLING","HARRY POTTER", "fantasia");
        Informe informeEjemplo = new Informe(" tecto de prueba", 20,"Juan","Alfonso");
        Curriculum miCurriculum = new Curriculum("Pedro", "Gracia", "2132121", "calle 20", List.of("excel", "powerPoint","java", "AWS"));
        // se imprimen los documentos mediante la interface
        Imprimible.imprimir(harryPotter);
        Imprimible.imprimir(informeEjemplo);
        Imprimible.imprimir(miCurriculum);
    }
}
