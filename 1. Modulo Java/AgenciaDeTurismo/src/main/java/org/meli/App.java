package org.meli;

import org.meli.clases.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        Repositorio repositorio = new Repositorio();
        Cliente cliente = new Cliente(123456, "Juan Perez");
        Localizador localizador1 = new Localizador(cliente);
        localizador1.agregarReserva(new Reserva("Hotel", 1000.0));
        localizador1.agregarReserva(new Reserva("Comida", 400.0));
        localizador1.agregarReserva(new Reserva("Boletovuelo", 600.0));
        localizador1.agregarReserva(new Reserva("Transporte", 200.0));
        localizador1.calcularTotal();
        Localizador localizador2 = new Localizador(cliente);
        localizador2.agregarReserva(new Reserva("Hotel", 1000.0));
        localizador2.agregarReserva(new Reserva("Comida", 400.0));
        localizador2.agregarReserva(new Reserva("Boletovuelo", 600.0));
        localizador2.agregarReserva(new Reserva("Transporte", 200.0));
        localizador2.calcularTotal();
        Localizador localizador3 = new Localizador(cliente);
        localizador3.agregarReserva(new Reserva("Hotel", 1000.0));
        localizador3.agregarReserva(new Reserva("Hotel", 400.0));
        localizador3.agregarReserva(new Reserva("Boletovuelo", 600.0));
        localizador3.agregarReserva(new Reserva("Boletovuelo", 200.0));
        localizador3.calcularTotal();
        Localizador localizador4 = new Localizador(cliente);
        localizador4.agregarReserva(new Reserva("Hotel", 1000.0));
        localizador4.agregarReserva(new Reserva("Comida", 400.0));
        localizador4.agregarReserva(new Reserva("Boletovuelo", 600.0));
        localizador4.agregarReserva(new Reserva("Transporte", 200.0));
        localizador4.calcularTotal();

        repositorio.addLocalizador(localizador1);
        repositorio.addLocalizador(localizador2);
        repositorio.addLocalizador(localizador3);
        repositorio.addLocalizador(localizador4);
        System.out.println(repositorio.toString());
    }
}
