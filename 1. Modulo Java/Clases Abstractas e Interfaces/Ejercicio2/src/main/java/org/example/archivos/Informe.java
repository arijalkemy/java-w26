package org.example.archivos;

public class Informe implements IArchivo{
    private String texto;
    private Integer cantidadDePaginas;
    private String nombreDelAutor;
    private String revisor;

    public Informe(String texto, Integer cantidadDePaginas, String nombreDelAutor, String revisor) {
        this.texto = texto;
        this.cantidadDePaginas = cantidadDePaginas;
        this.nombreDelAutor = nombreDelAutor;
        this.revisor = revisor;
    }

    @Override
    public String getContenido() {
        return "Texto: " + this.texto + "Cantidad de paginas: " + this.cantidadDePaginas + "Autor: " + this.nombreDelAutor + "Revisor: " + this.revisor;
    }
}
