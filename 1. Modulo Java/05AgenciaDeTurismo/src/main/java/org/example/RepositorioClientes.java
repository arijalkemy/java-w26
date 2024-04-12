package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioClientes {
    HashMap<String, ArrayList<Localizador>> localizadores;

    public RepositorioClientes() {
        this.localizadores = new HashMap<String, ArrayList<Localizador>>();
    }

    public ArrayList<Localizador> buscarPorDNI(String dni) {
        return this.localizadores.get(dni);
    }

    public int contarPorDNI(String dni) {
        ArrayList<Localizador> localizadores = this.localizadores.get(dni);
        if (localizadores == null) {
            return 0;
        }
        return localizadores.size();
    }

    public void guardar(Localizador localizador) {
        String dniCliente = localizador.getCliente().getDNI();
        ArrayList<Localizador> existentes = this.buscarPorDNI(dniCliente);

        if (existentes == null || existentes.isEmpty()) {
            ArrayList<Localizador> nuevosLocalizadores = new ArrayList<>();
            nuevosLocalizadores.add(localizador);
            this.localizadores.put(dniCliente, nuevosLocalizadores);
        } else {
            ArrayList<Localizador> actuales = this.localizadores.get(dniCliente);
            actuales.add(localizador);
            this.localizadores.put(dniCliente, actuales);
        }
    }

    public ArrayList<Localizador> obtenerLocalizadores() {
        // Flatten de la lista de listas
        return (ArrayList<Localizador>)this.localizadores.values().stream().flatMap(Collection::stream).toList();
    }
}
