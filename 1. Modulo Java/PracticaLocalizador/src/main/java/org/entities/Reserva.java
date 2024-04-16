package org.entities;

import java.util.List;

public class Reserva {
    private int id;
    private int hotel;
    private int comida;
    private int boletos;
    private String transporte;

    public Reserva(int hotel, int comida, int boletos, String transporte) {
        this.hotel = hotel;
        this.comida = comida;
        this.boletos = boletos;
        this.transporte = transporte;
    }

    public int getId() {
        return id;
    }

    public int getHotel() {
        return hotel;
    }

    public void setHotel(int hotel) {
        this.hotel = hotel;
    }

    public int getComida() {
        return comida;
    }

    public void setComida(int comida) {
        this.comida = comida;
    }

    public int getBoletos() {
        return boletos;
    }

    public void setBoletos(int boletos) {
        this.boletos = boletos;
    }

    public String getTransporte() {
        return transporte;
    }

    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "hotel=" + hotel +
                ", comida=" + comida +
                ", boletos=" + boletos +
                ", transporte='" + transporte + '\'' +
                '}';
    }
}
