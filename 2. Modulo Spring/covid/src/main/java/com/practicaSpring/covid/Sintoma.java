package com.practicaSpring.covid;

public class Sintoma {
    private Long codigo;
    private String nombre;
    private int nivelDeGravedad;

    public Sintoma(Long codigo, String nombre, int nivelDeGravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivelDeGravedad = nivelDeGravedad;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivelDeGravedad() {
        return nivelDeGravedad;
    }
}
