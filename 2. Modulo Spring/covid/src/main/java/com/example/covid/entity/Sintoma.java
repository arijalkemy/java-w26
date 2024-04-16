package com.example.covid.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Sintoma {

    private int id;
    private String codigo;
    private String nombre;
    private int nivel_de_gravedad;
}
