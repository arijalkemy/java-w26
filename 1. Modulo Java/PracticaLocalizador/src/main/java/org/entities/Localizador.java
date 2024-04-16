package org.entities;

import java.util.List;

public class Localizador {
    private Cliente cliente;
    private double total;
    private int hotel;
    private int comida;
    private int boletos;
    private String transporte;

    public Localizador(Cliente cliente, double total, int hotel, int comida, int boletos, String transporte) {
        this.cliente = cliente;
        this.total = total;
        this.hotel = hotel;
        this.comida = comida;
        this.boletos = boletos;
        this.transporte = transporte;
    }

    public boolean tienePaqueteCompleto(){
        return hotel > 0 && comida > 0 && boletos > 0;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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
        return "Localizador{" +
                "total=" + total +
                ", hotel=" + hotel +
                ", comida=" + comida +
                ", boletos=" + boletos +
                ", transporte='" + transporte + '\'' +
                '}';
    }
}
