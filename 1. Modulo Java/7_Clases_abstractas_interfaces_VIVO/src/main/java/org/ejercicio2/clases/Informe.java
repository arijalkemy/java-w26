package org.ejercicio2.clases;

import org.ejercicio2.interfaces.IDocumento;

public class Informe implements IDocumento {

    private String texto;
    private int cantidadPaginas;
    private Persona autor;
    private Persona revisor;


    public Informe(String texto, int cantidadPaginas, Persona autor, Persona revisor) {
        this.texto = texto;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }


    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public Persona getAutor() {
        return autor;
    }

    public void setAutor(Persona autor) {
        this.autor = autor;
    }

    public Persona getRevisor() {
        return revisor;
    }

    public void setRevisor(Persona revisor) {
        this.revisor = revisor;
    }


    @Override
    public void imprimir() {
        System.out.println("Autor: " + this.autor);
        System.out.println("Revisor: " + this.revisor);
        System.out.println("Cantidad de páginas: " + this.cantidadPaginas);
        System.out.println("Texto:");
        System.out.println(texto);
    }
}
