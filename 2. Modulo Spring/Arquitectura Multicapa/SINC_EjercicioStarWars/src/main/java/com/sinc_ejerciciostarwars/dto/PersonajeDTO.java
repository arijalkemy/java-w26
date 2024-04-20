package com.sinc_ejerciciostarwars.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonajeDTO {
    private String nombre;
    private int altura;
    private double peso;
    private String genero;
    private String hogar;
    private String especie;
}
