package org.example.agenciaDeTurismo.reservas;

public class ReservaViaje extends ReservaDescontable{
    public ReservaViaje(int cantidad, double costoBase) {
        super(cantidad, costoBase);
    }

    @Override
    public String toString() {
        return "ReservaViaje{cantidad=" + getCantidad() + ", costoBase=" + getCostoBase() + ", costoContado=" + getCosto() + "}\n";
    }
}
