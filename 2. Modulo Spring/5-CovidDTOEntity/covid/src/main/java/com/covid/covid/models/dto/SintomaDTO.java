package com.covid.covid.models.dto;

public class SintomaDTO {
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
