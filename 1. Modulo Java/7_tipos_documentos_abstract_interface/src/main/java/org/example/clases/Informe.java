package org.example.clases;

public class Informe {
    private String text;
    private String autor;
    private String revisor;
    private int cantidadPaginas;

    public Informe(String text, String autor, String revisor, int cantidadPaginas) {
        this.text = text;
        this.autor = autor;
        this.revisor = revisor;
        this.cantidadPaginas = cantidadPaginas;
    }

    @Override
    public String toString() {
        return "Informe{" +
                "text='" + text + '\'' +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                ", cantidadPaginas=" + cantidadPaginas +
                '}';
    }
}
