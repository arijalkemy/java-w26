package org.example._07covid19;

public class Sintoma {

    private String codigo;
    private String nombre;
    private int nivelDeGravedad;

    public Sintoma(String codigo, String nombre, int nivelDeGravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivelDeGravedad = nivelDeGravedad;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivelDeGravedad() {
        return nivelDeGravedad;
    }
}
