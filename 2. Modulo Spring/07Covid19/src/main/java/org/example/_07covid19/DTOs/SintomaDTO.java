package org.example._07covid19.DTOs;

import lombok.Getter;

@Getter
public class SintomaDTO {
    private String codigo;
    private String nombre;
    private int nivelDeGravedad;

    public SintomaDTO(String codigo, String nombre, int nivelDeGravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivelDeGravedad = nivelDeGravedad;
    }

    public SintomaDTO() {}

}
