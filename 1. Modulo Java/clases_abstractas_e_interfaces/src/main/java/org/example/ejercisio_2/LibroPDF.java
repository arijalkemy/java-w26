package org.example.ejercisio_2;

public class LibroPDF implements IDocumento{
    private int cantidadDePaginas;
    private String nombreAutor;
    private String titulo;
    private String genero;

    public LibroPDF(int cantidadDePaginas, String nombreAutor, String titulo, String genero) {
        this.cantidadDePaginas = cantidadDePaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LibroPDF{");
        sb.append("cantidadDePaginas=").append(cantidadDePaginas);
        sb.append(", nombreAutor='").append(nombreAutor).append('\'');
        sb.append(", titulo='").append(titulo).append('\'');
        sb.append(", genero='").append(genero).append('\'');
        sb.append('}');
        return sb.toString();
    }
}