package com.company.classes;

import com.company.interfaces.Imprimible;

public class Pdf implements Imprimible {

    private int cantidadDePaginas;
    private String nombreAutor;
    private String titulo;
    private String genero;

    public Pdf(int cantidadDePaginas, String nombreAutor, String titulo, String genero) {
        this.cantidadDePaginas = cantidadDePaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println(
                "Pdf{" +
                        "cantidadDePaginas=" + cantidadDePaginas +
                        ", nombreAutor='" + nombreAutor + '\'' +
                        ", titulo='" + titulo + '\'' +
                        ", genero='" + genero + '\'' +
                        '}'
        );
    }
}
