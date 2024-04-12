package org.ejercicio2.clases;

import org.ejercicio2.interfaces.IDocumento;

public class Libro implements IDocumento {

    private Persona autor;
    private int cantidadPaginas;
    private String titulo;
    private String genero;


    public Libro(Persona autor, int cantidadPaginas, String titulo, String genero) {
        this.autor = autor;
        this.cantidadPaginas = cantidadPaginas;
        this.titulo = titulo;
        this.genero = genero;
    }


    public Persona getAutor() {
        return autor;
    }

    public void setAutor(Persona autor) {
        this.autor = autor;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }


    @Override
    public void imprimir() {
        System.out.println("Nombre del libro: " + this.titulo);
        System.out.println("Autor: " + this.autor);
        System.out.println("Género: " + this.genero);
        System.out.println("Cantidad de páginas: " + this.cantidadPaginas);
    }

}
