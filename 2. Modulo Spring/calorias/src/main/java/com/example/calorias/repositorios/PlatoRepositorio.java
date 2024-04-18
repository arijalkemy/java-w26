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
    List<Plato> platos = new ArrayList<>();

    private final IngredienteRepositorio ingredienteRepositorio;

    public PlatoRepositorio(IngredienteRepositorio ingredienteRepositorio){

        Ingrediente tomate = ingredienteRepositorio.getIngredientePorNombre("Salsa de tomate en conserva");
        Ingrediente queso = ingredienteRepositorio.getIngredientePorNombre("Queso blanco desnatado");
        Ingrediente harina = ingredienteRepositorio.getIngredientePorNombre("Harina de maíz");
        Ingrediente jamon = ingredienteRepositorio.getIngredientePorNombre("Jamón");

        tomate = tomate.setPesoEnGr(300);
        queso = queso.setPesoEnGr(100);
        harina = harina.setPesoEnGr(500);
        jamon = jamon.setPesoEnGr(150);

        Plato pizza = new Plato(
                "Pizza",
                List.of(tomate,queso,harina)
        );

        Plato pizzaJamon = new Plato(
                "Pizza con jamon",
                List.of(tomate,queso,harina,jamon)
        );

        platos.add(pizza);
        platos.add(pizzaJamon);
        this.ingredienteRepositorio = ingredienteRepositorio;
    }

    public List<Plato> getPlatos() {
        return platos;
    }
}
