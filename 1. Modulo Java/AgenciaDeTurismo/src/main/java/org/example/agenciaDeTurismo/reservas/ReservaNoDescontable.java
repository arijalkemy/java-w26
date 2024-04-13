package org.example.agenciaDeTurismo.reservas;

public class ReservaNoDescontable extends Reserva{
    public ReservaNoDescontable(int cantidad, double costoBase) {
        super(cantidad, costoBase);
    }

    @Override
    public double getCosto() {
        return this.getCostoBase();
    }
}
