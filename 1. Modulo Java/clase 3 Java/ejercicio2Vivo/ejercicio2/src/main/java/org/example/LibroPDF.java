package org.example;

public class LibroPDF implements Imprimir{
    private int cantidadPaginas;
    private String autor;
    private String titulo;
    private String genero;

    @Override
    public void imprimir() {
        System.out.println("imprimiendo Libro pdf");
    }
}
