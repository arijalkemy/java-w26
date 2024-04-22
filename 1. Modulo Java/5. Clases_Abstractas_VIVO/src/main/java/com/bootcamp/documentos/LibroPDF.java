package com.bootcamp.documentos;

public class LibroPDF extends Documento {
    private String titulo;
    private String autor;
    private int paginas;
    private String genero;

    public LibroPDF(String titulo, String autor, int paginas, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo LibroPDF");
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Paginas: " + paginas);
        System.out.println("Genero: " + genero);
    }

}
