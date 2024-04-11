package meli.bootcamp.Documentos.entidades;

import meli.bootcamp.Documentos.interfaces.Documento;

public class LibroPdf implements Documento {
    private int cantidadDePaginas;
    private String nombreAutor;
    private String titulo;
    private String genero;

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
