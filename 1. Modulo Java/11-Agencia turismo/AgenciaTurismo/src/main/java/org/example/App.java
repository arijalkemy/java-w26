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
        Repositorio repositorioLocalizadores = new Repositorio();

        Hotel hotelEnCancun = new Hotel(1, "Cancun", 2000);
        Comida comida = new Comida(1, "Restaurant en Cancun", 50);
        Boletos boletos = new Boletos(1, "Boletos a Cancun", 200);
        Transporte transporte = new Transporte(1, "Colectivo", 100);

        Hotel hotelEnTulum = new Hotel(2, "Tulum", 3000);
        Boletos boletosTulum = new Boletos(2, "Boletos a Tulum", 200);

        Cliente clienteACancun = new Cliente("Maca");

        Localizador localizadorCancun = new Localizador(clienteACancun, List.of(hotelEnCancun, comida, boletos,transporte));
        System.out.println(localizadorCancun);
        boolean descuentoFuturo = repositorioLocalizadores.agregarLocalizador(localizadorCancun);

        Localizador localizadorTulum = new Localizador(clienteACancun,
                List.of(hotelEnCancun, boletos, boletosTulum, hotelEnTulum));
        descuentoFuturo = repositorioLocalizadores.agregarLocalizador(localizadorTulum);
        System.out.println("TULUM");
        System.out.println(localizadorTulum);

        Localizador unaSolaReserva = new Localizador(clienteACancun, List.of(boletosTulum));
        repositorioLocalizadores.agregarLocalizador(unaSolaReserva);

    }
}
