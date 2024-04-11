package org.example;

public class LibroEnPDF implements IImprimible{
    private int cantidadDePaginas;
    private String nombreAutor;
    private String titulo;
    private String genero;

    public LibroEnPDF(int cantidadDePaginas, String nombreAutor, String titulo, String genero){
        this.cantidadDePaginas = cantidadDePaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    public void imprimir(){
        System.out.println("Nombre: " + this.nombreAutor + ". Titulo: " + this.titulo + ". Cantidad de paginas: " + this.cantidadDePaginas + ". Genero: " + this.genero);
    }

}
