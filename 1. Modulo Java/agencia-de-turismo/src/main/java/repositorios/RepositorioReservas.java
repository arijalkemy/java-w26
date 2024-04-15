package repositorios;

import enums.ReservaNombres;
import model.Reserva;

import java.util.HashMap;
import java.util.List;

public class RepositorioReservas {

    private HashMap<ReservaNombres, Reserva> reservaHashMap = new HashMap<>();

    private static RepositorioReservas repositorioReservas;

    private RepositorioReservas(){

        Reserva hotel = new Reserva(ReservaNombres.HOTEL,10);
        Reserva comida = new Reserva(ReservaNombres.COMIDA,10);
        Reserva boletoDeViaje = new Reserva(ReservaNombres.BOLETO_DE_VIAJE,10);
        Reserva transporte = new Reserva(ReservaNombres.TRANSPORTE,10);

        reservaHashMap.put(ReservaNombres.HOTEL,hotel);
        reservaHashMap.put(ReservaNombres.COMIDA,comida);
        reservaHashMap.put(ReservaNombres.BOLETO_DE_VIAJE, boletoDeViaje);
        reservaHashMap.put(ReservaNombres.TRANSPORTE,transporte);
    }
    
    public static RepositorioReservas obtenerInstancia(){
        if(repositorioReservas!=null){
            return repositorioReservas;
        } else {
            repositorioReservas = new RepositorioReservas();
            return repositorioReservas;
        }
    }

    public Reserva obtenerPorNombre(ReservaNombres reservaNombre){
        return reservaHashMap.get(reservaNombre);
    }

    public List<Reserva> obtenerTodas(){
        return reservaHashMap.values().stream().toList();
    }

}
