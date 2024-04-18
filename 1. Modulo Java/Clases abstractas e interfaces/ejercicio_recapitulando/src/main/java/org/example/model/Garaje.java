package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Garaje {
    private List<Vehiculo> vehiculos;
    private int id;

    public Garaje() {
        this.vehiculos = new ArrayList<>();
    }

    public Garaje(List<Vehiculo> vehiculos, int id) {
        this.vehiculos = vehiculos;
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
