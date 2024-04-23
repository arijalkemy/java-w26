package org.bootcamp;

import org.bootcamp.domain.Cliente;
import org.bootcamp.domain.Localizador;
import org.bootcamp.domain.Reserva;
import org.bootcamp.repository.ClienteRepository;
import org.bootcamp.repository.LocalizadorRepository;
import org.bootcamp.service.impl.LocalizadorServiceImpl;

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
        LocalizadorServiceImpl localizadorService = new LocalizadorServiceImpl();
        ClienteRepository clienteRepository = new ClienteRepository();

        // Se instancia los objetos
        Cliente cliente1 = new Cliente(1, "Juan", "perez");
        Cliente cliente2 = new Cliente(2, "Camilo", "Rodriguez");

        Reserva reservaHotel = new Reserva(false, true, false, false);
        Reserva reservaTransporte = new Reserva(false, false, false, true);
        Reserva reservaTotal = new Reserva(true, true, true, true);
        Reserva reservaComida = new Reserva(false, false, true, false);

        Localizador localizador1 = new Localizador(cliente1, Arrays.asList(reservaHotel, reservaHotel));
        Localizador localizador2 = new Localizador(cliente1, Arrays.asList(reservaTransporte, reservaTransporte));
        Localizador localizador3 = new Localizador(cliente2, Arrays.asList(reservaTotal, reservaHotel));
        Localizador localizador4 = new Localizador(cliente1, Arrays.asList(reservaTotal, reservaComida));

        // Se guardar los clientes y localizadores
        clienteRepository.guardar(cliente1);
        clienteRepository.guardar(cliente2);
        localizadorRepository.guardar(localizador1);
        localizadorRepository.guardar(localizador2);
        localizadorRepository.guardar(localizador3);

        // Se calcula el valor total del localizador
        System.out.println("\n\n*** Validar valor total ***");
        localizadorService.validarDescuento(localizador1);


    }
}
