package com.meli.bootcamp.EjercicioDeportistas.dto;

public class DeportistaDTO {
    private String nombre;
    private String apellido;
    private String deporte;

    // Constructor y getters
    public DeportistaDTO(String nombre1, String apellido1, String deporte1){
        this.nombre = nombre1;
        this.apellido = apellido1;
        this.deporte = deporte1;
    }
}
