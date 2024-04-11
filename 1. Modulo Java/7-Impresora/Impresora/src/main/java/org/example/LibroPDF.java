package org.example;

public class LibroPDF implements IImprimir{

    private Integer cantPaginas;
    private String autor;
    private String titulo;
    private String genero;

    public LibroPDF(Integer cantPaginas, String autor, String titulo, String genero) {
        this.cantPaginas = cantPaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Libro: "+titulo+" tiene "+cantPaginas+" páginas";
    }
}
