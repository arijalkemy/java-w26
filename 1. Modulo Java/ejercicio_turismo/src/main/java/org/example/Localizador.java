package org.example;

import java.util.HashSet;

public class Localizador {
    private Cliente cliente;
    private double total;
    private HashSet<Reserva> reservas;

    private boolean paqueteCompleto;

    public Localizador(Cliente cliente, HashSet<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        //Aplicamos descuento a cada dos boletos o 2 de hotel
        descuentoHotelViaje(reservas);
        this.paqueteCompleto = paqueteCompleto(reservas);
        //Aplicamos descuento 10% cuando haya paquete completo
        this.total = sumarReservas(reservas);
    }

    /*
    *
    * Revisa si el localizador contiene todas las reservas
     */
    public boolean paqueteCompleto(HashSet<Reserva> reservas){
        /*
        * 0 = hotel
        * 1 = comida
        * 2 = boletos
        * 3 = transporte
         */
        boolean aux[] = {false, false, false, false};

        for(Reserva reserva : reservas) {
            //System.out.println(reserva.getPrecio());
            if (reserva.getTipoReserva() == TipoReserva.HOT) {
                aux[0] = true;
            } else if (reserva.getTipoReserva() == TipoReserva.COM) {
                aux[1] = true;
            } else if (reserva.getTipoReserva() == TipoReserva.BOL) {
                aux[2] = true;
            } else {
                aux[3] = true;
            }
        }
        return aux[0] && aux[1] && aux[2] && aux[3];
    }

    /*
    * Se da un descuento del 5% en reservas cuando son
    * 2 para hotel o boleto, se aplica sobre cada reserva
     */
    private void descuentoHotelViaje(HashSet<Reserva> reservas){
        HashSet<Reserva> hotels= new HashSet<>();
        HashSet<Reserva> boletos = new HashSet<>();
        for(Reserva reserva: reservas) {
            if (reserva.getTipoReserva().equals(TipoReserva.BOL)) {
                boletos.add(reserva);
                if (boletos.size() == 2) {
                    for (Reserva boleto : boletos) {
                        //System.out.println(boleto.getPrecio());
                        this.descuentoAreserva(boleto);
                        //System.out.println(boleto.getPrecio());
                    }
                    boletos.clear();
                }
            } else if (reserva.getTipoReserva().equals(TipoReserva.HOT)) {
                hotels.add(reserva);
                if (hotels.size() == 2) {
                    for (Reserva hotel : hotels) {
                        this.descuentoAreserva(hotel);
                    }
                    hotels.clear();
                }

            }
        }
    }

    /*
    * Aplica 5% de descuento a reservas
     */
    private void descuentoAreserva(Reserva reserva){
        reserva.setPrecio(reserva.getPrecio() - reserva.getPrecio()*0.05);
    }

    /*
    *
    * Da un descuento del 10% en el localizador cuando se compraron
    * todos los tipos de reservas
     */
    public double sumarReservas(HashSet<Reserva> reservas){
        double aux = reservas.stream().mapToDouble(Reserva::getPrecio).sum();
        if(this.paqueteCompleto)
            return aux - aux*0.1;
        return aux;
    }

    public void nuevoTotalReserva(Reserva reserva){
        this.total += reserva.getPrecio();
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public HashSet<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(HashSet<Reserva> reservas) {
        this.reservas = reservas;
    }


}
