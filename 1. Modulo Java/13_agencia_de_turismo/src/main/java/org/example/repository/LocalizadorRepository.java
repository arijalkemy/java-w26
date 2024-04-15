package org.example.repository;

import org.example.classes.Localizador;
import org.example.classes.Reserva;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocalizadorRepository {

    Map<String, List<Localizador>> localizadores;

    public LocalizadorRepository() {
        this.localizadores = new HashMap<>();
    }

    public void agregarLocalizador(Localizador localizador) {
        List<Localizador> localizadoresCliente = this.localizadores.get(localizador.getCliente().getDni());

        if(localizador.getReservas().stream().map(Reserva::getTipo).distinct().count() >= 4){
            // Paquete con 4 tipos, descuento del 10%
            localizador.setCostoTotal(localizador.getCostoTotal() * 0.9);
        }

        long hotelCount = localizador.getReservas().stream().filter( reserva -> reserva.getTipo().equals("Hotel")).count();
        long transporteCount = localizador.getReservas().stream().filter( reserva -> reserva.getTipo().equals("Transporte")).count();
        if(hotelCount == 2 || transporteCount == 2){
            localizador.setCostoTotal(localizador.getCostoTotal() * 0.95);
        }

        if(localizadoresCliente == null) {
            localizadoresCliente = new ArrayList<>();
            localizadoresCliente.add(localizador);
            this.localizadores.put(localizador.getCliente().getDni(), localizadoresCliente);
            return;
        }

        if(localizadoresCliente.size() >= 2){
            // Es la tercera o más Localizacion
            localizador.setCostoTotal(localizador.getCostoTotal() * 0.95);
        }

        localizadoresCliente.add(localizador);
        this.localizadores.put(localizador.getCliente().getDni(), localizadoresCliente);
    }

    public List<Localizador> getLocalizadores(String idCliente) {
        if(this.localizadores != null){
            return this.localizadores.get(idCliente);
        }
        return new ArrayList<>();
    }

    public Integer getTotalLocalizadores() {
        return this.localizadores.values().stream().mapToInt(List::size).sum();
    }

    public Integer getTotalReservas() {
        return this.localizadores.values().stream().flatMapToInt(p -> p.stream().mapToInt(e -> e.getReservas().size())).sum();
    }

    public Double getTotalVentas(){
        return this.localizadores.values().stream().mapToDouble(p -> p.stream().mapToDouble(Localizador::getCostoTotal).sum()).sum();
    }

    public Double getPromedioVentas() {
        return this.getTotalVentas() / this.getTotalLocalizadores();
    }

}
