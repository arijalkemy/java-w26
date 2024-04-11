package org.example.ejercicios.dos.clases;

import org.example.ejercicios.dos.Interfaces.Imprimible;

public class Libro implements Imprimible {
    private String genero;
    private int cantidadPaginas;
    private String titulo;
    private String autor;

    public Libro(String genero, int cantidadPaginas, String titulo, String autor) {
        this.genero = genero;
        this.cantidadPaginas = cantidadPaginas;
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public void imprimir() {
        System.out.println("Título: " + this.titulo);
        System.out.println("Autor: " + this.autor);
        System.out.println("Revisor: " + this.genero);
        System.out.println("Cantidad de paginas: " + this.cantidadPaginas);
    }
}
