package com.w26.deportista.deportistas.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Getter @Setter
@AllArgsConstructor
public class Persona {
    private String nombre, apellido;
    private int edad;

}
