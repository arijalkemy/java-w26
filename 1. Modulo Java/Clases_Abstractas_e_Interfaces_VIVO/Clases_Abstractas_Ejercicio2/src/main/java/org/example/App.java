package org.example;

import java.util.Arrays;

public class App
{
    public static void main( String[] args )
    {
        Libros libro = new Libros("Gabriel García Márquez", "Cien años de soledad", "Realismo mágico", 417);

        Informe informe = new Informe("John Doe", "Este es el texto del informe", "Jane Doe", 1500, 30);

        Curriculum curriculum = new Curriculum("Juan Pérez", "Calle Falsa 123, Ciudad, País", "juan.perez@email.com", "+1234567890", Arrays.asList("Java", "Spring Boot", "SQL"));

        libro.imprimir();
        System.out.println("=====================================");
        informe.imprimir();
        System.out.println("=====================================");
        curriculum.imprimir();
    }
}
