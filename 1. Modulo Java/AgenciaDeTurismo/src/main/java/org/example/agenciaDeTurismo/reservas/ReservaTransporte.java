package org.example.agenciaDeTurismo.reservas;

public class ReservaTransporte extends ReservaNoDescontable{
    public ReservaTransporte(int cantidad, double costoBase) {
        super(cantidad, costoBase);
    }

    @Override
    public String toString() {
        return "ReservaTransporte{cantidad=" + getCantidad() + ", costoBase=" + getCostoBase() + ", costoContado=" + getCosto() + "}\n";
    }
}
