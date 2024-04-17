package com.meli.bootcamp.EjercicioDeportistas.model;

import lombok.Getter;

@Getter
public class Deporte {
    private final String nombre;
    private final String nivel;


    public Deporte(String nombre, String nivel){
        this.nombre = nombre;
        this.nivel = nivel;
    }

}
