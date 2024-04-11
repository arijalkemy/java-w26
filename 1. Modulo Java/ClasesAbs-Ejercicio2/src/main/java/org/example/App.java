package org.example;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Persona persona = new Persona("A", "B");
        IImprimir curriculum = new Curriculum(persona, new ArrayList<>());
        IImprimir libro = new Libro(2, "A", "B", "C");
        IImprimir informe = new Informe(1, 2, "A", "B");

        curriculum.imprimir();
        libro.imprimir();
        informe.imprimir();
    }
}
