package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        List<String> habilidades = new ArrayList();
        habilidades.add("Una banda");
        habilidades.add("xd");

        Persona p = new Persona("Joaquin", "Gual", "41152547", habilidades);
        Curriculum c = new Curriculum(p);

        Informe f = new Informe("Hola pedrito",3,"Rodrigo","Joitix");

        LibroPDF lPDF = new LibroPDF(3,"Rodri","El libro de rodrix","Comedia");

        Impresora.imprimir(c);
        Impresora.imprimir(f);
        Impresora.imprimir(lPDF);

    }
}
