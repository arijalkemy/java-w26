package com.example.multicapatemplate.service.impl;

import com.example.multicapatemplate.dto.IngredienteDto;
import com.example.multicapatemplate.model.Ingrediente;
import com.example.multicapatemplate.model.Plato;
import com.example.multicapatemplate.repository.impl.IngredientesRepositoryImpl;
import com.example.multicapatemplate.repository.impl.PlatosRepositoryImpl;
import com.example.multicapatemplate.service.RestauranteService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Random;

@Service
public class RestauranteServiceImpl implements RestauranteService {

    PlatosRepositoryImpl platosRepo;
    public RestauranteServiceImpl() throws IOException  {
        this.platosRepo = new PlatosRepositoryImpl();

        IngredientesRepositoryImpl ingredientesRepo = new IngredientesRepositoryImpl();
        List<Ingrediente> ingredientes = ingredientesRepo.getListOfIngredients();

        Plato newPlato = new Plato("Menu1");
        newPlato.addIngrediente(ingredientes.get( new Random().nextInt( ingredientes.size()) ), new Random().nextInt(500));
        newPlato.addIngrediente(ingredientes.get( new Random().nextInt( ingredientes.size()) ), new Random().nextInt(500));
        newPlato.addIngrediente(ingredientes.get( new Random().nextInt( ingredientes.size()) ), new Random().nextInt(500));
        platosRepo.addPlato( newPlato );
    }

    @Override
    public double obtenerCalorias(String plato) {
       Plato findPlato = platosRepo.getPlatoByName( plato );
       if (plato == null) {return 0;}

       return findPlato.calcularCalorias();
    }

    @Override
    public List<IngredienteDto> obtenerIngredientes(String plato) {
        Plato findPlato = platosRepo.getPlatoByName( plato );
        if (plato == null) {return null;}

        return findPlato.getIngredientes().entrySet().stream().map(e ->  new IngredienteDto(((e.getKey().getCalories() * e.getValue()) / 100),  e.getKey().getName() ) ).toList();

    }

    @Override
    public String ingredienteCalorico(String plato) {
        Plato findPlato = platosRepo.getPlatoByName( plato );
        if (plato == null) {return null;}

        Ingrediente ingrediente = findPlato.getMAxCalorias();

        return ingrediente.getName();
    }
}
