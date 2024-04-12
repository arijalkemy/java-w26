package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Supermercado {
    private List<Cliente> clientes;
    private List<Factura> facturas;

    public Supermercado() {
        this.clientes = new ArrayList<Cliente>();
        this.facturas = new ArrayList<Factura>();
    }

    public void buscarPorDNI(int dni){
        Optional<Cliente> cliente = this.clientes.stream().filter( c -> c.getDni() == dni).findFirst();
        if (cliente.isPresent()) {
            System.out.println(cliente.toString());
        } else {
            System.out.println("No se encuentra el cliente con DNI = " + dni);
        }
    }

    public void imprimirClientes(){
        this.clientes.forEach(c -> System.out.println(c.toString()) );
    }

    public void agregar(Cliente cliente){
        this.clientes.add(cliente);
    }

    public void agregar(Factura factura){
        this.facturas.add(factura);
    }

    public void eliminar(Cliente cliente){
        boolean eliminado = this.clientes.remove(cliente);
        if (eliminado) {
            System.out.println("Eliminado correctamente.");
        } else {
            System.out.println("No se encuentra el cliente.");
        }
    }
}
