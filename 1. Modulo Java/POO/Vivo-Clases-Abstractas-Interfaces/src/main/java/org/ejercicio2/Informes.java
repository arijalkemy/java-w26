package org.ejercicio2;

public class Informes {
    private String texto;
    private int cantidadPaginas;
    private String autor;

    public Informes(String autor, int cantidadPaginas, String texto) {
        this.autor = autor;
        this.cantidadPaginas = cantidadPaginas;
        this.texto = texto;
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

    @Override
    public String toString() {
        return "Informes{" +
                "texto='" + texto + '\'' +
                ", cantidadPaginas=" + cantidadPaginas +
                ", autor='" + autor + '\'' +
                '}';
    }
}
