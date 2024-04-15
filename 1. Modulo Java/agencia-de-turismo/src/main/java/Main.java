import enums.ReservaNombres;
import model.Cliente;
import model.Localizador;
import model.Reserva;
import repositorios.RepositorioCliente;
import repositorios.RepositorioReservas;
import servicios.Contabilidad;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // tuve que implementar singleton para los repositorios para no perder los objetos guardados
        RepositorioCliente repositorioCliente = RepositorioCliente.obtenerInstancia();
        RepositorioReservas repositorioReservas = RepositorioReservas.obtenerInstancia();

        Reserva hotel = repositorioReservas.obtenerPorNombre(ReservaNombres.HOTEL);
        Reserva comida = repositorioReservas.obtenerPorNombre(ReservaNombres.COMIDA);
        Reserva boletoDeViaje = repositorioReservas.obtenerPorNombre(ReservaNombres.BOLETO_DE_VIAJE);
        Reserva transporte = repositorioReservas.obtenerPorNombre(ReservaNombres.TRANSPORTE);

        Cliente nacho = new Cliente("Nacho", "Ruiz Diaz", "44080739");


        System.out.println("LOCALIZADOR COMPLETO, VALOR ESPERADO: 36 ");
        Localizador localizadorCompleto = new Localizador(Arrays.asList(hotel,comida,boletoDeViaje,transporte));

        repositorioCliente.guardarLocalizador(nacho,localizadorCompleto);


        System.out.println();
        System.out.println("LOCALIZADOR CON 2 RESERVAS DE HOTELES, VALOR ESPERADO: 29");
        Localizador localizadorReservas = new Localizador(Arrays.asList(hotel,hotel,comida));

        repositorioCliente.guardarLocalizador(nacho,localizadorReservas);

        System.out.println();
        System.out.println("LOCALIZADOR CON MAS DE 2 RESERVAS PARA EL MISMO CLIENTE, VALOR ESPERADO: 19");
        Localizador localizadorConMasDeDosReservas = new Localizador(Arrays.asList(hotel,comida));

        repositorioCliente.guardarLocalizador(nacho,localizadorConMasDeDosReservas);

        System.out.println();
        System.out.println("---DESCUENTOS ACUMULATIVOS---");

        Cliente joaquin = new Cliente("Joaquin", "Ruiz Diaz", "44080739");

        System.out.println("LOCALIZADOR COMPLETO CON DOS RESERVAS DE HOTEL, VALOR ESPERADO: 44,1");
        Localizador localizadorCompletoCon2ReservasHotel = new Localizador(Arrays.asList(hotel,hotel,comida,boletoDeViaje,transporte));
        repositorioCliente.guardarLocalizador(joaquin,localizadorCompletoCon2ReservasHotel);

        System.out.println("CLIENTES");
        System.out.println(repositorioCliente.obtenerTodosLosClientes());



        System.out.println();
        System.out.println("--CONTABILIDAD--");

        Contabilidad contabilidad = new Contabilidad();

        System.out.println();
        System.out.println("TOTAL DE LOCALIZADORES VENDIDOS: " + contabilidad.obtenerCantidadLocalizadoresVendidos());

        System.out.println();
        System.out.println("CANTIDAD TOTAL DE RESERVAS: " + contabilidad.obtenerCantidadDeReservas());

        System.out.println();
        System.out.println("TOTAL DE VENTAS: " + contabilidad.totalDeVentas());

        System.out.println();
        System.out.println("PROMEDIO DE VENTAS: " + contabilidad.promedioTotalDeVentas());


    }
}
