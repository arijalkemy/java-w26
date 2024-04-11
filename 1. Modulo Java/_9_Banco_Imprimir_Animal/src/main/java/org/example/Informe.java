package org.example;

public class Informe implements IImprimible{
    private int cantidadDePaginas;
    private String texto;
    private String autor;
    private String revisor;

    public Informe(int cantidadDePaginas, String autor, String revisor, String texto){
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.revisor = revisor;
        this.texto = texto;
    }

    public void imprimir(){
        System.out.println("Nombre de autor: " + this.autor + ". Nombre de revisor: " + this.revisor + ". Texto: " + this.texto + ". Cantidad de paginas: " + this.cantidadDePaginas);
    }

}
