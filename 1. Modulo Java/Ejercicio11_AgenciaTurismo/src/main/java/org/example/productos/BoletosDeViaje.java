package org.example.productos;

public class BoletosDeViaje implements Producto {
    @Override
    public double getPrecio() {
        return 10000;
    }

    @Override
    public String getDescripcion() {
        return "Boleto de viaje - Avianca";
    }
}
