package org.example;

import java.util.ArrayList;
import java.util.List;

public class Garaje {

    public String id;
    public List<Vehiculo> vehiculos = new ArrayList<>();

    public Garaje(String id, List<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public ManejadorVehiculos getManejadorVehiculos() {
        return new ManejadorVehiculos(this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
