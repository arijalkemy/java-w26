package com.spring.covid_19.Dtos;

import com.spring.covid_19.Models.Sintoma;

import java.util.ArrayList;
import java.util.List;

public class RiskPersonDto {
    private String nombre;
    private String apellido;

    private List<Sintoma> sintomas = new ArrayList<>();

    public RiskPersonDto(String nombre, String apellido, List<Sintoma> sintomas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sintomas = sintomas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Sintoma> getSintomas() {
        return sintomas;
    }

    public void setSintomas(List<Sintoma> sintomas) {
        this.sintomas = sintomas;
    }
}
