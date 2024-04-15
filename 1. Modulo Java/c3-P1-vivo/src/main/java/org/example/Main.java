package org.example;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> listaHabilidades = new ArrayList<>();
        listaHabilidades.add("Java");
        listaHabilidades.add("Python");

        Documento curriculum = new Curriculum(new Persona("Juan", listaHabilidades));


        Imprimible.imprimirDocumento(curriculum);
    }
}