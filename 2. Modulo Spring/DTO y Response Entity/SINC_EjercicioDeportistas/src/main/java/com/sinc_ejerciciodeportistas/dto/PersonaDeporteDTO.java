package com.sinc_ejerciciodeportistas.dto;

import com.sinc_ejerciciodeportistas.entidades.Deporte;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDeporteDTO {
    private String nombre;
    private String apellido;
    private String nombreDeporte;
}
