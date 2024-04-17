package org.ggomezr.covid19.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PersonaRiesgoDTO {
    private String nombre;
    private String apellido;
    private int edad;

}
