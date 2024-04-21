package org.example;

import java.util.List;

public class Garage {
    private int id;
    private List<Vehiculo>listaDeVehiculos;

    public Garage(int id, List<Vehiculo> listaDeVehiculos) {
        this.id = id;
        this.listaDeVehiculos = listaDeVehiculos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void setListaDeVehiculos(List<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }
}
