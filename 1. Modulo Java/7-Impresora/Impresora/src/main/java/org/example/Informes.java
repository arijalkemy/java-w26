package org.example;

public class Informes implements IImprimir{

    private String texto;
    private Integer cantPaginas;
    private String autor;
    private String revisor;

    public Informes(String texto, Integer cantPaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantPaginas = cantPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return "El informe dice "+texto+" y es del autor "+autor;
    }
}
