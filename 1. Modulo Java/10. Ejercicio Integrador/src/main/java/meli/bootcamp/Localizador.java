package meli.bootcamp;

import java.util.List;

public class Localizador {
  List<Reserva> reservas;
  Cliente cliente;

  public Localizador(List<Reserva> reservas, Cliente cliente) {
    this.reservas = reservas;
    this.cliente = cliente;
  }

  public void agregarReserva(Reserva reserva) {
    this.reservas.add(reserva);
  }

  public void aplicarDescuentoPorReservas() {
    double porcentajeDeDescuentoPorReservas = 0.5;

    List<Reserva> reservasDeHotel = reservas.stream().filter(r -> r.getTipoReserva() == TipoReserva.HOTEL).toList();
    List<Reserva> reservasDeViaje = reservas.stream().filter(r -> r.getTipoReserva() == TipoReserva.VIAJE).toList();

    if (reservasDeHotel.size() >= 2) {
      reservasDeHotel.forEach(reserva -> reserva.setDescuento(porcentajeDeDescuentoPorReservas));
    }

    if (reservasDeViaje.size() >= 2) {
      reservasDeViaje.forEach(reserva -> reserva.setDescuento(porcentajeDeDescuentoPorReservas));
    }

  }

  public double porcentajeDeDescuentoPorPaqueteCompleto() {
    double porcentajeDeDescuentoPorPaqueteCompleto = 0.1;

    if (reservas.stream().anyMatch(reserva -> reserva.getTipoReserva() == TipoReserva.HOTEL) &&
        reservas.stream().anyMatch(reserva -> reserva.getTipoReserva() == TipoReserva.COMIDA) &&
        reservas.stream().anyMatch(reserva -> reserva.getTipoReserva() == TipoReserva.VIAJE) &&
        reservas.stream().anyMatch(reserva -> reserva.getTipoReserva() == TipoReserva.TRANSPORTE)
    ) {
      return porcentajeDeDescuentoPorPaqueteCompleto;
    }

    return 0;
  }

  public double calcularTotalSinDescuento() {
    return this.reservas.stream().mapToDouble(Reserva::getPrecio).sum();
  }

  public double calcularTotalDeDescuentos() {
    this.aplicarDescuentoPorReservas();

    double descuentoSobreElTotal = this.porcentajeDeDescuentoPorPaqueteCompleto() * this.calcularTotalSinDescuento();
    double descuentoPorReservas = this.reservas.stream().mapToDouble(Reserva::getDescuento).sum();

    return descuentoSobreElTotal + descuentoPorReservas;
  }
}

/*
Si un cliente adquiere un paquete completo que consiste en reserva de hotel, comida, boletos de viajes, transporte, recibirá un descuento del 10% del total de la factura.
Si un cliente adquiere 2 reservas de hotel o 2 boletos de viaje, se aplicará un descuento de 5% en esas reservas.

 */