package com.dtoEntityDeportistasParte2.parte2.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepostistaDTO {
    private String nombre;
    private String apellido;
    private String deporte;

    public DepostistaDTO(String nombre) {
    }
}
