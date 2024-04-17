package org.example.model;

public class Curriculum extends Documento{

    private String habilidades;

    public Curriculum(String autor, int cantidadPaginas, String habilidades) {
        super(autor, cantidadPaginas);
        this.habilidades = habilidades;
    }

    @Override
    public String obtenerContenido() {
        return "Persona: " + this.getAutor() + "\nHabilidades: " + this.habilidades;
    }
}
