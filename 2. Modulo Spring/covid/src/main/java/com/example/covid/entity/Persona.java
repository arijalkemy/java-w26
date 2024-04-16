package com.example.covid.entity;

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
    private List<Integer> sintomas;
}
