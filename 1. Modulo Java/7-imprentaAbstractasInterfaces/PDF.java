public class PDF {
    private int cantidadPaginas;
    private String autor;
    private String titulo;
    private String generoLibro;

    public PDF() {

    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGeneroLibro() {
        return generoLibro;
    }

    public void setGeneroLibro(String generoLibro) {
        this.generoLibro = generoLibro;
    }

    //se emplea toString para facilitar la impresion en el metodo utilitario

    @Override
    public String toString() {
        return "PDF:  " +
                "Cantidad de Paginas=" + cantidadPaginas +
                ", Autor='" + autor + '\'' +
                ", Aitulo='" + titulo + '\'' +
                ", Genero del Libro='" + generoLibro + '\'';
    }
}
