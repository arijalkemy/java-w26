package bootcamp.bendezujonathan;

import java.util.List;

import bootcamp.bendezujonathan.agencia.Agencia;
import bootcamp.bendezujonathan.cliente.Cliente;
import bootcamp.bendezujonathan.localizador.Localizador;
import bootcamp.bendezujonathan.localizador.Producto;
import bootcamp.bendezujonathan.localizador.Reserva;
import bootcamp.bendezujonathan.localizador.TiposProducto;
import bootcamp.bendezujonathan.repositorios.RepositorioLocalizador;


public class App {
    public static void main( String[] args )
    {
        Agencia agencia = new Agencia(1, "travvvel", RepositorioLocalizador.findAll(), 0.95, 2);
        Cliente igna = new Cliente(1, "Igna", "Perez");
        Reserva reserva = new Reserva(1, "Una reserva",  new Producto(1D, TiposProducto.HOTEL), 1.0, 2);
        Reserva reserva1 = new Reserva(1, "Una reserva",  new Producto(1D, TiposProducto.HOTEL), 1.0, 2);

        Localizador primero = agencia.agregarLocalizador(igna, List.of(reserva, reserva1));
        RepositorioLocalizador.add(primero);

        Reserva reserva2 = new Reserva(1, "Una reserva",  new Producto(1D, TiposProducto.VUELOS), 1.0, 2);
        Localizador segundo = agencia.agregarLocalizador(igna, List.of(reserva2));
        RepositorioLocalizador.add(segundo);
    }
}
