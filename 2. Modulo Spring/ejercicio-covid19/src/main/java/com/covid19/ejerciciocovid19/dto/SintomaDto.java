package com.covid19.ejerciciocovid19.dto;

public class SintomaDto {

    private String nombre;
    private int nivelGravedad;

    public SintomaDto(String nombre, int nivelGravedad) {
        this.nombre = nombre;
        this.nivelGravedad = nivelGravedad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivelGravedad() {
        return nivelGravedad;
    }

    public void setNivelGravedad(int nivelGravedad) {
        this.nivelGravedad = nivelGravedad;
    }


}
