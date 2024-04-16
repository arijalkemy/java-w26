package com.example.covid19.dto;

import com.example.covid19.clases.Persona;
import com.example.covid19.clases.Sintoma;

import java.util.List;
import java.util.stream.Collectors;

public class PersonaDto {
    private String nombrePersona;
    private String apellidoPersona;
    private int edadPersona;
    private List<String> sintomas;

    public PersonaDto(Persona persona, List<Sintoma> sintomas) {
        this.nombrePersona = persona.getNombre();
        this.apellidoPersona = persona.getApellido();
        this.edadPersona = persona.getEdad();
        this.sintomas = sintomas.stream().map(Sintoma::getNombre).collect(Collectors.toList());
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellidoPersona() {
        return apellidoPersona;
    }

    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }

    public int getEdadPersona() {
        return edadPersona;
    }

    public void setEdadPersona(int edadPersona) {
        this.edadPersona = edadPersona;
    }

    public List<String> getSintomas() {
        return sintomas;
    }

    public void setSintomas(List<String> sintomas) {
        this.sintomas = sintomas;
    }
}
