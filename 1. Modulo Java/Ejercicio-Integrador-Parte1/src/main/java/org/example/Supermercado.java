package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Supermercado {

    List<Cliente> clientes = new ArrayList<>();
    List<Factura> facturas = new ArrayList<>();

    public void comprar(Cliente cliente, List<Item> items){
        Factura factura = new Factura(cliente, items);
        agregarFactura(factura);
    }

    public void agregarFactura(Factura factura){
        if( !buscarClientePorDni(factura.getCliente().getDni()).isPresent() ){
            System.out.println("El cliente no existe");
            System.out.println("Agregando cliente...");
            agregarCliente(factura.getCliente());
        }

        facturas.add(factura);
    }

    public void agregarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public void removerCliente(Cliente cliente){
        clientes.remove(cliente);
    }

    public void listadoDeClientes() {
        System.out.println("Datos de los clientes: ");
        for (Cliente cliente: clientes){
            System.out.println("Dni: " + cliente.getDni()
                + "\nNombre: " + cliente.getNombre()
                + "\nApellido: " + cliente.getApellido()
                + "\n----------------");
        }
    }

    public Optional<Cliente> buscarClientePorDni(String dni){
        return clientes.stream()
                .filter(cliente -> cliente.getDni().equals(dni))
                .findFirst();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
