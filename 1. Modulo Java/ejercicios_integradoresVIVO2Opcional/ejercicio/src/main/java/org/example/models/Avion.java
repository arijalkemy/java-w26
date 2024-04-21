package org.example.models;

public class Avion {
    private int capacidad;
    private String modelo;

    public Avion(int capacidad, String modelo) {
        this.capacidad = capacidad;
        this.modelo = modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
