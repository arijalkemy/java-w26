package com.example.multicapatemplate.service.impl;

import com.example.multicapatemplate.model.Ingrediente;
import com.example.multicapatemplate.model.Plato;
import com.example.multicapatemplate.repository.IRepository;
import com.example.multicapatemplate.repository.impl.PlatosRepositoryImpl;
import com.example.multicapatemplate.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class RestauranteServiceImpl implements RestauranteService {

    List<Plato> platos;

    public RestauranteServiceImpl() {
        PlatosRepositoryImpl platosRepo = new PlatosRepositoryImpl();
        this.platos = platosRepo.getPlatos();
    }

    @Override
    public int obtenerCalorias(String plato) {
       Optional<Plato> platosFilter = platos.stream().filter(x -> x.getNombre().equalsIgnoreCase( plato )).findFirst();

       if( platosFilter.isPresent() ) {
           return platosFilter.get().getIngredientes().stream().mapToInt(Ingrediente::getCalorias).sum();
       }else {
           return 0;
       }
    }

    @Override
    public List<Ingrediente> obtenerIngredientes(String plato) {
        Optional<Plato> platosFilter = platos.stream().filter(x -> x.getNombre().equalsIgnoreCase( plato )).findFirst();

        if( platosFilter.isPresent() ) {
            return platosFilter.get().getIngredientes();
        }else {
            return null;
        }
    }

    @Override
    public Ingrediente ingredienteCalorico(String plato) {
        Optional<Plato> platosFilter = platos.stream().filter(x -> x.getNombre().equalsIgnoreCase( plato )).findFirst();

        if( platosFilter.isPresent() ) {
            return platosFilter.get().getIngredientes().stream().max(Comparator.comparingInt(Ingrediente::getCalorias)).get();
        }else {
            return null;
        }
    }
}
