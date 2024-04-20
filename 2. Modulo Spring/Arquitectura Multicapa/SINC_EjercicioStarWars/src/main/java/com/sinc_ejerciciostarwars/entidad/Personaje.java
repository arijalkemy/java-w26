package com.sinc_ejerciciostarwars.entidad;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Personaje {
    private String nombre;
    private int altura;
    private double peso;
    private String colorPelo;
    private String colorPiel;
    private String colorOjos;
    private String anioNacimiento;
    private String genero;
    private String hogar;
    private String especie;
}
