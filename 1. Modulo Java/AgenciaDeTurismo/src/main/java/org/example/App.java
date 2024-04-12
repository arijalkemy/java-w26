package org.example;

import org.example.agenciaDeTurismo.AgenciaDeTurismo;
import org.example.agenciaDeTurismo.Cliente;
import org.example.agenciaDeTurismo.reservas.ReservaComida;
import org.example.agenciaDeTurismo.reservas.ReservaHotel;
import org.example.agenciaDeTurismo.reservas.ReservaTransporte;
import org.example.agenciaDeTurismo.reservas.ReservaViaje;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AgenciaDeTurismo ag = new AgenciaDeTurismo();

        Cliente cl1 = new Cliente();
        ag.crearLocalizador(cl1, new ReservaTransporte(1, 50), new ReservaComida(1, 10), new ReservaViaje(1, 12), new ReservaHotel(1, 50));
        ag.crearLocalizador(cl1, null, null, new ReservaViaje(2, 100), new ReservaHotel(2, 20));
        ag.crearLocalizador(cl1, new ReservaTransporte(1, 50), new ReservaComida(1, 20), new ReservaViaje(2, 40), new ReservaHotel(3, 10));

        System.out.println(ag.localizadoresVendidos());
        System.out.println(ag.cantidadReservas());
        System.out.println(ag.reservasPorTipo());
        System.out.println(ag.totalVentas());
        System.out.println(ag.promedioVentas());
    }
}
