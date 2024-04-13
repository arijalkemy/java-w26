package org.example.agenciaDeTurismo;

import org.example.agenciaDeTurismo.reservas.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class AgenciaDeTurismo {
    private HashSet<Cliente> clientes = new HashSet<>();
    private HashSet<Localizador> localizadores = new HashSet<>();

    public AgenciaDeTurismo() {
    }

    public HashSet<Cliente> getClientes() {
        return clientes;
    }

    public HashSet<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void crearLocalizador(Cliente cliente, ReservaTransporte reservaTransporte, ReservaComida reservaComida, ReservaViaje reservaViaje, ReservaHotel reservaHotel) {
        Localizador localizador = new Localizador(cliente, reservaHotel, reservaViaje, reservaComida, reservaTransporte);
        localizadores.add(localizador);
        cliente.addLocalizadores(localizador);
        System.out.println("Se creó el localizador correctamente");
        System.out.println(localizador);
    }

    public int localizadoresVendidos(){
        return localizadores.size();
    }

    public int cantidadReservas(){
        return localizadores.stream().mapToInt(localizador -> localizador.getReservas().size()).sum();
    }

    public HashMap<String, List<Reserva>> reservasPorTipo(){
        HashMap<String, List<Reserva>> reservas = new HashMap<>();
        List<Reserva> viaje = new ArrayList<>();
        List<Reserva> transporte = new ArrayList<>();
        List<Reserva> comida = new ArrayList<>();
        List<Reserva> hotel = new ArrayList<>();

        localizadores.stream().forEach(localizador -> {
            localizador.getReservas().stream().forEach(
                    reserva -> {
                        if(reserva instanceof ReservaTransporte){
                            transporte.add(reserva);
                        } else if(reserva instanceof ReservaHotel){
                            hotel.add(reserva);
                        } else if(reserva instanceof ReservaComida){
                            comida.add(reserva);
                        } else if(reserva instanceof ReservaViaje){
                            viaje.add(reserva);
                        }
                    }
            );
                }
        );
        reservas.put("viaje", viaje);
        reservas.put("comida", comida);
        reservas.put("hotel", hotel);
        reservas.put("transporte", transporte);
        return reservas;
    }

    public double totalVentas(){
        return localizadores.stream().mapToDouble(Localizador::getTotal).sum();
    }

    public double promedioVentas(){
        return totalVentas() / localizadores.size();
    }
}
