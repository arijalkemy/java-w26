package org.example;

public class Informe implements Imprimir{
    private String texto;
    private int cantidadPaginas;
    private String autor;
    private String revisor;

    @Override
    public void imprimir() {
        System.out.println("imprimiendo informe");
    }
}
