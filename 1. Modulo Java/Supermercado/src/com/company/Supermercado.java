package com.company;

import java.util.HashSet;

public class Supermercado {
    private HashSet<Cliente> clientes;
    private HashSet<Factura> facturas;

    public Supermercado() {
        clientes = new HashSet<>();
        facturas = new HashSet<>();
    }

    public HashSet<Cliente> getClientes() {
        return clientes;
    }

    public HashSet<Factura> getFacturas() {
        return facturas;
    }

    public void registrarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public void registrarCompra(Cliente cliente, Item[] compras){
        facturas.add(new Factura(cliente, compras));
    }

    public void eliminarCliente(Cliente cliente){
        clientes.remove(cliente);
        facturas.removeIf(factura -> factura.getCliente().equals(cliente));
    }

    public void mostrarClientes(){
        clientes.forEach(cliente -> System.out.println(cliente.toString()));
    }

    public void buscarClientePorDNI(String dni){
        Cliente clienteFiltrado = clientes.stream().filter(cliente -> cliente.getDni().equals(dni)).findFirst().orElse(null);
        if(clienteFiltrado != null){
            System.out.println(clienteFiltrado.toString());
        } else{
            System.out.println("No se encontró al cliente.");
        }
    }
}
