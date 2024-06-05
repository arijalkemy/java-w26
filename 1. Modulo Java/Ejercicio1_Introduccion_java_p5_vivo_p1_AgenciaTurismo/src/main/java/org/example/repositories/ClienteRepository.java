package org.example.repositories;

import org.example.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository extends Repository <Cliente>{

    @Override
    public Cliente agregar(Cliente dato) {
        Cliente cliente = baseDeDatos.clienteByDNI(dato.getDni());
        if (cliente == null) {
            dato.setCantLocalizadores(0);
            baseDeDatos.agregarCliente(dato.getDni(), dato);
            return dato;
        }
        return cliente;
    }

    @Override
    public List<Cliente> getObjetos() {
        return new ArrayList<>(baseDeDatos.getClientes().values());
    }

    @Override
    public void actualizar(Cliente dato) {
        baseDeDatos.actualizarCliente(dato.getDni());
    }
}
