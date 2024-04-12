package org.bootcamp;

import org.bootcamp.domain.Cliente;
import org.bootcamp.domain.Localizador;
import org.bootcamp.domain.Reserva;
import org.bootcamp.repository.ClienteRepository;
import org.bootcamp.repository.LocalizadorRepository;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        // Se instancia los repositorios
        LocalizadorRepository localizadorRepository = new LocalizadorRepository();
        ClienteRepository clienteRepository = new ClienteRepository();

        // Se instancia los objetos
        Cliente cliente1 = new Cliente(1, "Juan", "perez");
        Cliente cliente2 = new Cliente(2, "Juana", "perez");
        Reserva reserva1 = new Reserva(true, false, false, true);
        double valor1 = reserva1.getValor();
        Reserva reserva2 = new Reserva(false, false, false, true);
        double valor2 = reserva2.getValor();
        Localizador localizador1 = new Localizador(cliente1, Arrays.asList(reserva1, reserva2), valor1 + valor2);
        Localizador localizador2 = new Localizador(cliente2, Arrays.asList(reserva1, reserva2), valor1 + valor2);
        Localizador localizador3 = new Localizador(cliente2, Arrays.asList(reserva1, reserva2), valor1 + valor2);

        clienteRepository.guardar(cliente1);
        clienteRepository.guardar(cliente2);
        localizadorRepository.guardar(localizador1);
        localizadorRepository.guardar(localizador2);
        localizadorRepository.guardar(localizador3);





    }
}
