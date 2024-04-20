package com.asinc_ejerciciocovid19.entidad;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private List<Sintoma> sintomas;
}
