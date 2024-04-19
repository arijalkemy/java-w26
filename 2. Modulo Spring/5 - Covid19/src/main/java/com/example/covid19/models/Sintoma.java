package com.example.covid19.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Sintoma {
    private int codigo;
    private String nombre;
    private String nivel_de_gravedad;
}
