package org.example.documentos;

import org.example.interfaces.ImprimibleImpl;

public class Informe implements ImprimibleImpl {

    private String texto;
    private int numPaginas;
    private String autor;
    private String revisor;

    public Informe(String texto, int numPaginas, String autor, String revisor) {
        this.texto = texto;
        this.numPaginas = numPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {
        System.out.println("Informe:");
        System.out.println("Autor: " + autor);
        System.out.println("Revisor: " + revisor);
        System.out.println("Número de páginas: " + numPaginas);
        System.out.println("Texto: " + texto);
    }
}
