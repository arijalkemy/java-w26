package com.mercadolibre.Covid19API.DTO;

import com.mercadolibre.Covid19API.model.Sintoma;

import java.util.List;

public class PersonaDTO {
    private String nombreCompleto;
    private int edad;
    private List<Sintoma> sintomasAsociados;

    public PersonaDTO(String nombreCompleto, int edad, List<Sintoma> sintomasAsociados) {
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.sintomasAsociados = sintomasAsociados;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Sintoma> getSintomasAsociados() {
        return sintomasAsociados;
    }

    public void setSintomasAsociados(List<Sintoma> sintomasAsociados) {
        this.sintomasAsociados = sintomasAsociados;
    }
}
