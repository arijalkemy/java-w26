package org.example;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Supermercado {

    Set<Cliente> listaClientes;
    List<Factura> listaFacturas;

    public Supermercado(Set<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public Supermercado(Set<Cliente> listaClientes, List<Factura> listaFacturas) {
        this.listaClientes = listaClientes;
        this.listaFacturas = listaFacturas;
    }

    public void eliminarClienteSeleccionado (String dni) {
        boolean eliminarOK = listaClientes.removeIf(c -> c.getDni().equals(dni) ? true : false);
        if (eliminarOK) {
            System.out.println("El cliente con el DNI: " + dni + " fue eliminado de la lista");
        } else {
            System.out.println("No existe un cliente con ese DNI en la lista actual");
        }
    }

    public Cliente mostrarCliente(String dni) {
        Cliente clienteSeleccionado = listaClientes.stream()
                .filter(c -> c.getDni().equals(dni)).findAny().orElse(null);
        return clienteSeleccionado;
    }

    public void agregarFactura(Factura factura) {
        Cliente cliente = mostrarCliente(factura.getCliente().getDni());

        if (cliente == null) {
            listaClientes.add(factura.getCliente());
            System.out.println("El cliente no estaba en la lista asi que fue agregado");
        }

        factura.calcularTotal();
        listaFacturas.add(factura);
        System.out.println("Se agrego la factura: " + factura.toString());

    }

    public Set<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(Set<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Factura> getListaFacturas() {
        return listaFacturas;
    }

    public void setListaFacturas(List<Factura> listaFacturas) {
        this.listaFacturas = listaFacturas;
    }

}
