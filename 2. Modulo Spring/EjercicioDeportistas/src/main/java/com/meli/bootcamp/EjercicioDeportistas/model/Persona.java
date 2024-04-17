package com.meli.bootcamp.EjercicioDeportistas.model;

import lombok.Getter;

@Getter
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private Deporte deporte;



    public Persona (String nombre, String apellido, int edad, Deporte deporte){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.deporte = deporte;
    }
    // Getters y setters

}
