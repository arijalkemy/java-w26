package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        reserva.add(new Producto("001","hotel", 1000));
        reserva.add(new Producto("002","viaje", 2000));
        reserva.add(new Producto("003","transporte", 500));
        reserva.add(new Producto("004","comida", 200));

        repoCliente.addCliente(cliente);
        repoLocalizador.addLocalizador(cliente, reserva);
        repoLocalizador.mostrarUltimoLocalizador(cliente.getDni());

        List<Producto> nuevaReserva = new ArrayList<>();
        nuevaReserva.add(new Producto("005","hotel", 1000));
        nuevaReserva.add(new Producto("006","hotel", 1000));
        nuevaReserva.add(new Producto("007","viaje", 2000));
        nuevaReserva.add(new Producto("008","viaje", 2000));

        repoLocalizador.addLocalizador(cliente, nuevaReserva);
        repoLocalizador.mostrarUltimoLocalizador(cliente.getDni());

        List<Producto> ultimaReserva = new ArrayList<>();
        ultimaReserva.add(new Producto("009","comida", 1000));

        repoLocalizador.addLocalizador(cliente, ultimaReserva);
        repoLocalizador.mostrarUltimoLocalizador(cliente.getDni());

        // Parte 2

        // cant localizadores vendidos:
        System.out.println("Se vendieron " + repoLocalizador.cantLocalizadores() + " localizadores");

        // cant total reservas:
        System.out.println("Se realizaron " + repoLocalizador.cantTotalReservas() + " reservas");

        // map por cada tipo de reserva:
        // (no me quedo muy claro cual tenia que ser la clave del diccionario asi que le puse un id a la reserva)
        repoLocalizador.diccionarioReservas("hotel");
        repoLocalizador.diccionarioReservas("viaje");
        repoLocalizador.diccionarioReservas("transporte");
        repoLocalizador.diccionarioReservas("comida");

        // monto total de ventas:
        System.out.println("Se acumularon $" + repoLocalizador.montoTotalReservas() + " de reservas");

        // promedio de las ventas:
        System.out.println("El promedio de ventas es de $" + repoLocalizador.promedioMontoReservas());




    }
}
