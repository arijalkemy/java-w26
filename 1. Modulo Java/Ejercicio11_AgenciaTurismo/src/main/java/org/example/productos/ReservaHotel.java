package org.example.productos;

public class ReservaHotel implements Producto{
    @Override
    public double getPrecio() {
        return 10000;
    }

    @Override
    public String getDescripcion() {
        return "Reserva hotel 5 estrellas";
    }
}
