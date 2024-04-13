package org.example;

public class Libros implements Imprimible {
    private String autor;
    private String titulo;
    private String genero;
    private int paginas;

    public Libros(String autor, String titulo, String genero, int paginas) {
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
        this.paginas = paginas;
    }

    @Override
    public void imprimir() {
        System.out.println("Autor: " + autor);
        System.out.println("Titulo: " + titulo);
        System.out.println("Genero: " + genero);
        System.out.println("Numero de Paginas: " + paginas);
    }
}
