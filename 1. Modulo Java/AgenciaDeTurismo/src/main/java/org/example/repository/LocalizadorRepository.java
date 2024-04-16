package org.example.repository;

import org.example.model.Localizador;

import java.util.ArrayList;
import java.util.List;

public class LocalizadorRepository {

    private List<Localizador> localizadores = new ArrayList<>();

    public LocalizadorRepository() {

    }

    public void agregarLocalizador(Localizador localizador){
        this.localizadores.add(localizador);
    }

    public void imprimirLocalizadores() {

    }
}
