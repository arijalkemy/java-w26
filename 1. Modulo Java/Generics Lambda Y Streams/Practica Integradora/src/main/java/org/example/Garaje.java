package org.example;

import java.util.List;

public class Garaje {
    private int id;
    private List<Vehiculo> listaVehiculo;

    public Garaje(int id, List<Vehiculo> listaVehiculo) {
        this.id = id;
        this.listaVehiculo = listaVehiculo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getListaVehiculo() {
        return listaVehiculo;
    }

    public void setListaVehiculo(List<Vehiculo> listaVehiculo) {
        this.listaVehiculo = listaVehiculo;
    }

    public void mostrarVehiculos() {
        System.out.println("Vehículos en el garaje:");
        for (Vehiculo vehiculo : listaVehiculo) {
            System.out.println("Marca: " + vehiculo.getMarca() + ", Modelo: " + vehiculo.getModelo() + ", Precio: " + vehiculo.getCosto());
        }
    }
}
