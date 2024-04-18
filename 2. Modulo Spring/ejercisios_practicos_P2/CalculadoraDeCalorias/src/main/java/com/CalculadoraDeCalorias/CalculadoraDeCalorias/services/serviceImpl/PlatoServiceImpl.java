package com.CalculadoraDeCalorias.CalculadoraDeCalorias.services.serviceImpl;

import com.CalculadoraDeCalorias.CalculadoraDeCalorias.dto.IngredienteDTO;
import com.CalculadoraDeCalorias.CalculadoraDeCalorias.dto.PlatoCaloriasDTO;
import com.CalculadoraDeCalorias.CalculadoraDeCalorias.dto.PlatoIngredientesDTO;
import com.CalculadoraDeCalorias.CalculadoraDeCalorias.entity.Ingredientes;
import com.CalculadoraDeCalorias.CalculadoraDeCalorias.entity.Plato;
import com.CalculadoraDeCalorias.CalculadoraDeCalorias.repository.interfaces.IPlatoRepository;
import com.CalculadoraDeCalorias.CalculadoraDeCalorias.services.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PlatoServiceImpl implements IPlatoService {
    @Autowired
    IPlatoRepository platoRepositoryImpl;

    @Override
    public int obtenerPlato(String nombre) {
        int calorias = 0;
        Plato plato = platoRepositoryImpl.obtenerPlatos().stream().filter(x -> x.getNombre().toLowerCase().equals(nombre.toLowerCase())).findFirst().orElse(null);

        calorias = plato.getListaIngredientes().stream().filter(Objects::nonNull).mapToInt(x -> x.getCalories()).sum();

        return calorias;

    }

    @Override
    public List<PlatoIngredientesDTO> obtenerListaIngredientes(String nombre) {
        Plato plato = platoRepositoryImpl.obtenerPlatos().stream().filter(x -> x.getNombre().toLowerCase().equals(nombre.toLowerCase())).findFirst().orElse(null);
        System.out.println(plato);
        List<PlatoIngredientesDTO> platodebug  = plato.getListaIngredientes().stream().filter(Objects::nonNull).map(i -> new PlatoIngredientesDTO(i.getName(), i.getCalories())).toList();
        System.out.println(platodebug);
        return plato.getListaIngredientes().stream().filter(Objects::nonNull).map(i -> new PlatoIngredientesDTO(i.getName(), i.getCalories())).toList();
    }

    @Override
    public IngredienteDTO obtenerIngredienteMayorCaloria(String nombre) {
        Plato plato = platoRepositoryImpl.obtenerPlatos().stream().filter(x -> x.getNombre().toLowerCase().equals(nombre.toLowerCase())).findFirst().orElse(null);
        Ingredientes ingrediente = plato.getListaIngredientes().stream().filter(Objects::nonNull).max(Comparator.comparingInt(Ingredientes::getCalories)).orElse(null);

        return new IngredienteDTO(ingrediente.getName(), ingrediente.getCalories());
    }
}
