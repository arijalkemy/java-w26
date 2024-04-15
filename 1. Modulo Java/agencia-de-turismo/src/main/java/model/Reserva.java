package model;

import enums.ReservaNombres;

public class Reserva {
    private ReservaNombres nombre;
    private double precio;

    public ReservaNombres getNombre() {
        return nombre;
    }

    public void setNombre(ReservaNombres nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Reserva )){
            return false;
        }
        Reserva reserva = (Reserva) o;

        return reserva.getNombre() == this.getNombre() && reserva.getPrecio() == this.getPrecio();
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Reserva(ReservaNombres nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
