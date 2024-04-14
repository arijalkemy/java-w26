package org.example.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorLocalizadores {
    private RepositorioLocalizador repositorioLocalizador;

    public GestorLocalizadores(RepositorioLocalizador respositorioLocalizador) {
        this.repositorioLocalizador = respositorioLocalizador;
    }

    public RepositorioLocalizador getRepositorioLocalizador() {
        return repositorioLocalizador;
    }

    public void setRepositorioLocalizador(RepositorioLocalizador repositorioLocalizador) {
        this.repositorioLocalizador = repositorioLocalizador;
    }

    public int localizadoresVendidos() {
        return repositorioLocalizador.getLocalizadores().size();
    }

    public int totalDeReservas() {
        return repositorioLocalizador.getLocalizadores()
                .stream()
                .mapToInt(localizador -> localizador.getReservas().size())
                .sum();
    }

    public Map<Integer, List<Reserva>> reservasPorTipo() {
        Map<Integer, List<Reserva>> diccionario = new HashMap<Integer, List<Reserva>>();

        repositorioLocalizador.getLocalizadores()
                .forEach(localizador -> {
                    localizador.getReservas()
                        .forEach(reserva -> {
                            Integer keyTipo = reserva.getProducto().getTipoProducto().getId();
                            if (diccionario.containsKey(keyTipo)) {

                                diccionario.get(keyTipo).add(reserva);
                            } else {
                                List<Reserva> reservasDelTipo = new ArrayList<Reserva>();
                                reservasDelTipo.add(reserva);
                                diccionario.put(keyTipo, reservasDelTipo);
                            }
                        });
                });

        return diccionario;
    }

    public double totalVentas() {
        return repositorioLocalizador.getLocalizadores()
                .stream()
                .mapToDouble(localizador -> localizador.getReservas()
                        .stream()
                        .mapToDouble(reserva -> reserva.getCosto())
                        .sum()
                )
                .sum();
    }

    public double promedioVentas() {
        double total = totalVentas();

        double cantidadVentas = repositorioLocalizador.getLocalizadores()
                .stream()
                .mapToDouble(localizador -> localizador.getReservas().size())
                .sum();

        return totalVentas()/cantidadVentas;
    }
}
