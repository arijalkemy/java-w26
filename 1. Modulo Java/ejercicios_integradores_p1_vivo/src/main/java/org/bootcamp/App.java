package org.bootcamp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main( String[] args ) {
        // Parte 1)
        System.out.println("Parte 1)");
        RepositorioCliente repositorioClientes = new RepositorioCliente();
        RepositorioLocalizadores repositorioLocalizadores = new RepositorioLocalizadores();

        // 1)
        System.out.println("1) Crear un localizador con un paquete completo para un cliente, almacenar e imprimir el resultado.");
        Cliente clienteUno =  new Cliente(40111222, "Jose", "+5492665001122");
        List<Reserva> reservasUno = new ArrayList<Reserva>();
        Reserva reservaHotel = new Reserva("NH Hotel", TipoDeReserva.HOTEL, 1000);
        Reserva reservaComida = new Reserva("Comidas Continental", TipoDeReserva.COMIDA, 500);
        Reserva reservaViaje = new Reserva("Lufthansa", TipoDeReserva.VIAJE, 800);
        Reserva reservaTransporte = new Reserva("Transporte Verstappen", TipoDeReserva.TRANSPORTE, 200);
        reservasUno.add(reservaHotel);
        reservasUno.add(reservaComida);
        reservasUno.add(reservaViaje);
        reservasUno.add(reservaTransporte);

        Localizador localizadorUno = new Localizador(clienteUno, reservasUno);
        repositorioLocalizadores.agregarLocalizador(localizadorUno);

        // 2)
        System.out.println("2) Crear un localizador con 2 reservas de hotel y 2 de boletos para el mismo cliente anterior, almacenar e imprimir el resultado.");
        List<Reserva> reservasDos = new ArrayList<Reserva>();
        reservasDos.add(reservaHotel);
        reservasDos.add(reservaHotel);
        reservasDos.add(reservaViaje);
        reservasDos.add(reservaViaje);

        Localizador localizadorDos = new Localizador(clienteUno, reservasDos);
        repositorioLocalizadores.agregarLocalizador(localizadorDos);

        // 3)
        System.out.println("3) Crear un localizador con una sola reserva para el mismo cliente.");
        List<Reserva> reservasTres = new ArrayList<Reserva>();
        reservasTres.add(reservaViaje);

        Localizador localizadorTres = new Localizador(clienteUno, reservasTres);
        repositorioLocalizadores.agregarLocalizador(localizadorTres);

        // Parte 2)
        System.out.println("Parte 2)");
        Estadisticas estadisticas = new Estadisticas(repositorioLocalizadores);
        System.out.println("Cantidad de localizadores vendidos: " + estadisticas.getCantidadLocalizadoresVendidos());
        System.out.println("Cantidad total de reservas: " + estadisticas.getCantidadTotalReservas());
        System.out.println("Obtener un diccionario de todas las reservas clasificados por tipo (hotel, boleto,comida,transporte):");
        System.out.println(estadisticas.getReservasClasificadasPorTipo());
        System.out.println("Total de ventas: $" + estadisticas.getTotalDeVentas());
        System.out.println("Promedio de todas las ventas: $" + estadisticas.getPromedioVentas());
    }
}
