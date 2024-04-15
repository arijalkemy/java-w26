package servicios;

import Interfaces.ILocalizador;
import enums.ReservaNombres;
import model.Cliente;
import model.Reserva;
import model.decorators.DescuentoLocalizadorReserva;
import model.decorators.DescuentoLocalizadorTotal;
import repositorios.RepositorioReservas;

import java.util.HashSet;
import java.util.List;

public class ManejadorDeDescuentos {

    public static ILocalizador aplicarDescuentoTotal(ILocalizador localizador, double porcentajeDeDescuento) {
        return new DescuentoLocalizadorTotal(localizador, porcentajeDeDescuento);
    }

    public static ILocalizador aplicarDescuentoAReservasDeHotelOBoleto(ILocalizador localizador) {
        return new DescuentoLocalizadorReserva(localizador);
    }


    public static ILocalizador aplicarDescuentos(Cliente cliente, ILocalizador localizador) {
        ILocalizador localizadorConDescuentos = localizador;

        RepositorioReservas repositorioReservas = RepositorioReservas.obtenerInstancia();

        if (cliente.getLocalizadorList().size() >= 2) {
            localizadorConDescuentos = new DescuentoLocalizadorTotal(localizadorConDescuentos, 5);
        }

        List<Reserva> reservasDelLocalizador = localizador.getReservaList();


        boolean puedeTenerDescuentoPorReservas =
                reservasDelLocalizador
                        .stream()
                        .filter(r -> r.getNombre() == ReservaNombres.HOTEL)
                        .toList()
                        .size() >= 2
                        ||
                        reservasDelLocalizador
                                .stream()
                                .filter(r -> r.getNombre() == ReservaNombres.BOLETO_DE_VIAJE)
                                .toList()
                                .size() >= 2;

        if(puedeTenerDescuentoPorReservas){
            localizadorConDescuentos = new DescuentoLocalizadorReserva(localizadorConDescuentos);
        }

        boolean tienePaqueteCompleto = true;

        List<Reserva> reservas = RepositorioReservas.obtenerInstancia().obtenerTodas();

        for(Reserva reserva: reservas){
            tienePaqueteCompleto = tienePaqueteCompleto && reservasDelLocalizador.stream().anyMatch(r -> r.equals(reserva));
        }

        if(tienePaqueteCompleto){
            localizadorConDescuentos = new DescuentoLocalizadorTotal(localizadorConDescuentos,10);
        }

        return localizadorConDescuentos;

    }
}
