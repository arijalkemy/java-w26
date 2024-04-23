package com.mercadolibre.calorias.repository;

import com.mercadolibre.calorias.dto.IngredienteDTO;
import com.mercadolibre.calorias.model.Ingrediente;
import com.mercadolibre.calorias.model.Plato;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IRestauranteRepository {

    //public int CantCalorias(Plato plato);

    //public List<Ingrediente> ingredientes(Plato plato);

    //public Ingrediente ingredienteMasCalorico();

    public List<Ingrediente> verIngredientes();
    public List<Plato> verPlatos();
    public Plato verPlato(String nombre);
}
