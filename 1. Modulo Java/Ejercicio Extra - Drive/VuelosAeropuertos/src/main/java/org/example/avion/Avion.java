package org.example.avion;

import java.util.UUID;

public class Avion {
    private int capacidad;
    private UUID matricula;
    private String marca;

    public Avion(int capacidad, String marca) {
        this.capacidad = capacidad;
        this.matricula = UUID.randomUUID();
        this.marca = marca;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public UUID getMatricula() {
        return matricula;
    }

    public void setMatricula(UUID matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
