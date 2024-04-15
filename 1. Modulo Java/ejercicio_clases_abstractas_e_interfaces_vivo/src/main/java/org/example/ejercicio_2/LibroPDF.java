package org.example.ejercicio_2;

public class LibroPDF implements Imprimible{
    private int cantidadDePaginas;
    private String titulo;
    private String autor;
    private String genero;

    public LibroPDF(int cantidadDePaginas, String titulo, String autor, String genero) {
        this.cantidadDePaginas = cantidadDePaginas;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
    }

    @Override
    public String contenido() {
        return "Cantidad de Páginas: " + cantidadDePaginas + ", Titulo: " + titulo + ", Autor: " + autor + ", Género : " + genero;
    }
}
