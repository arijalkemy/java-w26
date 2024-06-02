package com.mercadolibre.deportes_n.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
public class Persona {
    @Getter
    private String nombre;
    @Getter
    private String apellido;
    private int edad;

}
