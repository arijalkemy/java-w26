package org.example;

public abstract class Reserva {
    private int id;
    private String lugar;
    private double precio;

    public int getId() {
        return id;
    }

    public String getLugar() {
        return lugar;
    }

    public double getPrecio() {
        return precio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Reserva(int id, String lugar, double precio) {
        this.id = id;
        this.lugar = lugar;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Reserva de " + getClass().getSimpleName() +
                " con id=" + id + "\n" +
                ", lugar='" + lugar + "\n" +
                ", precio=" + precio +
                '}';
    }
}
