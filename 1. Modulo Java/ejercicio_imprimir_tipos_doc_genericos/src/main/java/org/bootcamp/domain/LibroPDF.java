package org.bootcamp.domain;

public class LibroPDF {

    private int cantidadPaginas;
    private String nombreAutor;
    private String titulo;
    private String genero;

    public LibroPDF() {
    }

    public LibroPDF(int cantidadPaginas, String nombreAutor, String titulo, String genero) {
        this.cantidadPaginas = cantidadPaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("\n\n--- LibroPDF ---");
        sb.append("\ncantidad de páginas: ").append(cantidadPaginas);
        sb.append("\nnombre del autor: ").append(nombreAutor);
        sb.append("\ntítulo: ").append(titulo);
        sb.append("\ngénero: ").append(genero);
        return sb.toString();
    }
}
