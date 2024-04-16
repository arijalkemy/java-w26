package org.example;

import Clases.Descuento;
import Clases.DescuentoReservaBoleto;
import Clases.Localizador;
import Clases.Reserva;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Descuento descuentoReservaHotelBoleto = new DescuentoReservaBoleto(0.1);

        Reserva hotel = new Reserva("HOTEL",1000);

        Reserva boleto = new Reserva("BOLETO", 1000);
        Reserva comida = new Reserva("COMIDA", 500);

        Localizador localizador = new Localizador(
                "Nacho",
                new ArrayList<>(Arrays.asList(hotel,comida,boleto,hotel)),
                new ArrayList<>(Arrays.asList(descuentoReservaHotelBoleto))
        );


        System.out.println(localizador.getPrecioTotal());
    }
}
