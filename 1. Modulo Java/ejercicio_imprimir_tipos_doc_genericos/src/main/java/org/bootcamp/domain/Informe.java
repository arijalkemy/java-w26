package org.bootcamp.domain;

public class Informe {

    private String texto;
    private int longitud;
    private String autor;
    private String revisor;

    public Informe() {
    }

    public Informe(String texto, int longitud, String autor, String revisor) {
        this.texto = texto;
        this.longitud = longitud;
        this.autor = autor;
        this.revisor = revisor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
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
        final StringBuffer sb = new StringBuffer("\n\n--- Informe ---");
        sb.append("\ntexto: ").append(texto);
        sb.append("\nlongitud: ").append(longitud);
        sb.append("\nautor: ").append(autor);
        sb.append("\nrevisor: ").append(revisor);
        return sb.toString();
    }
}
