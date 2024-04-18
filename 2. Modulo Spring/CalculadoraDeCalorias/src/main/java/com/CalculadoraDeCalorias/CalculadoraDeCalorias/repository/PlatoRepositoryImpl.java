package com.CalculadoraDeCalorias.CalculadoraDeCalorias.repository;

import com.CalculadoraDeCalorias.CalculadoraDeCalorias.entity.Ingredientes;
import com.CalculadoraDeCalorias.CalculadoraDeCalorias.entity.Plato;
import com.CalculadoraDeCalorias.CalculadoraDeCalorias.repository.interfaces.IIngredientesRepository;
import com.CalculadoraDeCalorias.CalculadoraDeCalorias.repository.interfaces.IPlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlatoRepositoryImpl implements IPlatoRepository {

    @Autowired
    IIngredientesRepository ingredientesRepositoryImpl;
    private List<Plato> listaPlatos;

    public PlatoRepositoryImpl(IIngredientesRepository ingredientesRepositoryImpl) {
        this.ingredientesRepositoryImpl = ingredientesRepositoryImpl;
        listaPlatos = cargarPlatos();
    }

    @Override
    public List<Plato> obtenerPlatos() {
        return this.listaPlatos;
    }

    private List<Plato> cargarPlatos()
    {
        List<Ingredientes> listaIngredientes = ingredientesRepositoryImpl.obtenerListaIngredientes();
        List<Plato> listaPlatos = new ArrayList<>();
        List<Ingredientes> listaIngredientesMilanesa = new ArrayList<>();
        List<Ingredientes> listaIngredientesPizza = new ArrayList<>();

        listaIngredientesMilanesa.add(listaIngredientes.stream().filter(x->x.getName().toLowerCase().equals("ternera")).findFirst().orElse(null));
        listaIngredientesMilanesa.add(listaIngredientes.stream().filter(x->x.getName().toLowerCase().equals("yema")).findFirst().orElse(null));
        listaIngredientesMilanesa.add(listaIngredientes.stream().filter(x->x.getName().toLowerCase().equals("harina")).findFirst().orElse(null));


        listaIngredientesPizza.add(listaIngredientes.stream().filter(x->x.getName().toLowerCase().equals("queso mozzarella")).findFirst().orElse(null));
        listaIngredientesPizza.add(listaIngredientes.stream().filter(x->x.getName().toLowerCase().equals("yema")).findFirst().orElse(null));
        listaIngredientesPizza.add(listaIngredientes.stream().filter(x->x.getName().toLowerCase().equals("harina")).findFirst().orElse(null));
        listaIngredientesPizza.add(listaIngredientes.stream().filter(x->x.getName().toLowerCase().equals("salsa de tomate en conserva")).findFirst().orElse(null));

        listaPlatos.add(new Plato("Milanesa",listaIngredientesMilanesa,2));
        listaPlatos.add(new Plato("Pizza",listaIngredientesPizza,5));
        return  listaPlatos;
    }
}
