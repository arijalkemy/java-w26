package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Localizador {

    private Cliente cliente;
    private List<Producto> reservas;
    private double total;
    private double totalConDescuento;
    private double descuentos;

    public Localizador(Cliente cliente, List<Producto> productos) {
        this.cliente = cliente;
        this.reservas = productos;
        this.total = calcularTotal();
        this.totalConDescuento = this.total;
        this.descuentos = calcularDescuentos("hotel", "viaje");
    }

    public double calcularTotal() {
        return reservas.stream().mapToDouble(p -> p.getPrecio()).sum();
    }

    public boolean tienePaqueteCompleto() {
        return reservas.stream().map(p -> p.getTipo()).collect(Collectors.toList()).containsAll(Arrays.asList("hotel", "viaje", "transporte", "comida"));
    }

    public boolean tieneDos(String tipo) {
        return reservas.stream().filter(r -> r.getTipo().equalsIgnoreCase(tipo)).count() >= 2;
    }

    public double calcularDescuentos(String hotel, String viaje) {
        double descuento = 0;
        if (tieneDos(hotel)) {
            descuento = descuento + 0.05;
        }
        if (tieneDos(viaje)) {
            descuento = descuento + 0.05;
        }
        if (tienePaqueteCompleto()) {
            descuento = descuento + 0.1;
        }
        return descuento;
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

    public double getTotalConDescuento() {
        return totalConDescuento;
    }

    public void setTotalConDescuento(double totalConDescuento) {
        this.totalConDescuento = totalConDescuento;
    }

    public List<Producto> getReservas() {
        return reservas;
    }

    public void setReservas(List<Producto> reservas) {
        this.reservas = reservas;
    }

    public double getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(double descuentos) {
        this.descuentos = descuentos;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente - DNI=" + cliente.getDni() +
                ", reservas=" + reservas +
                ", total=" + total +
                ", totalConDescuento=" + totalConDescuento +
                ", descuentos=" + descuentos +
                '}';
    }
}
