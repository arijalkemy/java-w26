package com.example;

public class LibrosEnPDF implements Imprimible{
    int cantidadPaginas;
    String nombreAutor;
    String titulo;
    String genero;


    public LibrosEnPDF(int cantidadPaginas, String nombreAutor, String titulo, String genero) {
        this.cantidadPaginas = cantidadPaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }


    @Override
    public void imprimir() {
        System.out.printf("El libro %s tiene una cantidad de %d paginas siendo la obra mas larga del famoso autor: %s y del genero %s%n",titulo,cantidadPaginas,nombreAutor,genero);
    }
}
