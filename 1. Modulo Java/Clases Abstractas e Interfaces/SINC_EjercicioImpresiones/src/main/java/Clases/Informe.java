package Clases;

import Interfaces.Imprimible;

public class Informe implements Imprimible {
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
    public String imprimirDocumento() {
        return "Autor: " + autor + "\n" +
                "Revisor: " + revisor + "\n" +
                "Longitud: " + longitud + "\n" +
                "Cantidad de paginas: " + cantidadDePaginas;
    }
}
