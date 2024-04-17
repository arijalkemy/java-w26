package org.ggomezr.covid19.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Sintoma {
    private int codigo;
    private String nombre;
    private int nivelDeGravedad;
    private int idPersona;
}
