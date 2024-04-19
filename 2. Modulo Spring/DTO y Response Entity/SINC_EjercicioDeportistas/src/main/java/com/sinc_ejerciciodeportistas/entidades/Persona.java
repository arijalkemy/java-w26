package com.sinc_ejerciciodeportistas.entidades;

import lombok.Data;

@Data
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private Deporte deporte;

    public Persona(String nombre, String apellido, int edad, Deporte deporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.deporte = deporte;
    }

}
