package com.asinc_ejerciciocovid19.entidad;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Sintoma {
    private int codigo;
    private String nombre;
    private String nivelDeGravedad;

}
