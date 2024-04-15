package org.example;

public class App
{
    public static void main( String[] args )
    {
        Curriculum cv = new Curriculum("Jonathan", "Perez", 24, new String[]{"Responsable", "Programación"});
        cv.print();

        Informe informe = new Informe("Hola mundo!", 100, "Alan Turing", "Javier Santaolalla");
        informe.print();

        Libro libro = new Libro(92, "Antoine de Saint Exupéry", "El principito", "Literatura infantil");
        libro.print();
    }
}
