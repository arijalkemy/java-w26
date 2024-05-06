package com.example._6_persona_practicatestyvalidaciones.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
}
