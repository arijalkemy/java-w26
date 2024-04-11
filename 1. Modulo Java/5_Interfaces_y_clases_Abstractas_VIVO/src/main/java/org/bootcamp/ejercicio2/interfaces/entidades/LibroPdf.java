package org.bootcamp.ejercicio2.interfaces.entidades;

import org.bootcamp.ejercicio2.interfaces.Documento;

public class LibroPdf implements Documento {
    private int cantidadDePaginas;
    private String nombreAutor;
    private String titulo;
    private String genero;


    public LibroPdf(int cantidadDePaginas, String nombreAutor, String titulo, String genero) {
        this.cantidadDePaginas = cantidadDePaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "LibroPdf{" +
                "cantidadDePaginas=" + cantidadDePaginas +
                ", nombreAutor='" + nombreAutor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
