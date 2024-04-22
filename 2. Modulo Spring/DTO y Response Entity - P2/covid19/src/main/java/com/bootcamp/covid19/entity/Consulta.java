package com.bootcamp.covid19.entity;

import lombok.Data;

import java.util.List;

@Data
public class Consulta {
    private Persona persona;
    private List<Sintoma> sintomas;

    public Consulta(Persona persona, List<Sintoma> sintoma) {
        this.persona = persona;
        this.sintomas = sintoma;
    }
}
