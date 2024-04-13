package org.example;

import java.util.*;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        Agencia agencia = new Agencia();

        /*
        * Parte 1
         */
        //Localizador completo para un cliente, imprimir resultado
        Cliente cliente1 = new Cliente("Luis", "Perez", 15);
        Localizador localizador1 = new Localizador(cliente1, new HashSet<>(
                Arrays.asList(new Reserva(TipoReserva.HOT, 300),
                              new Reserva(TipoReserva.COM, 350),
                              new Reserva(TipoReserva.BOL, 400),
                              new Reserva(TipoReserva.TRANS, 500))
        ));
        Repositorio repositorio1 = new Repositorio(localizador1);
        agencia.agregarCliente(cliente1,new ArrayList<>(Arrays.asList(repositorio1)));


        //Crea un localizador con 2 reservas de hotel y 2 de boletos para el mismo cliente anterior,
        //almacenar e imprimir el resultado.
        Localizador localizador2 = new Localizador(cliente1, new HashSet<>(
                Arrays.asList(new Reserva(TipoReserva.HOT, 500),
                              new Reserva(TipoReserva.HOT, 600),
                              new Reserva(TipoReserva.BOL, 300),
                              new Reserva(TipoReserva.BOL, 300))
        ));
        Repositorio repositorio2 = new Repositorio(localizador2);
        agencia.agregarRepositorio(cliente1, repositorio2);


        //Crea un localizador con una sola reserva para el mismo cliente
        Localizador localizador3 = new Localizador(cliente1, new HashSet<>(
                Arrays.asList(new Reserva(TipoReserva.TRANS, 250))
        ));
        agencia.agregarRepositorio(cliente1, new Repositorio(localizador3));


        //Verificar que los descuentos fueron aplicados
        System.out.println(agencia.getLocalizadoresToString(cliente1));

        /*
        * Parte 2
         */
        System.out.println("");
        //Cantidad de localizadores vendidos.
        System.out.println("Cantidad de localizadores vendidos " + agencia.numeroDeLocalizadores());
        System.out.println("");

        //Cantidad total de reservas.
        System.out.println("Cantidad total de reservas: " + agencia.numeroDeReservas());
        System.out.println("");


        //Obtener un diccionario de todas las reservas clasificados por tipo (hotel, boleto,comida,transporte).
        System.out.println(agencia.mostrarReservasPorTipo());

        //Total de ventas
        System.out.println("Total de ventas: " + agencia.getTotalVentas());
        System.out.println("");

        //Promedio de todas las ventas
        System.out.println("Promedio de ventas: " + agencia.promedioDeVentas());

    }
}
