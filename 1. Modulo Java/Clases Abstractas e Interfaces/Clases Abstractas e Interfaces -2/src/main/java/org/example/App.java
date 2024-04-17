package org.example;
import java.util.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<String> habilidades = new ArrayList();
        habilidades.add("Java");
        habilidades.add("SQL");

        Curriculums curriculums = new Curriculums("Mario","Lozano", 28, habilidades);
        System.out.println("Datos Curriculums");
        curriculums.imprimir();
        System.out.println("");


        System.out.println("Datos Informes");
        Informes informes = new Informes("Lorem Ipsum", 150, "Gabo", "Entidad Revisor");
        informes.imprimir();
        System.out.println("");

        System.out.println("Datos Libros PDF");
        LibrosPDF librosPDF = new LibrosPDF(20, "Juan", "El principito", "Infantil");
        librosPDF.imprimir();

    }


}
