package org.example;

import java.util.List;

public class Localizador {
    private Cliente cliente;
    private double total;
    private List<Reserva> listaReservas;

    public Localizador(Cliente client, List<Reserva> listaReservas) {
        this.cliente = cliente;
        this.listaReservas = listaReservas;
        this.total = obtenerTotalDeReserva();
    }

    public void añadirReserva(Reserva reserva) {
        listaReservas.add(reserva);
    }

    public double obtenerTotalDeReserva() {
        // hacer validacion si la lista está vacia
        double costo= listaReservas.stream().mapToDouble(reserva -> reserva.getCostoReserva()).sum();
        double descuento= calcularDescuento(cliente.getDescuentoAcumulado());
        double costoTotal = costo + (costo * descuento);
        return costoTotal;
    }

    public double calcularDescuento(int reservasAnteriores) {
        double descuentoAcumulado = 0.0;
        if (reservasAnteriores >= 2) {
            descuentoAcumulado = 0.05;
        }

        if (listaReservas.stream().anyMatch(reserva -> reserva.getTipoReserva() == tipoReserva.HOTEL)
            && listaReservas.stream().anyMatch(reserva -> reserva.getTipoReserva() == tipoReserva.COMIDA)
            && listaReservas.stream().anyMatch(reserva -> reserva.getTipoReserva() == tipoReserva.VIAJES)
            && listaReservas.stream().anyMatch(reserva -> reserva.getTipoReserva() == tipoReserva.TRANSPORTE)
        ){
            descuentoAcumulado += descuentoAcumulado + 0.1;
        }

        if ((listaReservas.stream().filter(reserva -> reserva.getTipoReserva() == tipoReserva.HOTEL).toList().size() >= 2)
                || (listaReservas.stream().filter(reserva -> reserva.getTipoReserva() == tipoReserva.VIAJES).toList().size() >= 2)) {
            descuentoAcumulado += descuentoAcumulado + 0.05;
        }
        return descuentoAcumulado;
    }

}
