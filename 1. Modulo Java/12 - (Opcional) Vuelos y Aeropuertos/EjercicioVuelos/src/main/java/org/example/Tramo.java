package org.example;

public class Tramo {
    boolean esEscala;
    Aeropuerto aeropuertoOrigen;
    Aeropuerto getAeropuertoDestino;
    double duracion;
    int dia;
    int mes;

    public Tramo(boolean esEscala, Aeropuerto aeropuertoOrigen, Aeropuerto getAeropuertoDestino, double duracion, int dia, int mes) {
        this.esEscala = esEscala;
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.getAeropuertoDestino = getAeropuertoDestino;
        this.duracion = duracion;
        this.dia = dia;
        this.mes = mes;

    }

    public boolean isEsEscala() {
        return esEscala;
    }

    public void setEsEscala(boolean esEscala) {
        this.esEscala = esEscala;
    }

    public Aeropuerto getAeropuertoOrigen() {
        return aeropuertoOrigen;
    }

    public void setAeropuertoOrigen(Aeropuerto aeropuertoOrigen) {
        this.aeropuertoOrigen = aeropuertoOrigen;
    }

    public Aeropuerto getGetAeropuertoDestino() {
        return getAeropuertoDestino;
    }

    public void setGetAeropuertoDestino(Aeropuerto getAeropuertoDestino) {
        this.getAeropuertoDestino = getAeropuertoDestino;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }
}
