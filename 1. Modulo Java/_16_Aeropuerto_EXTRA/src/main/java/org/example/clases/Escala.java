package org.example.clases;

public class Escala {
    private Aeropuerto aeropuertoEscala;
    private double cantidadHorasDeEspera;

    public Aeropuerto getAeropuertoEscala() {
        return aeropuertoEscala;
    }

    public void setAeropuertoEscala(Aeropuerto aeropuertoEscala) {
        this.aeropuertoEscala = aeropuertoEscala;
    }

    public double getCantidadHorasDeEspera() {
        return cantidadHorasDeEspera;
    }

    public void setCantidadHorasDeEspera(double cantidadHorasDeEspera) {
        this.cantidadHorasDeEspera = cantidadHorasDeEspera;
    }

    public Escala(Aeropuerto aeropuertoEscala, double cantidadHorasDeEspera) {
        this.aeropuertoEscala = aeropuertoEscala;
        this.cantidadHorasDeEspera = cantidadHorasDeEspera;
    }
}
