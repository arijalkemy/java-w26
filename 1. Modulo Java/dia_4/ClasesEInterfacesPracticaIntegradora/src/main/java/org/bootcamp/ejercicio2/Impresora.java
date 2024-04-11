package org.bootcamp.ejercicio2;

import org.bootcamp.ejercicio2.entidades.Curriculum;
import org.bootcamp.ejercicio2.entidades.Documento;
import org.bootcamp.ejercicio2.entidades.Informe;
import org.bootcamp.ejercicio2.entidades.LibroPdf;

import java.util.List;

public class Impresora {
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum("Edwin", List.of("Comunicación", "Trabajo en equipo"));
        curriculum.imprimirDocumento();
        Informe informe = new Informe("Informe contenido", 23, "Auto1", "Revisor1");
        informe.imprimirDocumento();
        LibroPdf libroPdf = new LibroPdf(233, "Edwin", "Titulo", "Comedia");
        libroPdf.imprimirDocumento();
    }
}
