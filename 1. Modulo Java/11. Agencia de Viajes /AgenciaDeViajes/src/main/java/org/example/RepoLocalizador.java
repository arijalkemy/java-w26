package org.example;

import java.util.ArrayList;
import java.util.List;

public class RepoLocalizador {

    private List<Localizador> localizadores = new ArrayList<>();

    public RepoLocalizador() {

    }



    public void agregarLocalizador(Localizador localizador){
     this.localizadores.add(localizador);
    }

    public void imprimirLocalizadores() {

    }
}
