package org.example;

import java.util.ArrayList;
import java.util.List;

public class Repositorio {

    private List<Localizador> localizadores;

    public Repositorio() {
        this.localizadores = new ArrayList<>();
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }

    public void agregarLocalizador(Localizador localizador) {
        localizadores.add(localizador);
    }
}
