package com.EjercicioSpring.Ejercicio6_Deportistas.baseDeDatos;

import com.EjercicioSpring.Ejercicio6_Deportistas.dto.DeportistaDTO;
import com.EjercicioSpring.Ejercicio6_Deportistas.entities.Deporte;
import com.EjercicioSpring.Ejercicio6_Deportistas.entities.Persona;

import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos {

    private static BaseDeDatos baseDeDatos;
    private List<Persona> personas;
    private List<Deporte> deportes;

    private BaseDeDatos() {
        personas = new ArrayList<>();
        deportes = new ArrayList<>();
    }

    public static BaseDeDatos getBaseDeDatos() {
        if (baseDeDatos == null) {
            baseDeDatos = new BaseDeDatos();
        }
        return baseDeDatos;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public List<Deporte> getDeportes() {
        return deportes;
    }


    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public void setDeportes(List<Deporte> deportes) {
        this.deportes = deportes;
    }


}
