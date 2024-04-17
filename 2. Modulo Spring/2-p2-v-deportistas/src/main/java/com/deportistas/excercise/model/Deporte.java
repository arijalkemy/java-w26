package com.deportistas.excercise.model;


import lombok.Getter;

@Getter
public class Deporte {

    private String nombre;

    private Integer nivel;

    public Deporte(String nombre, Integer nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

}
