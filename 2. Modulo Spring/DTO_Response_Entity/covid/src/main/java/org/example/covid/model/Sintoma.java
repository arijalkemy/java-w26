package org.example.covid.model;

public class Sintoma {
    private int codigo;
    private String nombre;
    private String nivelDeGravedad;

    public Sintoma(int codigo, String nombre, String nivelDeGravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivelDeGravedad = nivelDeGravedad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNivelDeGravedad() {
        return nivelDeGravedad;
    }
}
