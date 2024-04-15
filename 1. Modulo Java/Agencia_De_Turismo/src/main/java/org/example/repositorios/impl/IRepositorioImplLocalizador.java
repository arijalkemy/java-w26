package org.example.repositorios.impl;

import org.example.entidades.Localizador;
import org.example.repositorios.IRepositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class IRepositorioImplLocalizador implements IRepositorio<Localizador> {
    List<Localizador> localizadorList = new ArrayList<>();
    @Override
    public void agregar(Localizador elem) {
        localizadorList.add(elem);
    }

    @Override
    public Optional<Localizador> encontrar(Integer id) {
        return this.localizadorList.stream()
                .filter(e-> e.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Localizador> encontrarTodos() {
        return this.localizadorList;
    }
}
