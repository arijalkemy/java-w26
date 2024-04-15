package org.bootcamp;

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
        RepositorioCliente repositorioCliente = new RepositorioCliente();
        Cliente cliente1 =  new Cliente(123, "Edwin", 123214);
        List<Reserva> reservas = new ArrayList<Reserva>();
        reservas.add(new Reserva("Paquete completo", 1, 12323));
        reservas.add(new Reserva("Hotel", 2, 123243433));
        Localizador localizadorCliente1 = new Localizador(cliente1, reservas);
        System.out.println("Parte 1");
        System.out.println("\n Localizador ");
        System.out.println(localizadorCliente1.toString());

        // Crear un localizador con 2 reservas de hotel y 2 de boletos para el mismo cliente anterior, almacenar e imprimir el resultado.

        Localizador localizador2 =  new Localizador(cliente1);
        localizador2.agregarReserva(new Reserva("Hotel", 2, 30000));
        localizador2.agregarReserva(new Reserva("Hotel", 2, 3453445));
        localizador2.agregarReserva(new Reserva("Boletos", 3, 4538949));
        localizador2.agregarReserva(new Reserva("Boletos", 3, 222222));
        System.out.println("Escenario 2: ");
        System.out.println(localizador2);


        // Crear un localizador con una sola reserva para el mismo cliente.
        Localizador localizador3 = new Localizador(cliente1);
        localizador3.agregarReserva(new Reserva("Comida y transporte", 4, 2300000));

        RepositorioLocalizadores repositorioLocalizadores = new RepositorioLocalizadores();
        repositorioLocalizadores.agregarLocalizador(localizadorCliente1);
        repositorioLocalizadores.agregarLocalizador(localizador2);
        repositorioLocalizadores.agregarLocalizador(localizador3);
        System.out.println(repositorioLocalizadores.toString());




        //System.out.println( "Hello World!" );
    }
}
