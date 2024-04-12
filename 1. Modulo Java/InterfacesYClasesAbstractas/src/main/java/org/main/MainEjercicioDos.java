package org.main;

import org.ejerciciodos.entities.Curriculum;
import org.ejerciciodos.entities.Informe;
import org.ejerciciodos.entities.LibroPDF;
import org.ejerciciodos.entities.Persona;

import java.util.ArrayList;
import java.util.Arrays;

public class MainEjercicioDos {
    public static void main(String[] args) {
        System.out.println(" ");
        Persona persona = new Persona("Julio","Perez",50, Arrays.asList("Ingenieria","Empatia","Resolucion"));
        Curriculum curriculum = new Curriculum(persona);
        curriculum.imprimir();
        System.out.println(" ");
        Informe informe = new Informe("HolaaaaaaaaaaaaasdasdasdasdasdasdDASasd",10,"Pepito","El otro Pepito");
        informe.imprimir();
        System.out.println(" ");
        LibroPDF libroPDF = new LibroPDF("Harry Potter",300,"No sé xd", "No sé");
        libroPDF.imprimir();
    }
}
