package com.company;

import java.util.HashSet;
import java.util.List;

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

    public Cliente registrarCliente(Cliente cliente){
        if(clientes.stream().noneMatch(cliente1 -> cliente1.getDni().equals(cliente.getDni()))){
            clientes.add(cliente);
            System.out.println("Cliente creado con éxito");
        } else{
            System.out.println("El cliente ya existe");
        }
        return cliente;
    }

    public void registrarCompra(Cliente cliente, List<Item> compras){
        if(!clientes.contains(cliente)){
            clientes.add(cliente);
            System.out.println("Agregando cliente...");
        }
        Factura factura = new Factura(cliente, compras);
        facturas.add(factura);
        System.out.println("Factura aceptada con éxito, total = " + factura.getTotal());
    }

    public void eliminarCliente(Cliente cliente){
        clientes.remove(cliente);
        facturas.removeIf(factura -> factura.getCliente().equals(cliente));
    }

    public void mostrarClientes(){
        clientes.forEach(cliente -> System.out.println(cliente.toString()));
    }

    public Cliente buscarClientePorDNI(String dni){
        Cliente clienteFiltrado = clientes.stream().filter(cliente -> cliente.getDni().equals(dni)).findFirst().orElse(null);
        if(clienteFiltrado != null){
            System.out.println(clienteFiltrado);
        } else{
            System.out.println("No se encontró al cliente.");
        }
        return clienteFiltrado;
    }
}
