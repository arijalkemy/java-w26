package org.bootcamp;

public class Reserva {
   private String descripción;
   private int tipo;
   private double precio;

    public Reserva(String descripción, int tipo, double precio) {
        this.descripción = descripción;
        this.tipo = tipo;
        this.precio = precio;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean esPaqueteCompleto(){
        return this.tipo ==1;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "descripción='" + descripción + '\'' +
                ", tipo=" + tipo +
                ", precio=" + precio +
                '}';
    }
}
