package org.example;

public class Informe implements IImprimible {
    private String texto;
    private Integer cantidadDePaginas;
    private String autor;
    private String revisor;

    public Informe(String texto, Integer cantidadDePaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {
        System.out.println("Informe de " + this.autor);
        System.out.println("Revisión por: " + this.revisor);
        System.out.println("Cantidad de páginas: " + this.cantidadDePaginas);
        System.out.println(this.texto);
        System.out.println("\n");
    }
}
