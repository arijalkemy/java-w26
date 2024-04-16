package com.example.deportistas.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Persona implements Serializable {

    private String nombre;
    private String apellido;
    private int edad;
    private int deporte;
}
