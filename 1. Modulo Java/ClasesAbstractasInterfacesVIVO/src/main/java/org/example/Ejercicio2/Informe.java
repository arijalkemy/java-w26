package org.example.Ejercicio2;

public class Informe {
    String texto;
    int numeroDePaginas;
    String autor;
    String revisor;

    public Informe(String texto, int numeroDePaginas, String autor, String revisor) {
        this.texto = texto;
        this.numeroDePaginas = numeroDePaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
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

    @Override
    public String toString() {
        return "Informes{" +
                "texto='" + texto + '\'' +
                ", numeroDePaginas=" + numeroDePaginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }
}
