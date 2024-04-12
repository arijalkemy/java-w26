package org.bootcamp.repository;

import org.bootcamp.domain.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository implements IGeneric<Cliente> {

    private List<Cliente> clientes;
    private int contadorId = 0;

    public ClienteRepository() {
        this.clientes = new ArrayList<>();
    }


    @Override
    public Cliente guardar(Cliente objeto) {
        if(buscar(objeto.getDni()) == null){

        }
        for(Cliente cliente : clientes){
            if(cliente.getDni() == objeto.getDni()){

            }
        }
        return null;
    }

    @Override
    public Cliente buscar(int id) {
        for(Cliente cliente:clientes){
            if(cliente.getDni() == id){

            }
        }
        return null;
    }
}
