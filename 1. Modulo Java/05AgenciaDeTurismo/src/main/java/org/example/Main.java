package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("123", "John", "Doe");
        Reserva reservaHotel1 = new Reserva("Hotel", 500);
        Reserva reservaComida1 = new Reserva("Comida", 150);
        ArrayList<Reserva> reservas = new ArrayList<>();
        reservas.add(reservaHotel1);
        reservas.add(reservaComida1);

        RepositorioClientes repositorio = new RepositorioClientes();
        Localizador localizador1 = new Localizador(cliente1, reservas, repositorio);
        repositorio.guardar(localizador1);
        ArrayList<Localizador> resultado = repositorio.buscarPorDNI(cliente1.getDNI());

        resultado.forEach(l -> System.out.println(l.toString()));
    }
}

