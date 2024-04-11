package org.example.archivos;

public class LibroEnPDF implements IArchivo {
    private String nombreDelAutor;
    private Integer cantidadDePaginas;
    private String genero;

    public LibroEnPDF(String nombreDelAutor, Integer cantidadDePaginas, String genero) {
        this.nombreDelAutor = nombreDelAutor;
        this.cantidadDePaginas = cantidadDePaginas;
        this.genero = genero;
    }

    @Override
    public String getContenido() {
        return "Autor: " + this.nombreDelAutor + "Cantidad de paginas: " + this.cantidadDePaginas + "Genero: " + this.genero;
    }
}
