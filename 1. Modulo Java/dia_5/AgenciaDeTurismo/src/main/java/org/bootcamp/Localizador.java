package org.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Localizador {

    private Cliente cliente;
    private List<Reserva> reservas;

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
    }

    public Localizador(Cliente cliente) {
        this.cliente = cliente;
        this.reservas = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void agregarReserva(Reserva reserva) {
        this.reservas.add(reserva);
    }

    public void aplicarDescuento() {
        for (Reserva reserva : reservas
        ) {
            reserva.setPrecio(reserva.getPrecio() * 0.95);

        }
    }

    @Override
    public String toString() {
        String resultado = "\"Localizador{\" +\n" +
                "                \"cliente=\" + cliente";
        for (Reserva reserva :
                reservas) {
            resultado += reserva.toString();
        }
        return resultado;
    }
}
