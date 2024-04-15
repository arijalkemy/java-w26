package modelo;

import interfaces.TipoDeVuelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Vuelo {
    private Aeropuerto aeropuertoInicio;
    private Aeropuerto aeropuertoLlegada;
    private List<Escala> escalas = new ArrayList<Escala>();
    private List<Pasajero> pasajeros = new ArrayList<Pasajero>();
    private int capacidadTotal;
    private TipoDeVuelo tipoDeVuelo;
    private LocalDate fecha;

    public Vuelo(Aeropuerto aeropuertoInicio, Aeropuerto aeropuertoLlegada, TipoDeVuelo tipoDeVuelo, int capacidadTotal, LocalDate fecha) {
        this.aeropuertoInicio = aeropuertoInicio;
        this.aeropuertoLlegada = aeropuertoLlegada;
        this.tipoDeVuelo = tipoDeVuelo;
        this.capacidadTotal = capacidadTotal;
        this.fecha = fecha;
    }

    public double getDuracion(){
        return this.tipoDeVuelo.getDuracion();
    }

    public void agregarPasajero(Pasajero pasajero){
        if(pasajeros.size()<capacidadTotal){
            this.pasajeros.add(pasajero);
        }
    }

    public void mostrarCapacidadOcupada(){
        double capacidadOcupada = (double) this.pasajeros.size()/this.capacidadTotal;
        System.out.println("VUELO DE: " + aeropuertoInicio.getNombre() + " A " + aeropuertoLlegada.getNombre());
        System.out.println("CAPACIDAD OCUPADA: " + (capacidadOcupada * 100) + "%"  );
        System.out.println("ASIENTOS OCUPADOS: " + pasajeros.size());
        System.out.println("ASIENTOS LIBRES: " + (capacidadTotal - pasajeros.size()));

    }

    public Aeropuerto getAeropuertoInicio() {
        return aeropuertoInicio;
    }

    public void setAeropuertoInicio(Aeropuerto aeropuertoInicio) {
        this.aeropuertoInicio = aeropuertoInicio;
    }

    public Aeropuerto getAeropuertoLlegada() {
        return aeropuertoLlegada;
    }

    public void setAeropuertoLlegada(Aeropuerto aeropuertoLlegada) {
        this.aeropuertoLlegada = aeropuertoLlegada;
    }

    public List<Escala> getEscalas() {
        return escalas;
    }

    public void setEscalas(List<Escala> escalas) {
        this.escalas = escalas;
    }

    public List<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(List<Pasajero> pasajeros) {
        this.pasajeros = pasajeros;
    }

    public int getCapacidadTotal() {
        return capacidadTotal;
    }

    public void setCapacidadTotal(int capacidadTotal) {
        this.capacidadTotal = capacidadTotal;
    }

    public TipoDeVuelo getTipoDeVuelo() {
        return tipoDeVuelo;
    }

    public void setTipoDeVuelo(TipoDeVuelo tipoDeVuelo) {
        this.tipoDeVuelo = tipoDeVuelo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
