package org.example;

import org.example.clases.Cliente;
import org.example.clases.Localizador;
import org.example.clases.Repositorio;
import org.example.clases.Reserva;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Agencia
{
    public static void main( String[] args )
    {
        //hago el cliente
        Cliente marcos = new Cliente(432212, "marcos");

        //hago las reservas
        Reserva reservaHotel = new Reserva("Hotel", 100);
        Reserva reservaComida = new Reserva("Comida", 100);
        Reserva reservaBoleto = new Reserva("Boleto", 100);
        Reserva reservaTransporte = new Reserva("Transporte", 100);

        //hago el primer localizador
        List<Reserva> reservaListFull = new ArrayList<>();
        reservaListFull.add(reservaHotel);
        reservaListFull.add(reservaComida);
        reservaListFull.add(reservaBoleto);
        reservaListFull.add(reservaTransporte);

        Localizador localizadorFull = new Localizador(marcos, reservaListFull);

        //hago el segundo localizador
        List<Reserva> reservaListDe2 = new ArrayList<>();
        reservaListDe2.add(reservaHotel);
        reservaListDe2.add(reservaHotel);
        reservaListDe2.add(reservaBoleto);
        reservaListDe2.add(reservaBoleto);

        Localizador localizadorDe2 = new Localizador(marcos, reservaListDe2);

        //hago el tercer localizador
        List<Reserva> reservaList = new ArrayList<>();
        reservaList.add(reservaHotel);

        Localizador localizador = new Localizador(marcos, reservaList);


        //HAGO EL REPOSITORIO Y AGREGO LOS LOCALIZADORES
        Repositorio repositorio = new Repositorio();
        repositorio.addLocalizador(localizadorFull);
        repositorio.addLocalizador(localizadorDe2);
        repositorio.addLocalizador(localizador);

        System.out.println(repositorio.toString());

        //PARTE 2
        System.out.println("Cantidad de localizadores vendidos: " + repositorio.obtenerCantidadDeLocalizadores());
        System.out.println("Cantidad de reservas vendidas: " + repositorio.obtenerCantidadDeReservas());
        System.out.println("Total de ventas: $" + repositorio.obtenerTotalDeVentas() );
        System.out.println("Promedio por venta: $" + repositorio.obtenerPromedioDeVentas() );

    }
}
