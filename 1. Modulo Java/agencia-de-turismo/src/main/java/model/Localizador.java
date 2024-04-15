package model;

import Interfaces.ILocalizador;

import java.util.List;

public class Localizador implements ILocalizador {
    private Cliente cliente;
    private double total;
    private List<Reserva> reservaList;

    public Localizador(List<Reserva> reservaList) {
        this.reservaList = reservaList;
        this.total = reservaList.stream().mapToDouble(reserva -> reserva.getPrecio()).sum();
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente.toString() +
                ", total=" + total + '\n' +
                ", reservaList=" + reservaList +
                '}';
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

    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
    }
}
