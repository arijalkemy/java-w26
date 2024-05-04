package com.meli;

import java.util.List;

public class Localizador {
    String cliente;
    List<Reserva> reservaList;
    private double total;


    public Localizador(String cliente, List<Reserva> reservaList) {
        this.cliente = cliente;
        this.reservaList = reservaList;
    }

    public void calcularTotal()
    {
        for (Reserva reserva : reservaList) {
            total += reserva.getPrecio();
        }
    }



    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
    }

    public double getTotal() {
        total = 0;
        for (Reserva reserva : reservaList) {
            total += reserva.getPrecio();
        }
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
