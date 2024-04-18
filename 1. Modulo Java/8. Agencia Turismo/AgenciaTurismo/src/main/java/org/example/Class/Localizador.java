package org.example.Class;

import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> listaReserva;

    private double montoTotal;

    public Localizador(Cliente cliente, List<Reserva> listaReserva) {
        this.cliente = cliente;
        this.listaReserva = listaReserva;
        montoTotal();
    }

    public void montoTotal(){
        this.montoTotal = listaReserva.stream().mapToDouble(r -> r.getPrecio()).sum();
    }
}
