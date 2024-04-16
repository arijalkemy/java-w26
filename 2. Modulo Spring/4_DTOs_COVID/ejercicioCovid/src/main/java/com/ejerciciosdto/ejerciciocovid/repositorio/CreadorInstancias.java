package com.ejerciciosdto.ejerciciocovid.repositorio;

import com.ejerciciosdto.ejerciciocovid.entidades.Sintoma;
import com.ejerciciosdto.ejerciciocovid.entidades.Persona;

import java.util.ArrayList;
import java.util.List;

public class CreadorInstancias {
    private List<Sintoma> sintomas;
    private List<Persona> personas;
    public CreadorInstancias() {
        sintomas = new ArrayList<>();
        personas = new ArrayList<>();
        sintomas.add(new Sintoma(101,"Fiebre",38));
        sintomas.add(new Sintoma(201,"No olfato",3));
        personas.add(new Persona(10,"pepito","perez",67));
        personas.add(new Persona(11,"Juan","Gonzalez",62));
        personas.add(new Persona(12,"Alex","Gonzalez",20));
    }

    public List<Sintoma> getSintomas() {
        return sintomas;
    }

    public void setSintomas(List<Sintoma> sintomas) {
        this.sintomas = sintomas;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
}
