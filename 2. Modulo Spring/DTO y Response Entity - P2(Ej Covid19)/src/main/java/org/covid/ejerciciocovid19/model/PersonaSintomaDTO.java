package org.covid.ejerciciocovid19.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaSintomaDTO {
    private String nombre;
    private String apellido;

    public PersonaSintomaDTO(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
}
