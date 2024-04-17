package org.example.covid.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaEnRiesgoDTO {
    private String nombre;
    private String apellido;
    private String sintoma;
}
