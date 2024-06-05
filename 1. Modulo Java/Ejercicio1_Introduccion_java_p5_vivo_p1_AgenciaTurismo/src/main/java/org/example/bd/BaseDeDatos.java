package org.example.bd;

import org.example.Cliente;
import org.example.Localizador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseDeDatos {

    private static BaseDeDatos baseDeDatos = new BaseDeDatos();

    private BaseDeDatos() {
    }

    public static BaseDeDatos getBaseDeDatos() {
        return baseDeDatos;
    }

    private Map<String, Cliente> clientes = new HashMap<>();
    private List<Localizador> localizadores = new ArrayList<>();

    public Map<String, Cliente> getClientes() {
        return clientes;
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void agregarCliente(String dni, Cliente cliente) {
        clientes.put(dni, cliente);
    }

    public void agregarLocalizador(Localizador localizador) {
        localizadores.add(localizador);
    }

    public Cliente clienteByDNI(String dni) {
        if (clientes.containsKey(dni)) {
            return clientes.get(dni);
        }
        return null;
    }

    public void actualizarCliente(String dni) {
        Cliente cliente = clientes.get(dni);
        cliente.aumentarCantidadLocalizadores();
        clientes.put(dni, cliente);
    }

}
