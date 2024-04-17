package org.covid.ejerciciocovid19.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sintoma {
    private String codigo;
    private String nombre;
    private int nivelDeGravedad;

    public Sintoma(String codigo, String nombre, int nivelDeGravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivelDeGravedad = nivelDeGravedad;
    }
}
