package org.example.supermercado.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.example.Cliente;
import org.example.factura.Factura;
import org.example.supermercado.ISupermercado;


public class SupermercadoImpl implements ISupermercado {

    private List<Cliente> clientes;

    private List<Factura> facturas;

    public SupermercadoImpl() {
        this.clientes = new ArrayList<>();
        this.facturas = new ArrayList<>();
    }

    public SupermercadoImpl(List<Cliente> clientes, List<Factura> facturas) {
        this.clientes = clientes;
        this.facturas = facturas;
    }

    public Optional<Cliente> getCliente(int dni){
        return clientes.stream()
                .filter(cliente -> cliente.getDni() == dni)
                .findFirst();
    }

    public void getClientes(){
        System.out.println("##### CLIENTES #####");
        clientes.stream()
                .map(cliente -> cliente.getNombre() + " " + cliente.getApellido() + " - DNI: " + cliente.getDni())
                .forEach(System.out::println);
    }

    public void addCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public void addFactura(Factura factura){
        facturas.add(factura);
    }

    public void addFacturaACliente(Factura factura, Cliente cliente){

        Optional<Cliente> clienteEncontrado = clientes.stream()
                .filter(x -> x.getDni() == cliente.getDni())
                .findFirst();

         if (!clienteEncontrado.isPresent()) {
            clientes.add(cliente);
            System.out.println("##### CLIENTE AGREGADO #####");
         }
    }

    public Cliente updateCliente(Cliente cliente){

        return cliente;
    }

    public void deleteCliente(Cliente cliente){
        clientes.remove(cliente);
    }


}
