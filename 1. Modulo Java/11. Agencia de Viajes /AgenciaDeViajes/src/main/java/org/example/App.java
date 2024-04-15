package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        //Pool de reservas
        Reserva reserva1 = new Reserva("Vuelos",TipoReserva.VIAJES,400);
        Reserva reserva2 = new Reserva("Otro vuelo",TipoReserva.COMIDA,600);
        Reserva reserva3 = new Reserva("Casa Blanca",TipoReserva.HOTEL,1000);
        Reserva reserva4 = new Reserva("Turbobus",TipoReserva.TRANSPORTE,2000);

        //Listas con reservas
        List<Reserva> lista1 = new ArrayList<>();
        lista1.add(reserva1);
        lista1.add(reserva2);
        lista1.add(reserva3);
        //Pool de Clientes
        Cliente cliente1 = new Cliente(123L,"Juan");
        Cliente cliente2 = new Cliente(1234L,"Juan");
        //Pool localizadores
        Localizador paquete1 = new Localizador(cliente1,lista1);
        System.out.println(paquete1.obtenerTotalDeReserva(0));
        paquete1.añadirReserva(reserva4);
        System.out.println(paquete1.obtenerTotalDeReserva(0));

        //Con implementacion de repositorio
        RepoLocalizador repoLocalizador = new RepoLocalizador();
        repoLocalizador.agregarLocalizador(paquete1);

        List<Cliente> listaClientes= new ArrayList<>();
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);

        System.out.println(paquete1.toString());

        Reserva reserva5 = new Reserva("Viaje1",TipoReserva.VIAJES,100);
        Reserva reserva6 = new Reserva("Viaje2",TipoReserva.VIAJES,500);
        Reserva reserva7 = new Reserva("Hotel1",TipoReserva.HOTEL, 1000);
        Reserva reserva8 = new Reserva("Hotel2",TipoReserva.HOTEL, 10000);
        Reserva reserva9 = new Reserva("TEST",TipoReserva.TRANSPORTE,100);


        Localizador paquete2 = new Localizador(cliente1,new ArrayList<>());
        paquete2.añadirReserva(reserva7);
        paquete2.añadirReserva(reserva8);
        paquete2.añadirReserva(reserva5);
        paquete2.añadirReserva(reserva6);
        paquete2.añadirReserva(reserva9);
        System.out.println(paquete2.obtenerTotalDeReserva(0));
    }

}
