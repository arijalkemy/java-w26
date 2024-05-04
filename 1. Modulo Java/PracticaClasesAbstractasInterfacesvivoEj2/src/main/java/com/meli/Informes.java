package com.meli;

public class Informes implements Imprimible{

    private int  logitudTexto;
    private int cantidadDePaginas;
    private String autor;
    private String revisor;


    public Informes(int logitudTexto, int cantidadDePaginas, String autor, String revisor) {
        this.logitudTexto = logitudTexto;
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    public int getLogitudTexto() {
        return logitudTexto;
    }

    public void setLogitudTexto(int logitudTexto) {
        this.logitudTexto = logitudTexto;
    }

    public int getCantidadDePaginas() {
        return cantidadDePaginas;
    }

    public void setCantidadDePaginas(int cantidadDePaginas) {
        this.cantidadDePaginas = cantidadDePaginas;
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
    public void imprimir() {
        System.out.println("Logitud del texto: " + logitudTexto + " Cantidad de paginas: " + cantidadDePaginas + " Autor: " + autor + " Revisor: " + revisor);
    }
}
