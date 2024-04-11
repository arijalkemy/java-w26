package com.meli;

public class Libro implements Imprimible{
    private String titulo;
    private String autor;
    private int paginas;
    private String genero;

    public Libro(String titulo, String autor, int paginas, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println("Titulo: " + titulo + " Autor: " + autor + " Paginas: " + paginas + "Genero: " +genero);
    }
}
