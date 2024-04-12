package org.bootcamp.repository;

import org.bootcamp.domain.Cliente;
import org.bootcamp.domain.Localizador;

import java.util.ArrayList;
import java.util.List;

public class LocalizadorRepository implements IGeneric<Localizador> {

    private List<Localizador> localizadores;

    public LocalizadorRepository() {
        this.localizadores = new ArrayList<>();
    }

    @Override
    public Localizador guardar(Localizador objeto) {
        return null;
    }

    @Override
    public Localizador buscar(int id) {
        return null;
    }

    public List<Localizador> getByCliente (Cliente cliente){

        return null;
    }
}
