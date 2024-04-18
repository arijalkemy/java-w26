package org.example;

import org.example.model.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum(new Persona("Juanita","Perez",34,"Ingeniera","juanita@hotmail","320324234"), Arrays.asList("Amigable", "Emprendedora","Trabajadora"));
        curriculum.imprimirDocumento();

        Informe informe = new Informe("Información relevante",2,"Juanito Perez","Marcos Garcia");
        informe.imprimirDocumento();

        LibroPDF libroPDF = new LibroPDF(2,100, "Gabriel Garcia Marquez", "Cien años de Soledad", "Realismo Magico");
        libroPDF.imprimirDocumento();
    }
}