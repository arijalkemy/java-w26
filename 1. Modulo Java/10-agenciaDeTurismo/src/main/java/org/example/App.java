package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        RepositorioLocalizador repoLocalizador = new RepositorioLocalizador();
        RepositorioCliente repoCliente = new RepositorioCliente();
        Cliente cliente = new Cliente("39459678", "Beczkowski", "Camila");

        List<Producto> reserva = new ArrayList<>();
        reserva.add(new Producto("hotel", 1000));
        reserva.add(new Producto("viaje", 2000));
        reserva.add(new Producto("transporte", 500));
        reserva.add(new Producto("comida", 200));

        repoCliente.addCliente(cliente);
        repoLocalizador.addLocalizador(cliente, reserva);
        repoLocalizador.mostrarUltimoLocalizador(cliente.getDni());

        List<Producto> nuevaReserva = new ArrayList<>();
        nuevaReserva.add(new Producto("hotel", 1000));
        nuevaReserva.add(new Producto("hotel", 1000));
        nuevaReserva.add(new Producto("viaje", 2000));
        nuevaReserva.add(new Producto("viaje", 2000));

        repoLocalizador.addLocalizador(cliente, nuevaReserva);
        repoLocalizador.mostrarUltimoLocalizador(cliente.getDni());

        List<Producto> ultimaReserva = new ArrayList<>();
        ultimaReserva.add(new Producto("comida", 1000));

        repoLocalizador.addLocalizador(cliente, ultimaReserva);
        repoLocalizador.mostrarUltimoLocalizador(cliente.getDni());







    }
}
