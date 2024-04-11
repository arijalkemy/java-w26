package org.example.imprimible;

public class Informe implements Imprimible{
    private Integer longitud;
    private Integer cantPaginas;
    private String autor;
    private String revisor;

    public Informe(Integer longitud, Integer cantPaginas, String autor, String revisor) {
        this.longitud = longitud;
        this.cantPaginas = cantPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {
        System.out.println("Informe \n" +
                "Longitud: " + longitud +
                ", Cantidad de paginas: " + cantPaginas +
                ", Autor: " + autor+
                ", Revisor: " + revisor );
    }

}
