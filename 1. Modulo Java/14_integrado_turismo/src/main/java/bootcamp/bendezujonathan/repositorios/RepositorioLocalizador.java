package bootcamp.bendezujonathan.repositorios;

import java.util.List;
import java.util.ArrayList;

import bootcamp.bendezujonathan.localizador.Localizador;
import bootcamp.bendezujonathan.localizador.Reserva;

public class RepositorioLocalizador {

    private static List<Localizador> localizadores = new ArrayList<>();

    private RepositorioLocalizador() {

    }

    public static void add(Localizador entity) {
        localizadores.add(entity);
        System.out.println("Reserva Realizada");
        System.out.println(entity);
    }

    public static List<Localizador> findAll() {
        return localizadores;
    }

    public static List<Reserva> findReservasByClientId(int clientId) {
        return localizadores.stream()
                .filter(localizador -> localizador.getCliente().getId() == clientId).findFirst()
                .map(Localizador::getReservas)
                .orElse(List.of());
    }

}
