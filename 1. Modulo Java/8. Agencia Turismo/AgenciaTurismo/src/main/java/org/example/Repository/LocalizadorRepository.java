package org.example.Repository;

import org.example.Class.Localizador;

import java.util.ArrayList;
import java.util.List;

public class LocalizadorRepository {

    private static List<Localizador> localizadoresList = new ArrayList<Localizador>();

    public void agregar(Localizador localizador){
        localizadoresList.add(localizador);
    }


}
