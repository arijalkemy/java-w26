package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RepositorioLocalizador {

    private List<Localizador> localizadores;

    public RepositorioLocalizador() {
        this.localizadores = new ArrayList<>();
    }

    public List<Localizador> getLocalizadoresPorCliente(String dni) {
        return localizadores.stream().filter(l -> l.getCliente().getDni().equals(dni)).collect(Collectors.toList());
    }

    public void addLocalizador(Cliente cliente, List<Producto> productos) {
        Localizador localizador = new Localizador(cliente, productos);
        if (getLocalizadoresPorCliente(cliente.getDni()).size() >= 2) {
            localizador.setDescuentos(localizador.getDescuentos() + 0.05);
        }
        localizador.setTotalConDescuento(localizador.getTotal() * ( 1 - localizador.getDescuentos()));
        System.out.println("-- Agregado localizador --");
        localizadores.add(localizador);
    }

    public Localizador getUltimoLocalizador(String dni) {
        return localizadores.stream().filter(l -> l.getCliente().getDni().equals(dni)).reduce((l1, l2) -> l2).orElse(null);
    }

    public void mostrarUltimoLocalizador(String dni) {
        if (getUltimoLocalizador(dni) != null) {
            System.out.println(getUltimoLocalizador(dni));
        } else {
            System.out.println("Localizador no encontrado para mostrar");
        }
    }

    public int cantLocalizadores() {
        return localizadores.size();
    }

    public int cantTotalReservas() {
        return localizadores.stream().mapToInt(l -> l.cantReservas()).sum();
    }

    public double montoTotalReservas() {
        return localizadores.stream().mapToDouble(Localizador::getTotalConDescuento).sum();
    }

    public double promedioMontoReservas() {
        return localizadores.stream().mapToDouble(Localizador::getTotalConDescuento).average().getAsDouble();
    }

    public void diccionarioReservas(String tipo) {
        System.out.println("Diccionario de reservas de " + tipo + ": ");
        for (Localizador l : localizadores) {
            if (l.getReservas().stream()
                    .filter(r -> r.getTipo().equalsIgnoreCase(tipo)).collect(Collectors.toList()).size() > 0) {
                l.diccionarioReservas(tipo);
            }
        }

    }


}
