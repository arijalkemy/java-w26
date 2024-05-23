package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@Entity
@Table(name="personas")
@IdClass(value=PersonaKey.class)
public class Persona {

    @Id
    private Integer dni;

    @Id
    private Integer numTramite;

    private String nombre;

    

    public Persona() {
    }

    public Persona(Integer dni, Integer numTramite, String nombre) {
        this.dni = dni;
        this.numTramite = numTramite;
        this.nombre = nombre;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Integer getNumTramite() {
        return numTramite;
    }

    public void setNumTramite(Integer numTramite) {
        this.numTramite = numTramite;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
