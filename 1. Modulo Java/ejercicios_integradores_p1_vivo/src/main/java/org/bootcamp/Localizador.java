package org.bootcamp;

import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas;
    private double total;

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;

        long cantidadReservasHotel = reservas.stream().filter(r -> r.getTipoReserva() == TipoDeReserva.HOTEL).count();
        long cantidadReservasViaje = reservas.stream().filter(r -> r.getTipoReserva() == TipoDeReserva.VIAJE).count();
        double totalLocalizador = 0;
        boolean reservaHotel = false, reservaComida = false, reservaViaje = false, reservaTransporte = false;

        for(Reserva reserva : reservas) {
            if(reserva.getTipoReserva() == TipoDeReserva.HOTEL) {
                reservaHotel = true;
            }
            if(reserva.getTipoReserva() == TipoDeReserva.COMIDA) {
                reservaComida = true;
            }
            if(reserva.getTipoReserva() == TipoDeReserva.VIAJE) {
                reservaViaje = true;
            }
            if(reserva.getTipoReserva() == TipoDeReserva.TRANSPORTE) {
                reservaTransporte = true;
            }
            // Descuento del 5% sobre las reservas de tipo HOTEL si hay 2 o más reservas de tipo HOTEL
            if(reserva.getTipoReserva() == TipoDeReserva.HOTEL && cantidadReservasHotel >= 2){
                totalLocalizador = totalLocalizador + (reserva.getPrecio() * 0.95);
                continue;
            }
            // Descuento del 5% sobre las reservas de tipo VIAJE si hay 2 o más reservas de tipo VIAJE
            if(reserva.getTipoReserva() == TipoDeReserva.VIAJE && cantidadReservasViaje >= 2){
                totalLocalizador = totalLocalizador + (reserva.getPrecio() * 0.95);
                continue;
            }
            totalLocalizador = totalLocalizador + reserva.getPrecio();
        }
        // Descuento del 10% sobre el total si reservó un PAQUETE COMPLETO
        if(reservaHotel && reservaComida && reservaViaje && reservaTransporte) {
            totalLocalizador = totalLocalizador * 0.9;
        }

        this.total = totalLocalizador;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        String resultado = "Detalles del Localizador:\n" + cliente.toString() + "\nReservas:\n";
        for (Reserva reserva : reservas) {
            resultado += "- " + reserva.toString() + "\n";
        }
        resultado += "Total: $" + total;
        return resultado;
    }
}
