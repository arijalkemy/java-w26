package com.practicaSpring.dtosYResponseEntities.persona.dtos;

import java.io.Serializable;

public class PersonaOutDTO implements Serializable {
    private String nombre;
    private String apellido;
    private String nombreDeporte;

    public PersonaOutDTO(String nombre, String apellido, String nombreDeporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreDeporte = nombreDeporte;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombreDeporte() {
        return nombreDeporte;
    }
}
