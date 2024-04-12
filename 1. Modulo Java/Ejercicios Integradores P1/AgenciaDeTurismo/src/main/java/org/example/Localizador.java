package org.example;

import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Paquete> reservas;
    private List<Descuento> descuentos;

    public Localizador(Cliente cliente, List<Paquete> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.descuentos = new ArrayList<Descuento>();
    }

    public void agregarDescuento(Descuento descuento){
        this.descuentos.add(descuento);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        Double totalDescuentos = 0.0;
        totalDescuentos += this.descuentos.stream().mapToDouble(Descuento::getPorcentaje).sum();
        return "Localizador{" +
                "cliente=" + cliente +
                ", reservas=" + reservas +
                '}' + "Descuento: " + totalDescuentos;
    }
}
