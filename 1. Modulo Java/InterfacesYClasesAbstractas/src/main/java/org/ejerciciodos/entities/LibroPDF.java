package org.ejerciciodos.entities;

import org.ejerciciodos.interfaces.IDocumento;

import java.util.List;

public class LibroPDF implements IDocumento {

    private String titulo;
    private int paginas;
    private String autor;
    private String genero;

    public LibroPDF(String titulo, int paginas, String autor, String genero) {
        this.titulo = titulo;
        this.paginas = paginas;
        this.autor = autor;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println("Libro PDF \nTitulo:" + titulo + "\nAutor:" + autor + "\nGenero:" + genero + "\nPaginas:" + paginas);
    }
}
