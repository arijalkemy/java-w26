package com.example.calorias.repositorios;

import com.example.calorias.DTOs.IngredienteDTO;
import com.example.calorias.DTOs.PlatoDTO;
import com.example.calorias.modelo.Ingrediente;
import com.example.calorias.modelo.Plato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class PlatoRepositorio {
    List<PlatoDTO> platos = new ArrayList<>();

    private final IngredienteRepositorio ingredienteRepositorio;

    public PlatoRepositorio(IngredienteRepositorio ingredienteRepositorio){

        Ingrediente tomate = ingredienteRepositorio.getIngredientePorNombre("Salsa de tomate en conserva");
        Ingrediente queso = ingredienteRepositorio.getIngredientePorNombre("Queso blanco desnatado");
        Ingrediente harina = ingredienteRepositorio.getIngredientePorNombre("Harina de maíz");
        Ingrediente jamon = ingredienteRepositorio.getIngredientePorNombre("Jamón");

        IngredienteDTO tomateConPeso = new IngredienteDTO(tomate.getName(), tomate.getCalories()*200/100, 200);
        IngredienteDTO quesoConPeso =  new IngredienteDTO(queso.getName(), queso.getCalories()*100/100, 100);
        IngredienteDTO harinaConPeso =  new IngredienteDTO(harina.getName(), harina.getCalories()*200/100, 200);
        IngredienteDTO jamonConPeso =  new IngredienteDTO(jamon.getName(), jamon.getCalories()*300/100, 300);

        PlatoDTO pizza = new PlatoDTO(
                "Pizza",
                List.of(tomateConPeso,quesoConPeso,harinaConPeso)
        );

        PlatoDTO pizzaJamon = new PlatoDTO(
                "Pizza con jamon",
                List.of(tomateConPeso,quesoConPeso,harinaConPeso,jamonConPeso)
        );

        platos.add(pizza);
        platos.add(pizzaJamon);
        this.ingredienteRepositorio = ingredienteRepositorio;
    }

    public List<PlatoDTO> getPlatos() {
        return platos;
    }
}
