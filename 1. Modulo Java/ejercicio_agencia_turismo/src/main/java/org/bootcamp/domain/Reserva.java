package org.bootcamp.domain;

public class Reserva {

    private static int contadorId = 0;
    private int idReserva;

    private boolean viaje;
    private boolean hotel;
    private boolean comida;
    private boolean transporte;
    private double valor;

    public Reserva() {
    }

    public Reserva(boolean viaje, boolean hotel, boolean comida, boolean transporte) {
        this.idReserva = ++contadorId;
        this.viaje = viaje;
        this.hotel = hotel;
        this.comida = comida;
        this.transporte = transporte;
        this.valor = this.getValor();
    }

    public double getValor() {
        this.valor = 0;
        if(viaje){
            this.valor+=50;
        }

        if(hotel){
            this.valor+=60;
        }

        if(comida){
            this.valor+=80;
        }

        if(transporte){
            this.valor+=50;
        }
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isViaje() {
        return viaje;
    }

    public void setViaje(boolean viaje) {
        this.viaje = viaje;
    }

    public boolean isHotel() {
        return hotel;
    }

    public void setHotel(boolean hotel) {
        this.hotel = hotel;
    }

    public boolean isComida() {
        return comida;
    }

    public void setComida(boolean comida) {
        this.comida = comida;
    }

    public boolean isTransporte() {
        return transporte;
    }

    public void setTransporte(boolean transporte) {
        this.transporte = transporte;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("\n*** Reserva ***");
        sb.append("\nid reserva: ").append(idReserva);
        sb.append("\nviaje: ").append(viaje);
        sb.append("\nhotel: ").append(hotel);
        sb.append("\ncomida: ").append(comida);
        sb.append("\ntransporte: ").append(transporte);
        sb.append("\nvalor: ").append(valor);
        return sb.toString();
    }
}
