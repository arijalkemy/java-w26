package org.example.documentos;

public class LibroPDF implements Imprimible {
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
        System.out.println("Libro: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Páginas: " + paginas);
        System.out.println("Género: " + genero);
    }
}
