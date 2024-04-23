package org.bootcamp.repository;

import org.bootcamp.domain.Localizador;

import java.util.*;

public class LocalizadorRepository implements IGeneric<Localizador> {

    private static List<Localizador> localizadores;

    public LocalizadorRepository() {
        localizadores = new ArrayList<>();
    }

    @Override
    public Localizador guardar(Localizador objeto) {
        if(localizadores.contains(objeto)){
            int posicionOnjeto = localizadores.indexOf(objeto);
            localizadores.set(posicionOnjeto, objeto);
        }else{
            localizadores.add(objeto);
        }
        System.out.println(objeto.toString());
        return objeto;
    }

    @Override
    public Localizador buscar(int id) {
        return localizadores.get(id);
    }

    public List<Localizador> obtenerTodos(){
        return localizadores;
    }
}
