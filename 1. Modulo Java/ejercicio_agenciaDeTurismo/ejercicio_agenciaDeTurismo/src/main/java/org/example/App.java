package org.example;

import org.example.classes.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        // Se instancia la lista de Localizadores y se crea el repositorio de Localizadores
        List<Localizador> localizadorList = new ArrayList<Localizador>();
        RepositorioLocalizador repositorioLocalizador = new RepositorioLocalizador(localizadorList);

        // Se instancian los tipos de producto
        TipoProducto reservaDeHotel = new TipoProducto(0, "Reserva de Hotel");
        TipoProducto comida = new TipoProducto(1, "Comida");
        TipoProducto boletoDeViaje = new TipoProducto(2, "Boleto de viaje");
        TipoProducto transporte = new TipoProducto(3, "Transporte");

        // Se instancia el cliente y se añade al repositorio
        Cliente cliente1 = new Cliente(0,"Carlos", "Tevez");
        RepositorioCliente repositorioCliente = new RepositorioCliente();
        repositorioCliente.Add(cliente1);

        // Se instancian los productos
        Producto hotel = new Producto("Reserva de Hotel", 12.50F, reservaDeHotel);
        Producto comidaProducto = new Producto("Comida", 2.34F, comida);
        Producto boletoViaje = new Producto("Boleto a Chucul", 45.78F, boletoDeViaje);
        Producto transporteProducto = new Producto("Zulki", 5.40F, transporte);

        // se instancian las reservas y se añaden al Localizador
        Reserva reservaHotel = new Reserva(hotel, 1);
        Reserva reservaComida = new Reserva(comidaProducto, 8);
        Reserva reservaBoleto = new Reserva(boletoViaje, 2);
        Reserva reservaTransporte = new Reserva(transporteProducto, 6);

        List<Reserva> reservaList = new ArrayList<Reserva>();
        reservaList.add(reservaHotel);
        reservaList.add(reservaComida);
        reservaList.add(reservaBoleto);
        reservaList.add(reservaTransporte);

        System.out.println("------------- Localizador 1 del cliente " + cliente1.getNombre() + " " + cliente1.getApellido() + " -------------");
        Localizador localizador = new Localizador(0, cliente1, LocalDateTime.now(), reservaList, repositorioLocalizador.tiene2Localizadores(cliente1.getId()));
        repositorioLocalizador.add(localizador);

        System.out.println(localizador.toString());

        Producto hotel2 = new Producto("Hotel Imperial", 200.0F, reservaDeHotel);
        Producto hotel3 = new Producto("Hotel de Lujo", 300.75F, reservaDeHotel);
        Producto boleto2 = new Producto("Boleto de ida", 300.75F, boletoDeViaje);
        Producto boleto3 = new Producto("Boleto de vuelta", 300.75F, boletoDeViaje);

        List<Reserva> reservaList1 = new ArrayList<Reserva>();

        Reserva reservaHotel2 = new Reserva(hotel2, 3);
        Reserva reservaHotel3 = new Reserva(hotel3, 2);
        Reserva reservaBoleto2 = new Reserva(boleto2, 1);
        Reserva reservaBoleto3 =new Reserva(boleto3, 1);

        reservaList1.add(reservaHotel2);
        reservaList1.add(reservaHotel3);
        reservaList1.add(reservaBoleto2);
        reservaList1.add(reservaBoleto3);

        System.out.println("\n------------- Localizador 2 del cliente " + cliente1.getNombre() + " " + cliente1.getApellido() + " -------------");
        Localizador localizador1 = new Localizador(1, cliente1, LocalDateTime.now(), reservaList1, repositorioLocalizador.tiene2Localizadores(cliente1.getId()));
        repositorioLocalizador.add(localizador1);

        System.out.println(localizador1.toString());


        Producto hotel4 = new Producto("Hotel Bello", 150.56F, reservaDeHotel);
        List<Reserva> reservaList2 = new ArrayList<Reserva>();
        Reserva reservaHotel4 = new Reserva(hotel4, 2);
        reservaList2.add(reservaHotel4);

        System.out.println("\n------------- Localizador 3 del cliente " + cliente1.getNombre() + " " + cliente1.getApellido() + " -------------");

        Localizador localizador2 = new Localizador(2, cliente1, LocalDateTime.now(), reservaList2, repositorioLocalizador.tiene2Localizadores(cliente1.getId()));
        repositorioLocalizador.add(localizador2);

        System.out.println(localizador2.toString());

        System.out.println("\n\n------------- Parte II -------------");
        GestorLocalizadores gestorLocalizadores = new GestorLocalizadores(repositorioLocalizador);
        System.out.println("\n - Cantidad de localizadores vendidos: " + gestorLocalizadores.localizadoresVendidos());
        System.out.println("\n - Cantidad total de reservas: " + gestorLocalizadores.totalDeReservas());
        System.out.println("\n - Reservas clasificadas por tipo:");
        gestorLocalizadores.reservasPorTipo().forEach((key, value) -> {
            int indice = key+1;
            System.out.println("    " + indice + ") " + value.get(0).getProducto().getTipoProducto().getNombre());
            value.forEach(reserva -> System.out.println("      - " + reserva.toString()));
        });

        System.out.println("\n - Total de ventas: $" + gestorLocalizadores.totalVentas());
        System.out.println("\n - Promedio de todas las ventas: $" + gestorLocalizadores.promedioVentas());
    }
}
