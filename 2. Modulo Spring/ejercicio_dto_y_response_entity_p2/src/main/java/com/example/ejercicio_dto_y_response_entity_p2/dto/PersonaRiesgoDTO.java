package com.example.ejercicio_dto_y_response_entity_p2.dto;

import java.util.List;

public class PersonaRiesgoDTO {
    private String nombre;
    private String apellido;
    private List<SintomaDTO> sintomas;

    public PersonaRiesgoDTO(String nombre, String apellido, List<SintomaDTO> sintomas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sintomas = sintomas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<SintomaDTO> getSintomas() {
        return sintomas;
    }

    public void setSintomas(List<SintomaDTO> sintomas) {
        this.sintomas = sintomas;
    }
}
