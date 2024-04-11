package org.example.clases;

public class Libro {

    private final String titulo;
    private final String autor;
    private final String genero;
    private final int cantidadPaginas;

    public Libro(String titulo, String autor, String genero, int cantidadPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.cantidadPaginas = cantidadPaginas;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", gendero='" + genero + '\'' +
                ", cantidadPaginas=" + cantidadPaginas +
                '}';
    }
}
