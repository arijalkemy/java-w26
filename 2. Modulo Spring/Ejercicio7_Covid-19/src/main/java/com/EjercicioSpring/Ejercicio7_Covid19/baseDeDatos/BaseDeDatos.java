package com.EjercicioSpring.Ejercicio7_Covid19.baseDeDatos;

import com.EjercicioSpring.Ejercicio7_Covid19.entity.Persona;
import com.EjercicioSpring.Ejercicio7_Covid19.entity.Sintoma;

import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos {

    private static BaseDeDatos baseDeDatos;
    private List<Persona> personas;
    private List<Sintoma> sintomas;

    public void agregarPersona(Persona persona) {
        personas.add(persona);
    }

    public void agregarSintomas(Sintoma sintoma) {
        sintomas.add(sintoma);
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public List<Sintoma> getSintomas() {
        return sintomas;
    }

    public void setSintomas(List<Sintoma> sintomas) {
        this.sintomas = sintomas;
    }

    private BaseDeDatos() {
        personas = new ArrayList<>();
        sintomas = new ArrayList<>();
    }

    public static BaseDeDatos getBaseDeDatos() {
        if (baseDeDatos == null) {
            baseDeDatos = new BaseDeDatos();
        }
        return baseDeDatos;
    }
}
