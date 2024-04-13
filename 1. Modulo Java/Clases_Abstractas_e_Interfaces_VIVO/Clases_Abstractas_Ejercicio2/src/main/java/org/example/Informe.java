package org.example;

public class Informe implements Imprimible {
    private String autor;
    private String texto;
    private String revisor;
    private int longitud;
    private int paginas;

    public Informe(String autor, String texto, String revisor, int longitud, int paginas) {
        this.autor = autor;
        this.texto = texto;
        this.revisor = revisor;
        this.longitud = longitud;
        this.paginas = paginas;
    }

    @Override
    public void imprimir() {
        System.out.println("Autor: " + autor);
        System.out.println("Texto: " + texto);
        System.out.println("Revisor: " + revisor);
        System.out.println("Longitud: " + longitud);
        System.out.println("Paginas: " + paginas);
    }
}
