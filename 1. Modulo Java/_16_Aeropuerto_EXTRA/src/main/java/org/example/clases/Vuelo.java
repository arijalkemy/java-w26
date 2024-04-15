package org.example.clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Vuelo {
    private int id;
    private Avion avion;
    private List<Boleto> boletos;
    private List<Persona> tripulacion;
    private Aeropuerto aeropuertoOrigen;
    private Aeropuerto aeropuertoDestino;
    private List<Escala> escalas;
    private double duracionTotalDelVuelo;
    private Date fechaPartida;

    private Date fechaLlegada;

    public Date getFechaPartida() {
        return fechaPartida;
    }

    public void setFechaPartida(Date fechaPartida) {
        this.fechaPartida = fechaPartida;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Aeropuerto getAeropuertoOrigen() {
        return aeropuertoOrigen;
    }

    public void setAeropuertoOrigen(Aeropuerto aeropuertoOrigen) {
        this.aeropuertoOrigen = aeropuertoOrigen;
    }

    public Aeropuerto getAeropuertoDestino() {
        return aeropuertoDestino;
    }

    public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) {
        this.aeropuertoDestino = aeropuertoDestino;
    }

    private double cantidadDeHorasEntreCiudades;

    public double getCantidadDeHorasEntreCiudades() {
        return cantidadDeHorasEntreCiudades;
    }

    public void setCantidadDeHorasEntreCiudades(double cantidadDeHorasEntreCiudades) {
        this.cantidadDeHorasEntreCiudades = cantidadDeHorasEntreCiudades;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public List<Boleto> getBoletos() {
        return boletos;
    }

    public void setBoletos(List<Boleto> boletos) {
        this.boletos = boletos;
    }

    public List<Persona> getTripulacion() {
        return tripulacion;
    }

    public void setTripulacion(List<Persona> tripulacion) {
        this.tripulacion = tripulacion;
    }

    public List<Escala> getEscalas() {
        return escalas;
    }

    public void setEscalas(List<Escala> escalas) {
        this.escalas = escalas;
    }

    public double getDuracionTotalDelVuelo() {
        return duracionTotalDelVuelo;
    }

    public void setDuracionTotalDelVuelo(double duracionTotalDelVuelo) {
        this.duracionTotalDelVuelo = duracionTotalDelVuelo;
    }

    //este constructor es para inicializar los valores fundamentales de un vuelo
    public Vuelo(int id, Avion avion, Aeropuerto aeropuertoOrigen, Aeropuerto aeropuertoDestino, double cantidadDeHorasEntreCiudades, Date fechaPartida, Date fechaLlegada) {
        this.id = id;
        this.avion = avion;
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.aeropuertoDestino = aeropuertoDestino;
        this.cantidadDeHorasEntreCiudades = cantidadDeHorasEntreCiudades;
        this.fechaPartida = fechaPartida;
        this.fechaLlegada = fechaLlegada;
        this.escalas = new ArrayList<>();
        this.boletos = new ArrayList<>();
    }

    public void agregarEscalas(Escala escala){
        this.escalas.add(escala);
    }

    public void agregarBoleto(Boleto boleto){
        this.boletos.add(boleto);
    }

    //1 Capacidad de vuelo ocupada
    public int cantidadOcupada(){
        int cantidadTotal = this.avion.getCantidadTotalDeClaseTurismo() + this.avion.getCantidadTotalDePrimeraClase();

        int cantidadOcupada = cantidadTotal - boletos.size();

        return cantidadOcupada;
    }

    //2 duracion del vuelo
    public double duracionDelVuelo(){
        double horasDeEscala = 0;
        for (Escala escala: escalas){
            horasDeEscala+= escala.getCantidadHorasDeEspera();
        }

        this.duracionTotalDelVuelo = this.cantidadDeHorasEntreCiudades + horasDeEscala;

        return this.duracionTotalDelVuelo;
    }

    public long cantidadDeBoletosDeUnaPersona(Persona persona){
        return boletos.stream().
                filter(boleto -> boleto.getPersona().equals(persona)).
                count();
    }

}
