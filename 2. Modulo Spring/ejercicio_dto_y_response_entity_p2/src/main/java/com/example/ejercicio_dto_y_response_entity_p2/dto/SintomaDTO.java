package com.example.ejercicio_dto_y_response_entity_p2.dto;

public class SintomaDTO {
    private String nombre;
    private String nivelDeGravedad;

    public SintomaDTO(String nombre, String nivelDeGravedad) {
        this.nombre = nombre;
        this.nivelDeGravedad = nivelDeGravedad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivelDeGravedad() {
        return nivelDeGravedad;
    }

    public void setNivelDeGravedad(String nivelDeGravedad) {
        this.nivelDeGravedad = nivelDeGravedad;
    }
}
