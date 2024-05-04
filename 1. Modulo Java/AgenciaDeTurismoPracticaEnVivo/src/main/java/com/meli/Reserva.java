package com.meli;

public class Reserva{
    private String Tipo;
    private double Precio;

    public Reserva(String tipo, double precio){
        this.Tipo = tipo;
        this.Precio = precio;
    }

    public String getTipo(){
        return this.Tipo;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }


}
