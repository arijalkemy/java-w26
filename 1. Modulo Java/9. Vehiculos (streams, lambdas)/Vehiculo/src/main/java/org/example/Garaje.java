package org.example;

import java.util.List;

public class Garaje {
    private int id;
    private List<Vehiculo> listVehiculos;

    public Garaje(int id, List<Vehiculo> listVehiculos) {
        this.id = id;
        this.listVehiculos = listVehiculos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getListVehiculos() {
        return listVehiculos;
    }

    public void setListVehiculos(List<Vehiculo> listVehiculos) {
        this.listVehiculos = listVehiculos;
    }
}
