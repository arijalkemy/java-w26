package org.entities;

import java.util.List;
import java.util.UUID;

public class Garaje {
    private UUID id;
    private List<Vehiculo> vehiculos;

    public Garaje(List<Vehiculo> vehiculos) {
        this.id = UUID.randomUUID();
        this.vehiculos = vehiculos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
