package org.example;

public class LibrosEnPdf {
    private int cantidadDePaginas;
    private String nombreAutor;
    private String titulo;
    private String genero;

    public int getCantidadDePaginas() {
        return cantidadDePaginas;
    }

    public LibrosEnPdf setCantidadDePaginas(int cantidadDePaginas) {
        this.cantidadDePaginas = cantidadDePaginas;
        return this;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public LibrosEnPdf setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
        return this;
    }

    public String getTitulo() {
        return titulo;
    }

    public LibrosEnPdf setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public String getGenero() {
        return genero;
    }

    public LibrosEnPdf setGenero(String genero) {
        this.genero = genero;
        return this;
    }
}
