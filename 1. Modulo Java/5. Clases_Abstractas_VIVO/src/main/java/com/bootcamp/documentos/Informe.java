package com.bootcamp.documentos;

public class Informe extends Documento {
    String contenido;
    int paginas;
    String autor;
    String revisor;

    public Informe(String contenido, int paginas, String autor, String revisor) {
        this.contenido = contenido;
        this.paginas = paginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo Informe");
        System.out.println("Contenido: " + contenido);
        System.out.println("Paginas: " + paginas);
        System.out.println("Autor: " + autor);
        System.out.println("Revisor: " + revisor);
    }
}
