package com.w26.deportista.deportistas.dto;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class DTOPersonaDeporte implements Serializable {
    private final String nombre;
    private final String apellido;
    private final String deporte;

    public DTOPersonaDeporte(String nombre, String apellido, String deporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.deporte = deporte;
    }


}
