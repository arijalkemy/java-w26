package bootcamp.agenciaTurismo.repositorios;

import java.util.List;

import bootcamp.agenciaTurismo.localizador.Localizador;
import bootcamp.agenciaTurismo.localizador.Reserva;

import java.util.ArrayList;

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
