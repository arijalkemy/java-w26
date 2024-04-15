package org.example.clases;

import org.example.interfaces.Documento;

public class LibroEnPdf implements Documento {
    private int paginas;
    private String nombreAutor;
    private String titulo;
    private String genero;

    public LibroEnPdf(int paginas, String nombreAutor, String titulo, String genero) {
        this.paginas = paginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }


    @Override
    public void Imprimir() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "LibroEnPdf{" +
                "paginas=" + paginas +
                ", nombreAutor='" + nombreAutor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
