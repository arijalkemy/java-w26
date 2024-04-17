package org.example.covid.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class SintomaDTO implements Serializable {

    private String codigo;
    private String nombre;
    private int nivelDeGravedad;

    public SintomaDTO(String codigo, String nombre, int nivelDeGravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivelDeGravedad = nivelDeGravedad;
    }

}
