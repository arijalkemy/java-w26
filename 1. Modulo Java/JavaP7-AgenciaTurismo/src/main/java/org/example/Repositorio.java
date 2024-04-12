package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Repositorio {
    List<Localizador> localizadores = new ArrayList<>();

    public Repositorio() {
    }

    public void addLocalizadores(Localizador localizador) {
        this.localizadores.add(localizador);
    }

    public ArrayList<Localizador> filterCliente(Cliente cliente){
        return this.localizadores.stream().filter(l-> l.getCliente().getDni() == cliente.getDni())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public String toString() {
        return "Repositorio{" +
                "localizadores=\t\n" + localizadores +
                '}';
    }
}
