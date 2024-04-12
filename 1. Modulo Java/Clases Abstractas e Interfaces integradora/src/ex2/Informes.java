package ex2;

public class Informes {
    String texto;
    int cantidadPaginas;
    String author;
    String resivor;

    public Informes(String texto, int cantidadPaginas, String author, String resivor) {
        this.texto = texto;
        this.cantidadPaginas = cantidadPaginas;
        this.author = author;
        this.resivor = resivor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getResivor() {
        return resivor;
    }

    public void setResivor(String resivor) {
        this.resivor = resivor;
    }


    @Override
    public String toString() {
        return "Informes{" +
                "texto='" + texto + '\'' +
                ", cantidadPaginas=" + cantidadPaginas +
                ", author='" + author + '\'' +
                ", resivor='" + resivor + '\'' +
                '}';
    }
}
