package meli.bootcamp.Documentos;

import meli.bootcamp.Documentos.entidades.Curriculum;

import java.util.ArrayList;
import java.util.List;


public class Impresora {
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum("SOME", List.of("h1", "h2", "h3"));
        curriculum.imprimir(curriculum);
    }
}
