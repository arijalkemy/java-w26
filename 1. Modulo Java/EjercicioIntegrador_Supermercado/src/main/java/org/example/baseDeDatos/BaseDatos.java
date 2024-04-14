package org.example.baseDeDatos;

import org.example.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseDatos {

    private static BaseDatos bd;
    private Map<Integer, Cliente> clientes = new HashMap<>();
    private List<Factura> facturas = new ArrayList<>();

    public void agregarCliente(Cliente cliente) {
        clientes.put(cliente.getDni(), cliente);
    }

    public void agregarFactura(Factura factura) {
        facturas.add(factura);
    }

    public Cliente clienteById(Integer dni) {
        if (clientes.containsKey(dni)) {
            return clientes.get(dni);
        }
        return null;
    }

    public Cliente eliminarCliente(Integer dni) {
        Cliente cliente = clientes.get(dni);
        clientes.remove(dni);
        return cliente;
    }

    public List<Cliente> getClientes() {
        return new ArrayList<>(clientes.values());
    }

    public List<Factura> getFacturas() {
        return facturas;
    }


    private BaseDatos() {
    }

    public static BaseDatos getBaseDatos() {
        if (bd == null) {
            bd = new BaseDatos();
        }
        return bd;
    }


}
