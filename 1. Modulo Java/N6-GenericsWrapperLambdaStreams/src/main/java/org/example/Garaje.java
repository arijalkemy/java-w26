package org.example;

import java.util.ArrayList;
import java.util.List;

public class Garaje {
    private List<Vehiculo> vehiculos;

    public Garaje() {
        this.vehiculos = new ArrayList<>();
    }

    public void addVehiculo(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
    }
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
