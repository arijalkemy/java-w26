package org.example;

import java.util.ArrayList;
import java.util.List;

public class RepoLocalizador {

    private List<Localizador> localizadores;

    public RepoLocalizador() {
        localizadores = new ArrayList<>();
    }

    public void imprimirLocalizadores() {

    }
    public void adicionarLocalizador(Localizador localizador) {
        localizadores.add(localizador);
    }
}
