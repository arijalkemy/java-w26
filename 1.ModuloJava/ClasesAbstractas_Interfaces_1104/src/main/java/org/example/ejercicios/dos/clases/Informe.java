package org.example.ejercicios.dos.clases;

import org.example.ejercicios.dos.Interfaces.Imprimible;

public class Informe implements Imprimible{
    private String texto;
    private int cantidadHojas;

    private String titulo;
    private String autor;
    private String revisor;

    public Informe(String texto, int cantidadHojas, String titulo, String autor, String revisor) {
        this.texto = texto;
        this.cantidadHojas = cantidadHojas;
        this.titulo = titulo;
        this.autor = autor;
        this.revisor = revisor;
    }

    public Informe() {
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getCantidadHojas() {
        return cantidadHojas;
    }

    public void setCantidadHojas(int cantidadHojas) {
        this.cantidadHojas = cantidadHojas;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public void imprimir() {
        System.out.println("______"+ this.titulo+"______");
        System.out.println("Informe de "+ this.autor);
        System.out.println("revisor "+ this.revisor);
        System.out.println("Contiene "+ this.cantidadHojas + " hojas");
        System.out.println(this.texto);

    }
}
