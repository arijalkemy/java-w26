package com.meli;

import java.util.List;

public class Descuentos {
    public double calcularDescuento(List<Localizador> localizador) {
        double descuentoTotal = 0;
        for (Localizador localizador1 : localizador) {
            localizador1.calcularTotal();
            descuentoTotal += localizador1.getTotal();
        }
        return descuentoTotal;
    }


    public static double aplicarDescuentos(Localizador localizador) {
        double descuento = 0;
        if (localizador.getReservaList().size() >= 2) {
            descuento += localizador.getTotal() * 0.05;
        }
        boolean paqueteCompleto = localizador.getReservaList().size() == 4;
        boolean dosReservasHotel = contarReservas(localizador, "hotel") == 2;
        boolean dosBoletosViaje = contarReservas(localizador, "boletos") == 2;

        if (paqueteCompleto) {
            descuento += localizador.getTotal() * 0.10;
        }

        if (dosReservasHotel || dosBoletosViaje) {
            descuento += localizador.getTotal() * 0.05;
        }

        return descuento;
    }

    // Método para contar el número de reservas de un tipo dado en un localizador
    private static int contarReservas(Localizador localizador, String tipo) {
        int count = 0;
        for (Reserva reserva : localizador.getReservaList()) {
            if (reserva.getTipo().equals(tipo)) {
                count++;
            }
        }
        return count;
    }
}
