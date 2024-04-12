package org.example;

import java.util.List;

public class LocalizadorRepository {
    private List<Localizador> localizadores;

    public List<Localizador> getAll() {
        return localizadores;
    }

    public void save(Localizador localizador) {
        localizadores.add(localizador);
    }
}
