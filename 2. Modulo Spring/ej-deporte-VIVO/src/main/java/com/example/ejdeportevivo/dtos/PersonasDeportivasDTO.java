package com.example.ejdeportevivo.dtos;

import com.example.ejdeportevivo.modelo.Deporte;

import java.io.Serializable;

public class PersonasDeportivasDTO implements Serializable {
    private String nombre;
    private String apellido;
    private DeporteDTO deporte;

    public PersonasDeportivasDTO(String nombre, String apellido, DeporteDTO deporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.deporte = deporte;
    }

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

    public DeporteDTO getDeporte() {
        return deporte;
    }

    public void setDeporte(DeporteDTO deporte) {
        this.deporte = deporte;
    }
}
