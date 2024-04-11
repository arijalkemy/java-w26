package org.bootcamp.ejercicio2.interfaces;

import org.bootcamp.ejercicio2.interfaces.entidades.Curriculum;
import org.bootcamp.ejercicio2.interfaces.entidades.Informe;
import org.bootcamp.ejercicio2.interfaces.entidades.LibroPdf;

import java.util.List;
public class Impresora {
    public static void main(String[] args) {
        List<String> habilidades = List.of("Lider", "Agil", "Pragmatico");
        Curriculum curriculum = new Curriculum("SOME",habilidades);

        Informe informe = new Informe("Lorem Ipsim ", 24,"Luis Juan Milton","Fernando Uribe");

        LibroPdf pdf = new LibroPdf(35,"Johan Suarez","Fundamentos de Electromagnetismo","Ciencia");
        curriculum.imprimir(curriculum);
        informe.imprimir(informe);
        pdf.imprimir(pdf);

    }
}
