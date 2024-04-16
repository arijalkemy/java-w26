package com.ejerciciosdto.ejerciciocovid.dto;

import com.ejerciciosdto.ejerciciocovid.entidades.Sintoma;

import java.io.Serializable;
import java.util.List;

public class PersonaDTO implements Serializable {
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private List<Sintoma> sintomas;

    public PersonaDTO(Integer id, String nombre, String apellido, Integer edad, List<Sintoma> sintomas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sintomas = sintomas;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public List<Sintoma> getSintomas() {
        return sintomas;
    }
}
