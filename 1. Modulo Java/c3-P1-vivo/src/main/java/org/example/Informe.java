package org.example;

public class Informe {
    private char[] texto;

    private int cantidadDepaginas;
    private String autor;
    private String revisor;

    public String toString() {
        return "Informe: " +
                "cantidadDepaginas=" + cantidadDepaginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '.';
    }

    public Informe(char[] texto, int cantidadDepaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantidadDepaginas = cantidadDepaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    public char[] getTexto() {
        return texto;
    }

    public Informe setTexto(char[] texto) {
        this.texto = texto;
        return this;
    }

    public int getCantidadDepaginas() {
        return cantidadDepaginas;
    }

    public Informe setCantidadDepaginas(int cantidadDepaginas) {
        this.cantidadDepaginas = cantidadDepaginas;
        return this;
    }

    public String getAutor() {
        return autor;
    }

    public Informe setAutor(String autor) {
        this.autor = autor;
        return this;
    }

    public String getRevisor() {
        return revisor;
    }

    public Informe setRevisor(String revisor) {
        this.revisor = revisor;
        return this;
    }
}
