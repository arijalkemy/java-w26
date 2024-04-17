package org.example.model;

public class Informe extends Documento{

    private String texto;
    private String revisor;

    public Informe(String autor, int cantidadPaginas, String texto, String revisor) {
        super(autor, cantidadPaginas);
        this.texto = texto;
        this.revisor = revisor;
    }

    @Override
    public String obtenerContenido() {
        return "Texto: " + this.texto + "\nRevisor: " + this.revisor;
    }
}
