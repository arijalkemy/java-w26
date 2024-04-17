package org.example.covid.dto;

public class PersonaNombresDTO {
    private String nombre;
    private String apellido;

    public PersonaNombresDTO(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}
