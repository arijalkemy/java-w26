package com.example;

import java.util.List;
import java.util.ArrayList;

public class Supermercado {
    private List<Cliente> clientes;
    private List<Factura> facturas;

    public Supermercado() {
        this.clientes = new ArrayList<>();
        clientes.add(new Cliente("123", "Pedro", "Perez"));
        clientes.add(new Cliente("456", "Juan", "Fernandez"));
        clientes.add(new Cliente("789", "Nicolas", "Colon"));
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void removerClienteAleatoriamente() {
        this.clientes.remove((int) Math.random() * (clientes.size() - 1));
    }

    public String buscarCliente(String dni) {
        return clientes.stream()
                .filter(x -> x.getDni().equals(dni))
                .findFirst()
                .map(Cliente::toString)
                .orElse("No se encontro el cliente");
    }

    public void cargarFactura(Factura factura) {

        boolean existeCliente = clientes.stream()
                .anyMatch(x -> x.equals(factura.getCliente()));

        if(!existeCliente){
            clientes.add(factura.cliente);
        }
        
        facturas.add(factura);
    }

}
