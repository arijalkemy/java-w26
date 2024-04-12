package org.example;

public class DetalleReserva {
    private String tipo; // Ejemplo: "hotel", "comida", "boleto", "transporte"
    private double monto; // Costo de la reserva específica

    // Constructor
    public DetalleReserva(String tipo, double monto) {
        this.tipo = tipo;
        this.monto = monto;
    }

    // Getters y Setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    // Método toString para mostrar información del detalle de reserva
    @Override
    public String toString() {
        return "DetalleReserva{" +
                "tipo='" + tipo + '\'' +
                ", monto=" + monto +
                '}';
    }
}
