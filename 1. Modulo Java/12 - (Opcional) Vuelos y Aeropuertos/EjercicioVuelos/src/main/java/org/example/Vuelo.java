package org.example;

import java.util.List;

public class Vuelo {
    private List<Tramo> tramos;
    private List<Pasajero> pasajeros;

    public Vuelo(List<Tramo> tramos, List<Pasajero> pasajeros) {
        this.tramos = tramos;
        this.pasajeros = pasajeros;
    }

    public int capacidad(){
        return pasajeros.size();
    }

    public double duracion(){
        return tramos.stream().mapToDouble(x -> x.getDuracion()).sum();
    }

    public List<Tramo> getTramos() {
        return tramos;
    }
}
