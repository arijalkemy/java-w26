package Clases;

import Interfaces.Imprimible;

public class LibrosPdf implements Imprimible {
    private int cantidadDePaginas;
    private String nombreAutor;
    private String titulo;
    private String genero;

    public LibrosPdf(int cantidadDePaginas, String nombreAutor, String titulo, String genero) {
        this.cantidadDePaginas = cantidadDePaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public String imprimirDocumento() {
        return "Titulo: " + titulo + "\n" +
                "Nombre del autor: " + nombreAutor + "\n" +
                "Genero: " + genero + "\n" +
                "Cantidad de paginas: " + cantidadDePaginas + "\n";
    }

}
