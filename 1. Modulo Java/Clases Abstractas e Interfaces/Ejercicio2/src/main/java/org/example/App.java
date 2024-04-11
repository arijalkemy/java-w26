package org.example;

import org.example.archivos.Curriculum;
import org.example.archivos.Informe;
import org.example.archivos.LibroEnPDF;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum("Lautaro Oleastro", List.of("Python", "Java", "POO"));
        LibroEnPDF libroEnPDF = new LibroEnPDF("Albert Camus", 234, "Ficcion");
        Informe informe = new Informe("lorem ipsum", 15, "Profesor X", "Doctor Y");
        
    }
}
