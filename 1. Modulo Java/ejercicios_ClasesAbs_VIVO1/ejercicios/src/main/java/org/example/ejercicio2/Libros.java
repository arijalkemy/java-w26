package org.example.ejercicio2;

public class Libros {
    public int cantidadDePaginas;
    public String nombreDelAutor;
    public String titulo;
    public String genero;

    public Libros(int cantidadDePaginas, String nombreDelAutor, String titulo, String genero) {
        this.cantidadDePaginas = cantidadDePaginas;
        this.nombreDelAutor = nombreDelAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Libro: "+this.titulo+
                ", Cantidad de paginas: "+this.cantidadDePaginas+
                ", Nombre del Autor: "+this.nombreDelAutor+
                ", Género: "+this.genero;
    }
}
