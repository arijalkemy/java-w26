package org.example;

import org.example.model.Curriculum;
import org.example.model.IDocumentos;
import org.example.model.Persona;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum(new Persona("Juanita","Perez",34,"Ingeniera","juanita@hotmail","320324234"), Arrays.asList("Amigable", "Emprendedora","Trabajadora"));

    }
}
