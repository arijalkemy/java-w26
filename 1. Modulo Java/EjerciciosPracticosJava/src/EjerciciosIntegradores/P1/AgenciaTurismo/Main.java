package EjerciciosIntegradores.P1.AgenciaTurismo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Defino cliente
        Cliente cliente1 = new Cliente(1, "tom", "led");

        Localizador localizadorCliente1;
        Localizador localizadorCliente2;
        Localizador localizadorCliente3;

        //Creo reservas
        Reserva reservaCliente1Hotel = new Reserva(new Hotel("Hotel", "Hotel muy lindo", 1000));
        Reserva reservaCliente1Hotel2 = new Reserva( new Hotel("Hotel", "Hotel muy lindo", 1000));
        Reserva reservaCliente1Vuelo = new Reserva(new Boletos("Vuelo IV", "Viaje ida y vuelta", 1500));
        Reserva reservaCliente1Vuelo2 = new Reserva(new Boletos("Vuelo IV", "Viaje ida y vuelta", 1500));
        Reserva reservaCliente1Transporte = new Reserva(new Transporte("Taxi - Hotel", "Taxi hasta el hotel", 100));
        Reserva reservaCliente1Comida = new Reserva(new Comida("All inclusive", "Todo incluido", 500));

        //Creo una lista de reservas
        List<Reserva> reservas = new ArrayList<>(){
            {
                add(reservaCliente1Hotel);
                add(reservaCliente1Vuelo);
                add(reservaCliente1Transporte);
                add(reservaCliente1Hotel2);
                add(reservaCliente1Vuelo2);
                add(reservaCliente1Comida);
            }
        };

        //Añado un cliente al localizador de clientes
        localizadorCliente1 = new Localizador(cliente1);
        localizadorCliente2 = new Localizador(cliente1);
        localizadorCliente3 = new Localizador(cliente1);

        //Añado reservas al localizador cliente
        for (Reserva reserva : reservas) {
            localizadorCliente1.agregarReserva(reserva);
            localizadorCliente2.agregarReserva(reserva);
            localizadorCliente3.agregarReserva(reserva);
        }

        //Creo el repositorio cliente y agrego el localizador asociado al cliente.
        RepositorioCliente repositorioCliente = new RepositorioCliente();
        repositorioCliente.agregarLocalizador(cliente1.getDni(), localizadorCliente1);
        repositorioCliente.agregarLocalizador(cliente1.getDni(), localizadorCliente2);
        repositorioCliente.agregarLocalizador(cliente1.getDni(), localizadorCliente3);

        repositorioCliente.imprimirLocalizadoresCliente(cliente1.getDni());
    }
}