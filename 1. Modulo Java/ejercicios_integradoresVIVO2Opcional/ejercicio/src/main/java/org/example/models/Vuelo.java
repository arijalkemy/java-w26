package org.example.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Vuelo {

    private Avion avion;
    private int duracion;
    private List<Pasajero> listadoDePasajeros = new ArrayList<Pasajero>();
    private Aeropuerto aeropuertoDeSalida;
    private Aeropuerto aeropuertoDeLlegada;
    private List<Aeropuerto> escalas = new ArrayList<Aeropuerto>();
    private LocalDate fechaDeVuelo;

    public Vuelo(Avion avion,int capacidad,int duracion, Aeropuerto aeropuertoDeSalida, Aeropuerto aeropuertoDeLlegada, LocalDate fechaDeVuelo) {
        this.avion = avion;
        this.duracion = duracion;
        this.aeropuertoDeSalida = aeropuertoDeSalida;
        this.aeropuertoDeLlegada = aeropuertoDeLlegada;
        this.fechaDeVuelo = fechaDeVuelo;
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
        return this.listadoDePasajeros.size()<this.avion.getCapacidad();
    }

    public int getDuracion() {
        int escala =this.escalas.size();
        return (escala>0)?this.duracion+(20*escala):this.duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }
    public int getCapacidad() {
        return avion.getCapacidad()-this.listadoDePasajeros.size();
    }


    public List<Pasajero> getListadoDePasajeros() {
        return listadoDePasajeros;
    }

    public void setListadoDePasajeros(List<Pasajero> listadoDePasajeros) {
        this.listadoDePasajeros = listadoDePasajeros;
    }

    public Aeropuerto getAeropuertoDeSalida() {
        return aeropuertoDeSalida;
    }

    public void setAeropuertoDeSalida(Aeropuerto aeropuertoDeSalida) {
        this.aeropuertoDeSalida = aeropuertoDeSalida;
    }

    public Aeropuerto getAeropuertoDeLlegada() {
        return aeropuertoDeLlegada;
    }

    public void setAeropuertoDeLlegada(Aeropuerto aeropuertoDeLlegada) {
        this.aeropuertoDeLlegada = aeropuertoDeLlegada;
    }

    public List<Aeropuerto> getEscalas() {
        return escalas;
    }

    public void setEscalas(List<Aeropuerto> escalas) {
        this.escalas = escalas;
    }
}
