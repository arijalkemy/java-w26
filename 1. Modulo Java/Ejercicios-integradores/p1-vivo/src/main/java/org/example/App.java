package org.example;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Repositorio repositorio = new Repositorio();
        LocalizadorTuristico paquete1 = new LocalizadorTuristico(
                new Cliente("Pepito", 29, "12312312"), List.of(
                        new Reserva("hotel", 200), new Reserva("comida", 120)
        )
        );

        repositorio.agregarPaguete(paquete1);
        System.out.println("PAQUETE 1");
        System.out.println(paquete1);

        LocalizadorTuristico paquete2 = new LocalizadorTuristico(
                new Cliente("Pepito", 29, "12312312"), List.of(
                new Reserva("hotel", 200)
                , new Reserva("hotel", 120)
                , new Reserva("boleto de viaje", 100)
                , new Reserva("boleto de viaje", 150)
        )
        );

        repositorio.agregarPaguete(paquete2);
        System.out.println("PAQUETE 2");
        System.out.println(paquete2);

        System.out.println("Cantidad de localizadores vendidos: " + Consulta.calcularCantidadLocalizadores(repositorio.getPaquetes()));
        System.out.println("Cantidad de reservas: " + Consulta.calcularCantidadReservas(repositorio.getPaquetes()));
    }
}
