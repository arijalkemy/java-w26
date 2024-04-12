package org.example;

import java.util.*;

public class Localizador {
    private Cliente cliente;
    private HashMap<String, ArrayList<Reserva>> reservas;
    private double total;
    private RepositorioClientes repositorio;

    public Localizador(Cliente cliente, ArrayList<Reserva> reservas, RepositorioClientes repositorio) {
        this.cliente = cliente;
        this.reservas = new HashMap<>();
        this.reservas.put(cliente.getDNI(), reservas);
        this.total = reservas.stream().map(Reserva::getCosto).reduce(0.0, Double::sum);
        this.repositorio = repositorio;
        this.aplicarDescuentos(cliente.getDNI());
    }

    public HashMap<String, ArrayList<Reserva>> getReservas() {
        return reservas;
    }

    public double getTotal() {
        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setRepositorio(RepositorioClientes repositorio) {
        this.repositorio = repositorio;
    }

    private void aplicarDescuentos(String dniCliente) {
        double valorFinal = this.total;
        int cantidadDeLocalizadores = this.repositorio.contarPorDNI(dniCliente);
        if (cantidadDeLocalizadores >= 2) {
            valorFinal = valorFinal * 0.95;
        }
        ArrayList<Localizador> localizadoresCliente = this.repositorio.buscarPorDNI(dniCliente);
        //for (Localizador localizador : localizadoresCliente) {
        Set<String> paquete = new HashSet<String>();
        //HashMap<String, ArrayList<Reserva>> reservas = localizador.getReservas();

        this.reservas.get(dniCliente).forEach(reserva -> paquete.add(reserva.getTipo()));
        if (paquete.size() == 4) {
            valorFinal = valorFinal * 0.90;
        }

        ArrayList<Reserva> reservasCliente = this.reservas.get(dniCliente);
        ArrayList<Reserva> reservasHotel = new ArrayList<>();
        ArrayList<Reserva> reservasViaje = new ArrayList<>();
        for (Reserva reserva : reservasCliente) {
            if (Objects.equals(reserva.getTipo(), "Hotel")) {
                reservasHotel.add(reserva);
            } else if (Objects.equals(reserva.getTipo(), "Viaje")) {
                reservasViaje.add(reserva);
            }
        }

        if (reservasHotel.size() >= 2) {
            double descuentoHotel = 0;
            for (Reserva reserva : reservasHotel) {
                descuentoHotel += reserva.getCosto() * 0.05;
            }
            valorFinal -= descuentoHotel;
        }

        if (reservasViaje.size() >= 2) {
            double descuentoViaje = 0;
            for (Reserva reserva : reservasViaje) {
                descuentoViaje += reserva.getCosto() * 0.05;
            }
            valorFinal -= descuentoViaje;
        }
        //}


    }

    public String toString() {
        String texto = "Cliente: " + cliente.getDNI() +
                "\nReservas: \n";

        List<String> reservas = this.reservas.values().stream().map(AbstractCollection::toString).toList();
        for (String res : reservas) {
            texto = texto + res + "\n";
        }

        return texto;
    }
}

