package org.example.repository;

import org.example.model.Localizador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositorioLocalizador implements Repositorio<Localizador,Integer> {
    private List<Localizador> listaLocalizadores;

    public RepositorioLocalizador() {
        listaLocalizadores = new ArrayList<>();
    }

    @Override
    public void add(Localizador item) {
        listaLocalizadores.add(item);
    }

    @Override
    public List<Localizador> findAll() {
        return listaLocalizadores;
    }

    @Override
    public Optional<Localizador> findById(Integer id) {
        return listaLocalizadores.stream().filter(l -> l.getId() == id).findFirst();
    }

    @Override
    public Boolean existsById(Integer id) {
        return listaLocalizadores.stream().anyMatch(l-> l.getId() == id);
    }
    public List<Localizador> findByIdCliente(Integer idCliente) {
        return listaLocalizadores.stream().filter(l -> l.getCliente().getId() == idCliente).toList();
    }
}
