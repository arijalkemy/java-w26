package org.example;

import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservaList;
    private double total;

    public Localizador(Cliente cliente, List<Reserva> reservaList) {
        this.cliente = cliente;
        this.reservaList = reservaList;
        setTotal();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal() {
        for(Reserva reserva : reservaList){
            verificarPaqueteCompleto();
            this.total = this.total+reserva.getPrecio();
        }
        if(verificarPaqueteCompleto()){
            this.total = this.total*0.9;
        } else if(verificar2HotelO2Boletos()) {
            this.total = this.total*0.95;
        }
    }

    public boolean verificarPaqueteCompleto() {
        boolean hayHotel = false;
        boolean hayComida = false;
        boolean hayTransporte = false;
        boolean hayBoletos = false;
        for(Reserva reserva : reservaList){
            if(reserva.getClass() == Hotel.class) {
                hayHotel = true;
            } else if(reserva.getClass() == Comida.class) {
                hayComida = true;
            } else if(reserva.getClass() == Transporte.class) {
                hayTransporte = true;
            } else if(reserva.getClass() == Boletos.class) {
                hayBoletos = true;
            }
        }
        if(hayComida && hayHotel && hayBoletos && hayTransporte){
            return true;
        } else return false;
     }

     public boolean verificar2HotelO2Boletos() {
         int hoteles = 0;
         int boletos = 0;
         for(Reserva reserva : reservaList){
             if(reserva.getClass() == Hotel.class) {
                 hoteles++;
             } else if(reserva.getClass() == Comida.class) {
                 boletos++;
             }
         }
         if(hoteles>=2 || boletos >=2){
             return true;
         } else return false;
     }

    @Override
    public String toString() {
        return "Localizador del cliente " + cliente.getNombre() + "\n" +
                " tiene las siguiente reservas: " + "\n" + reservaList + "\n" +
                ", total=" + total +
                '}';
    }
}
