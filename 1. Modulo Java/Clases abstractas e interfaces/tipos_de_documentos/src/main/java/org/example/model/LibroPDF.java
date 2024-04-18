package org.example.model;

public class LibroPDF implements Imprimible{
    private int cantidad;
    private int cantidadPaginas;
    private String nombreAutor;
    private String titulo;
    private String genero;

    public LibroPDF() {
    }

    public LibroPDF(int cantidad, int cantidadPaginas, String nombreAutor, String titulo, String genero) {
        this.cantidad = cantidad;
        this.cantidadPaginas = cantidadPaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
        return "Libro PDF: " + "\n"+
                "  Cantidad: " + cantidad + "\n"+
                "  Cantidad Paginas: " + cantidadPaginas + "\n"+
                "  Nombre Autor: " + nombreAutor + "\n"+
                "  Titulo: " + titulo + "\n"+
                "  Genero: " + genero + "\n";
    }


    @Override
    public void imprimirDocumento() {
        System.out.println(this);
    }

    @Override
    public void imprimirTipoDocumento() {
        System.out.println("Libro PDF");
    }
}
