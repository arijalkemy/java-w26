package agencia.productos;

import agencia.Localizador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repositorio {
    // Mapeo el dni de un cliente con sus localizadores
    private Map<String, List<Localizador>> diccionarioLocalizadores;

    public Repositorio() {
        this.diccionarioLocalizadores = new HashMap<>();
    }

    public void agregarARepositorio (String dniCliente, Localizador localizador) {
        List<Localizador> list = this.diccionarioLocalizadores.getOrDefault(dniCliente, new ArrayList<>());
        list.add(localizador);
        this.diccionarioLocalizadores.put(dniCliente, list);
    }

    public boolean tiene2OmasLocalizadores (String dniCliente) {
        List<Localizador> list = this.diccionarioLocalizadores.getOrDefault(dniCliente, new ArrayList<>());
        return list.size() >= 2;
    }
}
