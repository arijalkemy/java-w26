package bootcamp.agenciaTurismo;

import java.util.List;

import bootcamp.agenciaTurismo.agencia.Agencia;
import bootcamp.agenciaTurismo.cliente.Cliente;
import bootcamp.agenciaTurismo.localizador.Localizador;
import bootcamp.agenciaTurismo.localizador.Producto;
import bootcamp.agenciaTurismo.localizador.Reserva;
import bootcamp.agenciaTurismo.localizador.TiposProducto;
import bootcamp.agenciaTurismo.repositorios.RepositorioLocalizador;


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
