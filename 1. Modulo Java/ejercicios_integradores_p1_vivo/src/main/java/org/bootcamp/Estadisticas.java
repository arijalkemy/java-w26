package org.bootcamp;

import java.util.*;
import java.util.stream.Collectors;

public class Estadisticas {
    private RepositorioLocalizadores repositorioLocalizadores;

    public Estadisticas(RepositorioLocalizadores repositorioLocalizadores) {
        this.repositorioLocalizadores = repositorioLocalizadores;
    }

    public int getCantidadLocalizadoresVendidos() {
        return (int) repositorioLocalizadores.getLocalizadores().stream().count();
    }

    public int getCantidadTotalReservas() {
        return (int) repositorioLocalizadores.getLocalizadores().stream()
                .map(l -> l.getReservas()).mapToInt(List::size).sum();
    }

    public Map<TipoDeReserva, List<Reserva>> getReservasClasificadasPorTipo() {
        Map<TipoDeReserva, List<Reserva>> reservasPorTipo = new HashMap<>();
        reservasPorTipo.put(TipoDeReserva.HOTEL, new ArrayList<>());
        reservasPorTipo.put(TipoDeReserva.COMIDA, new ArrayList<>());
        reservasPorTipo.put(TipoDeReserva.VIAJE, new ArrayList<>());
        reservasPorTipo.put(TipoDeReserva.TRANSPORTE, new ArrayList<>());

        List<Reserva> reservas = repositorioLocalizadores.getLocalizadores().stream()
                .map(l -> l.getReservas()).flatMap(List::stream).collect(Collectors.toList());

        for(Reserva reserva : reservas) {
            List<Reserva> reservasTipoParticular = reservasPorTipo.get(reserva.getTipoReserva());
            reservasTipoParticular.add(reserva);
            reservasPorTipo.put(reserva.getTipoReserva(), reservasTipoParticular);
        }

        return reservasPorTipo;
    }

    public double getTotalDeVentas() {
        Optional<Double> total = repositorioLocalizadores.getLocalizadores().stream()
                .map(Localizador::getTotal).reduce(Double::sum);

        return total.orElse(0.0);
    }

    public double getPromedioVentas() {
        OptionalDouble promedio = repositorioLocalizadores.getLocalizadores().stream()
                .map(Localizador::getTotal).mapToDouble(Double::doubleValue).average();

        if (promedio.isPresent()) {
            return promedio.getAsDouble();
        } else {
            return 0.0;
        }
    }
}
