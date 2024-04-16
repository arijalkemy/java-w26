package com.example.deportistas.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class PersonaDeportista implements Serializable {

    private String nombre;
    private String apellido;
    private String nombreDeporte;
}
