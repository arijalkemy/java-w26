package org.example.model;

public abstract class Documento {

    private String autor;
    private int cantidadPaginas;

    public Documento(String autor, int cantidadPaginas) {
        this.autor = autor;
        this.cantidadPaginas = cantidadPaginas;
    }

    public abstract String obtenerContenido();

    public String getAutor() {
        return autor;
    }
}
