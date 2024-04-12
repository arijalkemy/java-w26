package org.example;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LocalizadorTuristico {
    private Cliente cliente;
    private List<Reserva> reservas;
    private double precioTotal;
    private double precioConDescuento;
    private double descuento;


    public LocalizadorTuristico(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.descuento = 0;
        this.precioTotal = reservas.stream().mapToDouble(Reserva::getPrecio).sum();
        this.precioConDescuento = this.precioTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getPrecioConDescuento() {
        return precioConDescuento;
    }

    public void setPrecioConDescuento(double precioConDescuento) {
        this.precioConDescuento = precioConDescuento;
    }

    public boolean tieneTodoTipoReserva() {
        Set<String> tipos = this.reservas.stream().map(Reserva::getTipo).collect(Collectors.toSet());
        return tipos.containsAll(List.of("hotel", "comida", "boleto de viaje", "transporte"));
    }

    public boolean tiene2Hoteleso2Boletos() {

        List<String> tipos = this.reservas.stream().map(Reserva::getTipo).toList();

        if (tipos.stream().filter(t -> t.equals("hotel")).count() >= 2) {
            return true;
        }

        if (tipos.stream().filter(t -> t.equals("boleto de viaje")).count() >= 2) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "LocalizadorTuristico{" +
            "cliente=" + cliente +
            ", reservas=" + reservas +
            ", precioTotal=" + precioTotal +
            ", precioConDescuento=" + precioConDescuento +
            ", descuento=" + descuento +
            '}';
    }
}
