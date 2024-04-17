package org.ggomezr.covid19.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
}
