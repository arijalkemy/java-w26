package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        Libro libro = new Libro("Vuelta al mundo en 80 dias", "No se", 33);

        System.out.println(libro.mostrarLibro());

        System.out.println("La cantidad de ejemplares es de " + libro.cantidadDeEjemplares());

        Libro.probando();
    }
}
