package org.example;

import java.util.ArrayList;
import java.util.List;

public class Vuelo {
    private int capacidad;
    private List<Pasajero> listadoDePasajeros = new ArrayList<Pasajero>();
    private Aeropuerto aeropuertoDeSalida;
    private Aeropuerto aeropuertoDeLlegada;
    private List<Aeropuerto> escalas = new ArrayList<Aeropuerto>();

    public Vuelo(int capacidad, Aeropuerto aeropuertoDeSalida, Aeropuerto aeropuertoDeLlegada) {
        this.capacidad = capacidad;
        this.aeropuertoDeSalida = aeropuertoDeSalida;
        this.aeropuertoDeLlegada = aeropuertoDeLlegada;
    }
    public void removerEscala(Aeropuerto aeropuerto) {
        escalas.removeIf(x->x.equals(aeropuerto));
    }
    public void agregarEscala(Aeropuerto aeropuerto) {
        if (!escalas.contains(aeropuerto)) {
            System.out.println("Escala agregada");
            escalas.add(aeropuerto);
            return;
        }
        System.out.println("Esta escala ya existe");
    }
    public void agregarPasajero(Pasajero pasajero) {
        if (!sePuedeAgregarPasajero()) {
            System.out.println("El vuelo ya no tiene capacidad");
            return;
        }
        if (this.listadoDePasajeros.contains(pasajero)) {
            System.out.println("El pasajero ya está registrado en el vuelo");
            return;
        }
        this.listadoDePasajeros.add(pasajero);
        System.out.println("El pasajero fue agregado en el vuelo");
    }
    public boolean sePuedeAgregarPasajero(){
        return this.listadoDePasajeros.size()<this.capacidad;
    }
}
