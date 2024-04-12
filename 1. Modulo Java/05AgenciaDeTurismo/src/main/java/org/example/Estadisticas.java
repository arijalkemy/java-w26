package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Estadisticas {
    private RepositorioClientes repositorio;

    public Estadisticas(RepositorioClientes repositorio) {
        this.repositorio = repositorio;
    }

    public RepositorioClientes getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(RepositorioClientes repositorio) {
        this.repositorio = repositorio;
    }

    public int localizadoresVendidos() {
        return repositorio.obtenerLocalizadores().size();
    }

    public int reservasVendidas() {
        ArrayList<Localizador> localizadores = repositorio.obtenerLocalizadores();
        int totalReservas = 0;
        for (Localizador localizador : localizadores) {
            List<Reserva> reservas = localizador.getReservas().values().stream().flatMap(Collection::stream).toList();
            totalReservas += reservas.size();
        }
        return totalReservas;
    }

}
