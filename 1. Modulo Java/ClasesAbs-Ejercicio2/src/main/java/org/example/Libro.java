package org.example;

public class Libro implements IImprimir{
    private int cantidadDePaginas;
    private String nombreDelAutor;
    private String titulo;
    private String genero;

    public Libro(int cantidadDePaginas, String nombreDelAutor, String titulo, String genero) {
        this.cantidadDePaginas = cantidadDePaginas;
        this.nombreDelAutor = nombreDelAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo libro...");
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Libro{" +
                "cantidadDePaginas=" + cantidadDePaginas +
                ", nombreDelAutor='" + nombreDelAutor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
