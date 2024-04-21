package org.example;


import java.util.*;

public class Pasajero {

    private String nombre;
    private List<Vuelo> vuelos = new ArrayList<Vuelo>();

    public Pasajero(String nombre) {
        this.nombre = nombre;
    }

    public void agregarVuelo(Vuelo vuelo) {
        if(!vuelos.contains(vuelo)) {
            vuelos.add(vuelo);
            System.out.println("Vuelo agregado: " + vuelo);
            return;
        }
        System.out.println("El vuelo ya existe");
        return;
    }

    public int cantidadDeVuelos(){
        return vuelos.size();
    }
}
