package com.practicaSpring.dtosYResponseEntities.persona.dtos;

import java.io.Serializable;

public class PersonaInDTO implements Serializable {
    private String nombre;
    private String apellido;
    private int edad;
    private String nombreDeporte;
    private String nivelDeporte;

    public PersonaInDTO(String nombre, String apellido, int edad, String nombreDeporte, String nivelDeporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.nombreDeporte = nombreDeporte;
        this.nivelDeporte = nivelDeporte;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombreDeporte() {
        return nombreDeporte;
    }

    public String getNivelDeporte() {
        return nivelDeporte;
    }
}
