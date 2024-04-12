package org.example;

public class Paquete {
    boolean hotel;
    boolean comida;
    boolean viaje;
    boolean transporte;

    public Paquete(boolean hotel, boolean comida, boolean viaje, boolean transporte) {
        this.hotel = hotel;
        this.comida = comida;
        this.viaje = viaje;
        this.transporte = transporte;
    }

    public Descuento getDescuento(){
        if (this.hotel && this.comida && this.viaje && this.transporte){
            return (new Descuento(0.1));
        } else {
            return (new Descuento(0.0));
        }
    }

    public double getPrecio(){
        double total = 0.0;
        if (this.hotel) total += 80;
        if (this.comida) total += 50;
        if (this.viaje) total += 90;
        if (this.transporte) total += 30;
        total -= total * this.getDescuento().getPorcentaje();
        return total;
    }

    @Override
    public String toString() {
        return "\nPaquete{" +
                "hotel=" + hotel +
                ", comida=" + comida +
                ", viaje=" + viaje +
                ", transporte=" + transporte +
                '}' +
                "\nTOTAL = " + this.getPrecio();
    }
}
