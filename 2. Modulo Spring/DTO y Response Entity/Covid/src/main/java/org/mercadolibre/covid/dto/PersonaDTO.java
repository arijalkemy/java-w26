package org.mercadolibre.covid.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class PersonaDTO implements Serializable {
    @Setter
    @Getter
    private String nombre;

    @Setter
    @Getter
    private String apellido;

    public PersonaDTO(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

}
