package org.example;

import java.util.ArrayList;
import java.util.List;

public class ClientesRepository {
    private List<Cliente> clientes;

    public ClientesRepository() {
        this.clientes= new ArrayList<Cliente>();
    }
    public void agregarCliente(Cliente cliente){
        if(this.clientes.contains(cliente)){
            return;
        }
        this.clientes.add(cliente);
    }

    @Override
    public String toString() {
        String resultado= "Listado de clientes :["+"\n";
        for (Cliente cliente:clientes){
            resultado+=cliente.toString()+"\n";
        }
        return resultado;
    }
}
