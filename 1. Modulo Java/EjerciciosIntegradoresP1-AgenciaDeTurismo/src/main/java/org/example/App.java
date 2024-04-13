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
        Cliente clienteUno = new Cliente(1,"Gomez","Gonzalo");
        Reserva reservaHotel = new Reserva(22.0,"Hotel");
        Reserva reservaTransporte = new Reserva(33.0,"Transporte");
        Reserva reservaComida = new Reserva(10.0,"Comida");

        Localizador localizadorUno = new Localizador(clienteUno);
        localizadorUno.agregarReserva(reservaHotel);
        localizadorUno.agregarReserva(reservaTransporte);

        Localizador localizadorDos = new Localizador(clienteUno);
        Localizador localizadorTres= new Localizador(clienteUno);

        localizadorDos.agregarReserva(reservaHotel);
        localizadorDos.agregarReserva(reservaTransporte);

        localizadorTres.agregarReserva(reservaHotel);
        localizadorTres.agregarReserva(reservaTransporte);


        Repositorio repositorio = new Repositorio();
        repositorio.agregarLocalizador(localizadorUno);
        repositorio.agregarLocalizador(localizadorDos);
        repositorio.agregarLocalizador(localizadorTres);


        System.out.println(localizadorUno.toString());
        System.out.println(localizadorDos.toString());
        System.out.println(localizadorTres.toString());


    }
}
