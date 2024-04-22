package com.covid.covid.models.dto;

import java.io.Serializable;

public class SintomaDTO implements Serializable {
    private String nombre;
    private String gravedad;

    public SintomaDTO(String nombre, String gravedad) {
        this.nombre = nombre;
        this.gravedad = gravedad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGravedad() {
        return gravedad;
    }
}
