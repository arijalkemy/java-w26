package org.example.ejercicio_integrador_parte_1_y_2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Supermercado {
    private String nombre;
    private List<Client> clientes;
    private List<Factura> facturas;

    public Supermercado(String nombre) {
        this.nombre = nombre;
        this.clientes = new ArrayList<>();
        this.facturas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Client> getClientes() {
        return clientes;
    }

    public void setClientes(List<Client> clientes) {
        this.clientes = clientes;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public void mostrarDatosDeClientes() {
        clientes.stream().forEach(System.out::println);
    }

    public void eliminarCliente(Client cliente) {
        clientes = clientes.stream().filter(client -> !client.getDni().equals(cliente.getDni())).collect(Collectors.toList()); //.collect(Collectors.toCollection(ArrayList::new));
    }

    public void buscarCliente(String dni) {
        for(Client cliente : clientes) {
            if(cliente.getDni().equals(dni)) {
                System.out.println(cliente.toString());
                return;
            }
        }
        System.out.println("El Cliente con DNI " + dni + " no se encuentra en la base de datos.");
    }

    public void agregarFactura(Factura factura) {
        boolean clienteEncontrado = false;
        for(Client cliente : clientes) {
            if(cliente.getDni().equals(factura.getCliente().getDni())) {
                clienteEncontrado = true;
                break;
            }
        }
        if(!clienteEncontrado) {
            clientes.add(factura.getCliente());
        }
        facturas.add(factura);
    }
}
