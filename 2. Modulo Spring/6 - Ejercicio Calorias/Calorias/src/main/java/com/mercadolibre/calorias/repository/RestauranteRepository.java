package com.mercadolibre.calorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calorias.dto.IngredienteDTO;
import com.mercadolibre.calorias.model.Ingrediente;
import com.mercadolibre.calorias.model.Plato;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RestauranteRepository {

    private final List<Ingrediente> database;

    private final List<Plato> platos;

    public RestauranteRepository() {
        this.database = loadDataBase();
        this.platos = verPlatos();
    }

    private List<Ingrediente> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingrediente>> typeRef = new TypeReference<>() {};
        List<Ingrediente> ingredientes = null;
        try {
            ingredientes = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredientes;
    }

    public List<Ingrediente> verIngredientes(){
        return database;
    }

    private List<Plato> verPlatos(){
        List<Plato> platoList = new ArrayList<>();
        platoList.add(new Plato("Pizza", List.of(database.get(0),database.get(1),database.get(2),database.get(3),database.get(4))));
        platoList.add(new Plato("Ñoquis", List.of(database.get(5),database.get(6),database.get(7),database.get(8),database.get(9))));
        platoList.add(new Plato("Hamburguesa", List.of(database.get(10),database.get(11),database.get(12),database.get(13),database.get(14))));
        platoList.add(new Plato("Zorrentinos", List.of(database.get(15),database.get(16),database.get(17),database.get(18),database.get(19))));
        platoList.add(new Plato("Empanadas", List.of(database.get(20),database.get(21),database.get(22),database.get(23),database.get(24))));
        platoList.add(new Plato("Helado", List.of(database.get(25),database.get(26),database.get(27),database.get(28),database.get(29))));
        return platoList;
    }

    public Plato verPlato(String nombre){
        return platos.stream().filter(p -> p.getNombre().toLowerCase().contains(nombre.toLowerCase())).findFirst().orElse(null);
    }
}
