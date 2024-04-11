package org.example;

import java.util.ArrayList;

public class Curriculum implements IImprimible {

    private String nombre;
    private ArrayList<String> habilidades;

    public Curriculum(String nombre, ArrayList<String> habilidades) {
        this.nombre = nombre;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("Currículum Vitae");
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Habilidades:");
        this.habilidades.stream().map(h -> "- " + h).forEach(System.out::println);
        System.out.println("\n");
    }
}

