package org.example.model;

public class LibroPDF extends Documento{

    private String titulo;
    private String genero;

    public LibroPDF(String autor, int cantidadPaginas, String titulo, String genero) {
        super(autor, cantidadPaginas);
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public String obtenerContenido() {
        return "Titulo: " + this.titulo + "\nGenero: " + this.genero;
    }
}
