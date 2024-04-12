package ex2;

public class PDF {
    String author;
    int cantidadPaginas;
    String titulo;
    String genero;

    public PDF(String author, int cantidadPaginas, String titulo, String genero) {
        this.author = author;
        this.cantidadPaginas = cantidadPaginas;
        this.titulo = titulo;
        this.genero = genero;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
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
        return "PDF{" +
                "author='" + author + '\'' +
                ", cantidadPaginas=" + cantidadPaginas +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
