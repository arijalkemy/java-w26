package org.example;

import org.example.bonus.RepositorioCliente;
import org.example.bonus.RepositorioFactura;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Supermercado {

    RepositorioCliente repoCli;
    RepositorioFactura repoFactura;

    public Supermercado(RepositorioCliente repoCli, RepositorioFactura repoFactura) {
        this.repoCli = repoCli;
        this.repoFactura = repoFactura;
    }

    public void eliminarClienteSeleccionado (String dni) {
        repoCli.baja(dni);
    }

    public Cliente mostrarCliente(String dni) {
        return repoCli.buscar(dni);
    }

    public void agregarFactura(Factura factura) {
        Cliente cliente = mostrarCliente(factura.getCliente().getDni());
        if (cliente == null) {
            repoCli.alta(factura.getCliente());
            System.out.println("El cliente no estaba en la lista asi que fue agregado");
        }
        repoFactura.alta(factura);
    }

    public void mostrarClientes() {
        repoCli.mostrarLista();
    }


}
