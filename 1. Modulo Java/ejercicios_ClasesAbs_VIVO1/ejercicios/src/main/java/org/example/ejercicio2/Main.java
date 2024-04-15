package org.example.ejercicio2;


import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main( String[] args ) {
        Libros libro = new Libros(233,"J K Rowling","Harry Potter","Fantasia");
        IImprimible.imprimir(libro);
        Informe informe = new Informe("Este es el texto del informe el cual es demasiado largo",12,"Pepito","Juanito");
        IImprimible.imprimir(informe);
        Curriculum curriculum = new Curriculum("Armando","Paredes", Arrays.asList("Java","JavaScript","TypeScript"));
        IImprimible.imprimir(curriculum);
    }

}
