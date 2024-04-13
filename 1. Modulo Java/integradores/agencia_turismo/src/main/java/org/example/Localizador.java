package org.example;

import org.example.enums.Tipo_Reserva;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Localizador {
   private Cliente cliente;
   private List<Reserva> reservas = new ArrayList<>();
   private double descuento = 0;

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
    }

    public double getCosto(){
        double costo = reservas.stream().mapToDouble(Reserva::getCostoReserva).sum();
        return costo - costo * descuento;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente +
                ", reservas=" + reservas +
                "\nCosto total=" + reservas.stream().mapToDouble(Reserva::getCostoReserva).sum() +
                ",\ndescuento=" + descuento +
                ", \nCosto final= " + getCosto() +
                '}';
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setreservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public boolean esPaqueteCompleto() {
        boolean paqueteCompleto = false;
        int cantidadTiposDeReservas = Tipo_Reserva.values().length;
        Set<Tipo_Reserva> tiposEncontrados = new HashSet<>();
        for(int i = 0; i < reservas.size(); i++) {
            tiposEncontrados.add(reservas.get(i).getTipoReserva());
            if (tiposEncontrados.size() == cantidadTiposDeReservas) {
                paqueteCompleto = true;
                break;
            }
        }
        return paqueteCompleto;
    }

    public boolean esReservaDobleHotelOViaje() {
        int cantidadHotel = 0;
        int cantidadVieje = 0;
        boolean esReservaDoble = false;
        for(int i= 0; i < reservas.size(); i++) {

            switch (reservas.get(i).getTipoReserva()) {
                case HOTEL:
                    cantidadHotel++;
                    break;
                case BOLETO_DE_VIAJE:
                    cantidadVieje++;
                    break;
            }

            if(cantidadHotel > 1 || cantidadVieje > 1) {
                esReservaDoble = true;
                break;
            }
        }
        return esReservaDoble;
    }
}
