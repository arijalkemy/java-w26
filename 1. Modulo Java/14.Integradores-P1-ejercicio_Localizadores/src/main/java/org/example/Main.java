package org.example;

import java.util.List;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        RepoLocalizador repoLocalizador = new RepoLocalizador();

        // PARTE 1
        Cliente cliente = new Cliente("Juan", "Navarro", 123123);

        List<Reserva> r = List.of(new Reserva("hotel", 100.0), new Reserva("comida", 100.0), new Reserva("boleto", 100.0));
        Localizador localizador = new Localizador(cliente, r);
        repoLocalizador.guardarLocalizador(localizador);

        List<Reserva> r2 = List.of(new Reserva("boleto", 100.0), new Reserva("boleto", 100.0), new Reserva("hotel", 100.0), new Reserva("hotel", 100.0));
        Localizador localizador2 = new Localizador(cliente, r2);
        repoLocalizador.guardarLocalizador(localizador2);

        List<Reserva> r3 = List.of(new Reserva("boleto", 100.0));
        Localizador localizador3 = new Localizador(cliente, r3);
        repoLocalizador.guardarLocalizador(localizador3);

        //PARTE 2

        Busqueda busqueda = new Busqueda(repoLocalizador.getLocalizadores());
        System.out.println("Cantidad de reservas: " + busqueda.obtenerCantidadDeReservas());
        System.out.println("Cantidad de localizadores: " + busqueda.obtenercantidadLocalizadores());
        System.out.println("Promedio de ventas: " + busqueda.obtenerPromedioDeVentas());
        System.out.println("Todal de ventas: " + busqueda.obtenerTotalDeVentas());
        System.out.println("Reservas: " + busqueda.obtenerReservas());

    }
}