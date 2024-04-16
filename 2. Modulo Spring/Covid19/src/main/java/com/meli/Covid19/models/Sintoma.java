package com.meli.Covid19.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sintoma {
    private String codigo;
    private String nombre;
    private String nivelDeGravedad;

    public Sintoma(String codigo, String nombre, String nivelDeGravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivelDeGravedad = nivelDeGravedad;
    }
}
