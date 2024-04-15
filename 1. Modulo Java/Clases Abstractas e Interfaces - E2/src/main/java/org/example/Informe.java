package org.example;

public class Informe implements IImprimible {
    private String texto;
    private int nPaginas;
    private String autor;
    private String revisor;

    public Informe(String texto, int nPaginas, String autor, String revisor) {
        this.texto = texto;
        this.nPaginas = nPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return "Informe{" +
                "texto='" + texto + '\'' +
                ", nPaginas=" + nPaginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }

    @Override
    public void print() {
        System.out.println(this.toString());
    }
}
