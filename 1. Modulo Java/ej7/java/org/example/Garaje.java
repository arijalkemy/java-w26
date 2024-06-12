package org.example;

import java.util.List;

public class Garaje {
    private int id;
    private List<Vehiculo> vehiculos;

    public int getId() {
        return id;
    }

    public Garaje setId(int id) {
        this.id = id;
        return this;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public Garaje setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
        return this;
    }
}
