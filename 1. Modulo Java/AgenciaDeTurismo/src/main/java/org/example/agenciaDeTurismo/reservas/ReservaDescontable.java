package org.example.agenciaDeTurismo.reservas;

public class ReservaDescontable extends Reserva{
    public ReservaDescontable(int cantidad, double costoBase) {
        super(cantidad, costoBase);
    }

    @Override
    public double getCosto() {
        boolean aplicarDescuento = this.getCantidad() >= 2;
        return (this.getCostoBase() - (aplicarDescuento ? this.getCostoBase()*0.05 : 0));
    }
}
