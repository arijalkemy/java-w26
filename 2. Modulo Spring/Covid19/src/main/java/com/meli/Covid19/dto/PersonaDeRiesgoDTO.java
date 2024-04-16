package com.meli.Covid19.dto;

import lombok.Data;

@Data
public class PersonaDeRiesgoDTO {
    private String nombre;
    private String apellido;

    public PersonaDeRiesgoDTO(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
}
