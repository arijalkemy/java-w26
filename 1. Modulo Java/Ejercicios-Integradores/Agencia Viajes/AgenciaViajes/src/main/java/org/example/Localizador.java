package org.example;

import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private Cliente cliente;
    private double total;
    private List<String> detalles;

    public Localizador(Cliente cliente) {
        this.cliente = cliente;
        this.total = 0.0d;
        this.detalles = new ArrayList<String>();
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

    public List<String> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<String> detalles) {
        this.detalles = detalles;
    }
}
