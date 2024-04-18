package org.example.ejerciciodeportista.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Persona {
    private String nombre;
    private String apellidos;
    private int edad;
}
