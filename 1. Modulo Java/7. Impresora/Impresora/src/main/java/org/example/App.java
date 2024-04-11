package org.example;

import java.util.ArrayList;

public class App
{
    public static void main(String[] args) {

        Curriculum cv = new Curriculum("Persona1", 20, new ArrayList<>());
        PDF pdf = new PDF(100, "Persona 2", "Titulo1", "Terror");
        Informe informe = new Informe("Autor 1", "Revisor 1", 120,"aovnaorifnodanvoá");

        Documentos.imprimeDocumento(cv);
        Documentos.imprimeDocumento(pdf);
        Documentos.imprimeDocumento(informe);
    }
}
