package org.example.Service;

import org.example.Class.Cliente;
import org.example.Repository.ClienteRepository;

public class ClienteService {

    ClienteRepository clienteRepo = new ClienteRepository();

    public boolean existeCliente(String dni){
        Cliente c = clienteRepo.getByDni(dni);
        if (c != null){
            return  true;
        }
        return false;
    }

    public void crearCliente(Cliente cliente){
        clienteRepo.agregar(cliente);
        System.out.println("Cliente agregado con exito");
    }


}
