package org.example;

import java.util.HashMap;
import java.util.List;

public class Busqueda {
    List<Localizador>  localizadores;

    Busqueda(List<Localizador> localizadors) {
        this.localizadores = localizadors;
    }

    public Integer obtenercantidadLocalizadores() {
        return localizadores.size();
    }

    public  Integer obtenerCantidadDeReservas (){
        return localizadores.stream().mapToInt(localizador -> localizador.getReservas().size()).sum();
    }

    public  double obtenerTotalDeVentas (){
        return localizadores.stream().mapToDouble(Localizador::getTotal).sum();
    }

    public HashMap<String, List <Localizador>>  obtenerReservas(){
        HashMap<String, List <Localizador>> reservas = new HashMap<>();

        List<Localizador> locHotel = localizadores.stream()
                .filter(objeto -> objeto.getReservas().stream()
                        .anyMatch(reserva -> reserva.getTipo().equals("hotel")))
                .toList();

        List<Localizador> locBoleto = localizadores.stream()
                .filter(objeto -> objeto.getReservas().stream()
                        .anyMatch(reserva -> reserva.getTipo().equals("boleto")))
                .toList();

        List<Localizador> locComida = localizadores.stream()
                .filter(objeto -> objeto.getReservas().stream()
                        .anyMatch(reserva -> reserva.getTipo().equals("comida")))
                .toList();

        List<Localizador> locTransporte = localizadores.stream()
                .filter(objeto -> objeto.getReservas().stream()
                        .anyMatch(reserva -> reserva.getTipo().equals("transporte")))
                .toList();

        reservas.put("hotel",locHotel);
        reservas.put("boleto",locBoleto);
        reservas.put("comida",locComida);
        reservas.put("transporte",locTransporte);

        return reservas;
    }

    public  double obtenerPromedioDeVentas (){
        return localizadores.stream().mapToDouble(Localizador::getTotal).sum()/obtenerCantidadDeReservas();
    }

}
