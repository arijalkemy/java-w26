package org.example;

import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Producto> reservas = new ArrayList<>();
    private double total;

    public Localizador(Cliente cliente) {
        this.cliente = cliente;
        this.total = 0;
    }

    public String listaDeProductos() {
        StringBuilder sb = new StringBuilder();
        for (Producto producto : reservas) {
            sb.append(producto.getTipo()).append(", ");
        }
        return sb.toString();
    }

    public void agregarProducto(Producto producto) {
        reservas.add(producto);
        total += producto.getPrecio();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getReservas() {
        return reservas;
    }

    public void setReservas(List<Producto> reservas) {
        this.reservas = reservas;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}