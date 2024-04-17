package com.covi.covid_19.DTO;

import com.covi.covid_19.Classes.Sintoma;

import java.util.List;

public class PersonaSistemaDTO {
    private String nombre;
    private String apellido;
    private List<Sintoma> sintomas;

    public PersonaSistemaDTO(String nombre, String apellido, List<Sintoma> sintomas) {
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
