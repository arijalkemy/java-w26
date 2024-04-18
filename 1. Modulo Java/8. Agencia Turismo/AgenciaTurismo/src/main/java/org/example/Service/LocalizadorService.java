package org.example.Service;

import org.example.Class.Cliente;
import org.example.Class.Localizador;
import org.example.Class.Reserva;
import org.example.Repository.ClienteRepository;
import org.example.Repository.LocalizadorRepository;

import java.util.List;

public class LocalizadorService {

    LocalizadorRepository localizadorRepo = new LocalizadorRepository();
    ClienteService clienteService = new ClienteService();

    public String crear(Cliente cliente, List<Reserva> listReserva){

        if (!clienteService.existeCliente(cliente.getDni())){
            clienteService.crearCliente(cliente);
        }
        Localizador localizador = new Localizador(cliente,listReserva);
        localizadorRepo.agregar(localizador);


    }

}
