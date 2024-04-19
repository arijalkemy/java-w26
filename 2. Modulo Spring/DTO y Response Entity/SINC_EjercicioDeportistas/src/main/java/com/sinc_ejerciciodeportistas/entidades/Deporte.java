package com.sinc_ejerciciodeportistas.entidades;

import lombok.Data;

@Data
public class Deporte {
    private String nombre;
    private String nivel;

    public Deporte(String nombre, String nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }
}
