package org.example;

public class Libro implements IImprimible{
    private int nPaginas;
    private String autor;
    private String titulo;
    private String genero;

    public Libro(int nPaginas, String autor, String titulo, String genero) {
        this.nPaginas = nPaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "nPaginas=" + nPaginas +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }

    @Override
    public void print() {
        System.out.println(this.toString());
    }
}
