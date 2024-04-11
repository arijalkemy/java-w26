package org.example;

public class Informe implements IImprimir{
    private int longitud;
    private int cantidadDePaginas;
    private String autor;
    private String revisor;

    public Informe(int longitud, int cantidadDePaginas, String autor, String revisor) {
        this.longitud = longitud;
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo informe...");
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Informe{" +
                "longitud=" + longitud +
                ", cantidadDePaginas=" + cantidadDePaginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }
}
