package org.example.agenciaDeTurismo.reservas;

public class ReservaComida extends ReservaNoDescontable{
    public ReservaComida(int cantidad, double costoBase) {
        super(cantidad, costoBase);
    }

    @Override
    public String toString() {
        return "ReservaComida{cantidad=" + getCantidad() + ", costoBase=" + getCostoBase() + ", costoContado=" + getCosto() + "}\n";
    }
}
