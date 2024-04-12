package org.example.agenciaDeTurismo.reservas;

public class ReservaHotel extends ReservaDescontable{
    public ReservaHotel(int cantidad, double costoBase) {
        super(cantidad, costoBase);
    }

    @Override
    public String toString() {
        return "ReservaHotel{cantidad=" + getCantidad() + ", costoBase=" + getCostoBase() + ", costoContado=" + getCosto() + "}\n";
    }
}
