package org.ggomezr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositorioClientes {
    private Map<String, List<Localizador>> clientes;

    public RepositorioClientes() {
        this.clientes = new HashMap<>();
    }

    public void agregarLocalizador(String cliente, Localizador localizador) {
        if (!clientes.containsKey(cliente)) {
            clientes.put(cliente, new ArrayList<>());
        }
        clientes.get(cliente).add(localizador);
    }

    public int cantidadLocalizadoresVendidos() {
        int total = 0;
        for (List<Localizador> listaLocalizadores : clientes.values()) {
            total += listaLocalizadores.size();
        }
        return total;
    }

    public int cantidadTotalReservas() {
        int total = 0;
        for (List<Localizador> listaLocalizadores : clientes.values()) {
            for (Localizador localizador : listaLocalizadores) {
                total += localizador.getReservas().size();
            }
        }
        return total;
    }

    public Map<String, Integer> obtenerDiccionarioReservasPorTipo() {
        Map<String, Integer> diccionario = new HashMap<>();
        for (List<Localizador> listaLocalizadores : clientes.values()) {
            for (Localizador localizador : listaLocalizadores) {
                for (Reserva reserva : localizador.getReservas()) {
                    String tipo = reserva.getTipo();
                    diccionario.put(tipo, diccionario.getOrDefault(tipo, 0) + 1);
                }
            }
        }
        return diccionario;
    }

    public double totalVentas() {
        double total = 0;
        for (List<Localizador> listaLocalizadores : clientes.values()) {
            for (Localizador localizador : listaLocalizadores) {
                total += calcularTotal(localizador);
            }
        }
        return total;
    }

    public double promedioVentas() {
        double totalVentas = totalVentas();
        int cantidadLocalizadores = cantidadLocalizadoresVendidos();
        if (cantidadLocalizadores > 0) {
            return totalVentas / cantidadLocalizadores;
        } else {
            return 0;
        }
    }

    private double calcularTotal(Localizador localizador) {
        double total = 0;
        List<Reserva> reservas = localizador.getReservas();
        for (Reserva reserva : reservas) {
            total += reserva.getPrecio();
        }
        total -= aplicarDescuentoCantidadLocalizadores(localizador);
        total -= aplicarDescuentoPaqueteCompleto(localizador);
        total -= aplicarDescuentoReservasRepetidas(localizador);
        return total;
    }

    private double aplicarDescuentoCantidadLocalizadores(Localizador localizador) {
        List<Localizador> localizadoresCliente = clientes.get(localizador.getCliente());
        if (localizadoresCliente != null && localizadoresCliente.size() >= 2) {
            return 0.05 * calcularTotal(localizador);
        }
        return 0;
    }

    private double aplicarDescuentoPaqueteCompleto(Localizador localizador) {
        List<String> tiposReservas = new ArrayList<>();
        for (Reserva reserva : localizador.getReservas()) {
            tiposReservas.add(reserva.getTipo());
        }
        if (tiposReservas.contains("hotel") && tiposReservas.contains("comida") && tiposReservas.contains("boleto") && tiposReservas.contains("transporte")) {
            return 0.1 * calcularTotal(localizador);
        }
        return 0;
    }

    private double aplicarDescuentoReservasRepetidas(Localizador localizador) {
        int countHotel = 0;
        int countBoleto = 0;
        for (Reserva reserva : localizador.getReservas()) {
            if (reserva.getTipo().equals("hotel")) {
                countHotel++;
            } else if (reserva.getTipo().equals("boleto")) {
                countBoleto++;
            }
        }
        if (countHotel >= 2 || countBoleto >= 2) {
            return 0.05 * calcularTotal(localizador);
        }
        return 0;
    }

    public Map<String, List<Localizador>> getClientes() {
        return clientes;
    }

    public void setClientes(Map<String, List<Localizador>> clientes) {
        this.clientes = clientes;
    }
}
