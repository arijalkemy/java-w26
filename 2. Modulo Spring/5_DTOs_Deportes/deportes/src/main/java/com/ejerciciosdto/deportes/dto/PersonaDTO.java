package com.ejerciciosdto.deportes.dto;

public class PersonaDTO {
    private String nombre;
    private String apellido;
    private String nombreDeporte;
    public PersonaDTO(String nombre, String apellido, String nombreDeporte) {
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
