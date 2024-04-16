package Clases;

import java.util.concurrent.atomic.AtomicInteger;

public class DescuentoReservaBoleto extends Descuento{

    public DescuentoReservaBoleto(double descuento) {
        super(descuento);
    }

    @Override
    public double aplicarDescuento(Localizador localizador) {

        AtomicInteger descuentosAplicados = new AtomicInteger();

        double total = localizador.getReservas().stream().mapToDouble(
                reserva -> {

                    if (reserva.getTipoReserva().equals("HOTEL") && descuentosAplicados.get() <= 2) {
                        descuentosAplicados.getAndIncrement();
                        return reserva.getPrecio() - reserva.getPrecio() * this.getDescuento();
                    }
                    if (reserva.getTipoReserva().equals("BOLETO") && descuentosAplicados.get() <= 2) {
                        descuentosAplicados.getAndIncrement();
                        return reserva.getPrecio() - reserva.getPrecio() * this.getDescuento();
                    }
                    return reserva.getPrecio();
                }
        ).sum();

        System.out.println("total: " + total);

        return total;
    }
}
