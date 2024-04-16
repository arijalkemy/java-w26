package com.example._04_deportista.model.DTO;

import java.io.Serializable;

public class PersonaDeportistaDTO implements Serializable {
    private String nombre;
    private String apellido;
    private String nombreDeporte;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreDeporte() {
        return nombreDeporte;
    }

    public void setNombreDeporte(String nombreDeporte) {
        this.nombreDeporte = nombreDeporte;
    }

    public PersonaDeportistaDTO(){}
    public PersonaDeportistaDTO(String nombre, String apellido, String nombreDeporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreDeporte = nombreDeporte;
    }
}
