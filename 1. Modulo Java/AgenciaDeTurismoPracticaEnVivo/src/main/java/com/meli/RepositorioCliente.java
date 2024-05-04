package com.meli;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositorioCliente {

    private Map<String, List<Localizador>> clientes;

    public RepositorioCliente() {
        clientes = new HashMap<>();
    }


    public void agregarLocalizador(String cliente, Localizador localizador) {
        if (clientes.containsKey(cliente)) {
            clientes.get(cliente).add(localizador);
        } else {
            List<Localizador> localizadores = new ArrayList<>();
            localizadores.add(localizador);
            clientes.put(cliente, localizadores);
        }
    }

    public List<Localizador> obtenerLocalizadores(String cliente) {
        return clientes.get(cliente);
    }

    public boolean clienteExistente(String cliente) {
        return clientes.containsKey(cliente);
    }


}
