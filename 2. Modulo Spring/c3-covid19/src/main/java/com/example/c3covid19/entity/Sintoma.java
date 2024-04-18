package com.example.c3covid19.entity;

public class Sintoma {
    private int codigo;
    private String nombre;

    public int getCodigo() {
        return codigo;
    }

    public Sintoma setCodigo(int codigo) {
        this.codigo = codigo;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Sintoma setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public int getNivelDeGravedad() {
        return nivelDeGravedad;
    }

    public Sintoma setNivelDeGravedad(int nivelDeGravedad) {
        this.nivelDeGravedad = nivelDeGravedad;
        return this;
    }

    private int nivelDeGravedad;

}
