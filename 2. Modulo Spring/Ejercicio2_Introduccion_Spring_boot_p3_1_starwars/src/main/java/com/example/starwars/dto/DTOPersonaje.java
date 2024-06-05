package com.example.starwars.dto;

import java.io.Serializable;

public class DTOPersonaje implements Serializable {
    private String nombre;
    private String altura;
    private String masa;
    private String genero;
    private String planeta_natal;
    private String especie;

    public DTOPersonaje(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getMasa() {
        return masa;
    }

    public void setMasa(String masa) {
        this.masa = masa;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPlaneta_natal() {
        return planeta_natal;
    }

    public void setPlaneta_natal(String planeta_natal) {
        this.planeta_natal = planeta_natal;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
}
