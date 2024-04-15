package org.example.Clases;

import java.util.ArrayList;

public class Garaje {
    private int id_garaje;
    private ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();

    public Garaje(int idGaraje, ArrayList<Vehiculo> listaVehiculos) {
        this.id_garaje = idGaraje;
        this.listaVehiculos = listaVehiculos;
    }

    public int getIdGaraje() {
        return id_garaje;
    }

    public void setIdGaraje(int id_garaje) {
        this.id_garaje = id_garaje;
    }

    public ArrayList<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(ArrayList<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }
}
