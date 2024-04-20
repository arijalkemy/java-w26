package com.meli.ejerciciopracticocovid19.DTO;

import com.meli.ejerciciopracticocovid19.Repository.Sintoma;

import java.util.List;

public class PersonaDTO {
    String nombre;
    String apellido;
    List<SintomaDTO> sintomas;
    int edad;
    String nivelDeGravedad;


    public PersonaDTO(String nombre, String apellido, List<SintomaDTO> sintomas, int edad, String nivelDeGravedad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sintomas = sintomas;
        this.edad = edad;
        this.nivelDeGravedad = nivelDeGravedad;
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

    public List<SintomaDTO> getSintomas() {
        return sintomas;
    }

    public void setSintomas(List<SintomaDTO> sintomas) {
        this.sintomas = sintomas;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNivelDeGravedad() {
        return nivelDeGravedad;
    }

    public void setNivelDeGravedad(String nivelDeGravedad) {
        this.nivelDeGravedad = nivelDeGravedad;
    }
}
