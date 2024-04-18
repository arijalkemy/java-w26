package org.example.ejerciciodeportista.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class DeportistaDTO {
    private String nombre;
    private String apellidos;
    private String deporte;
}
