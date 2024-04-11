public class Informes {
    private String texto;
    private int cantidadPaginas;
    private String autor;
    private String revisor;

    public Informes() {
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    //se emplea toString para facilitar la impresion en el metodo utilitario

    @Override
    public String toString() {
        return "Informes:  " +
                "texto='" + texto + '\'' +
                ", Cantidad de Paginas=" + cantidadPaginas +
                ", Autor='" + autor + '\'' +
                ", Revisor='" + revisor + '\'';
    }
}
