package org.example.ejercicio2;

public class Informe {
    public String texto;
    public int cantidadDePaginas;
    public String autor;
    public String revisor;

    public Informe(String texto, int cantidadDePaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return "Texto: "+this.texto+
                ",Cantidad de páginas: "+ this.cantidadDePaginas+
                ", Autor: "+this.autor+
                ", Revisor: "+this.revisor;
    }
}
