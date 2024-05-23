package com.example.demo.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Objects;
import java.util.Random;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

@Embeddable
public class CompraKey implements Serializable{
    
    private LocalDateTime fechaCompra;

    @OneToOne
    private Persona persona;

    public CompraKey(LocalDateTime fechaCompra, Persona persona) {
        this.fechaCompra = fechaCompra;
        this.persona = persona;
    }

    public CompraKey() {
    }

    public static CompraKey of(LocalDateTime fechaCompra, Persona persona)
    {
        return new CompraKey(fechaCompra, persona);
    }

    public static CompraKey of(Persona persona)
    {

        Long timeCreation = new Random().nextInt(10) + 1L;
        return new CompraKey(LocalDateTime.now().plus(timeCreation, ChronoUnit.SECONDS),persona);
    }
    public LocalDateTime getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDateTime fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fechaCompra, persona);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) return false;
        if (this == obj) return true;

        CompraKey keyToCompare = (CompraKey) obj;

        return this.fechaCompra.equals(keyToCompare.fechaCompra) && this.persona.equals(keyToCompare.getPersona());
    }

    @Override
    public String toString() {
        return "CompraKey [fechaCompra=" + fechaCompra + ", persona=" + persona + "]";
    }

    
    
}
