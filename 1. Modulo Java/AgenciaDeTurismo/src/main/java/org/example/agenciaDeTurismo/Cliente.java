package org.example.agenciaDeTurismo;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private List<Localizador> localizadores = new ArrayList<>();

    public Cliente() {
    }

    public void addLocalizadores(Localizador localizador) {
        localizadores.add(localizador);
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "Datos..." +
                '}';
    }
}
