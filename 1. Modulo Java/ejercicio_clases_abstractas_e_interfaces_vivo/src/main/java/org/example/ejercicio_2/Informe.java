package org.example.ejercicio_2;

public class Informe implements Imprimible {
    private int longitud;
    private int cantidadDePaginas;
    private String autor;
    private String revisor;

    public Informe(int longitud, int cantidadDePaginas, String autor, String revisor) {
        this.longitud = longitud;
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public String contenido() {
        return "Longitud: " + longitud + ", Páginas: " + cantidadDePaginas + ", Autor: " + autor + ", Revisor: " + revisor;
    }
}
