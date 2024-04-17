package com.deportistas.excercise.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PersonaDTO {
    private String nombre;
    private String apellido;
    private String nombreDeporte;

    public PersonaDTO(String nombre, String apellido, String nombreDeporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreDeporte = nombreDeporte;
    }
}
