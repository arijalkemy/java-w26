package com.javabootcamp.covid19.dto;

import lombok.Data;

@Data
public class Sintoma {
    int codigo;
    String nombre;
    int nivelGravedad;

    public Sintoma(int codigo, String nombre, int nivelGravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivelGravedad = nivelGravedad;
    }
}
