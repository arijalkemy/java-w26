package org.example.Ejercio2;

import java.awt.*;
import java.util.ArrayList;

public class Impresora {
    //Representar un escenario donde se creen cada uno de estos objetos y que,
    // por medio de un método estático de una interfaz imprimible, se pueda pasar
    // cualquier tipo de documento y sea impreso el contenido.

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Java");
        list.add("PHP");
        list.add("js");

        Persona persona = new Persona("Marie U",25,"12345678");
        Curriculum cv = new Curriculum(persona,list,"5 años de experiencia");
        LibrosPDF libro = new LibrosPDF(10,"Ficcion","Dinos","Martin");
        Informes informes = new Informes("Lorem lorem lorem ....","Juan","Pipo",100);

        cv.imprimirDocumento();
        libro.imprimirDocumento();
        informes.imprimirDocumento();

    }
}
