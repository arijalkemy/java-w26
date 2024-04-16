package com.spring.deportistas_dto_ej.Dtos;

import java.io.Serializable;

public class PersonaDto implements Serializable {
    private String nombre;
    private String apellido;
    private String deporte;

    public PersonaDto() {
    }

    public PersonaDto(String nombre, String apellido, String deporte) {
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

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    @Override
    public String toString() {
        return "PersonaDto{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", deporte='" + deporte + '\'' +
                '}';
    }
}
