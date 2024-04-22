package com.example.multicapatemplate.repository.impl;

import com.example.multicapatemplate.model.Plato;
import com.example.multicapatemplate.repository.IRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlatosRepositoryImpl implements IRepository {
    List<Plato> platos;

    public PlatosRepositoryImpl() {
        platos = new ArrayList<>();
    }

    public List<Plato> getPlatos() {
        return platos;
    }

    public void addPlato( Plato plato ){
        platos.add(plato);
    }

    public Plato getPlatoByName( String name ) {
        return platos.stream().filter(x -> x.getNombre().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
}
