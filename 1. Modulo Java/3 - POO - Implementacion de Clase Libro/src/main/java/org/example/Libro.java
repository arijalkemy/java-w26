package org.example;

public class Libro {

    String titulo;
    String autor;
    int ejemplares;

    public Libro(String titulo, String autor, int ejemplares){
        this.titulo = titulo;
        this.autor = autor;
        this.ejemplares = ejemplares;
    }

    public int cantidadEjemplares(){
        return this.ejemplares;
    }

    public String mostrarLibro(){
        return "Titulo: " + this.titulo + " Autor: " + this.autor + " Ejemplares: " + this.ejemplares;
    }
}
