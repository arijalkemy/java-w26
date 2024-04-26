package com.calculadora.calorias.Repository;

import com.calculadora.calorias.Entity.Ingrediente;
import com.calculadora.calorias.Entity.Plato;
import com.calculadora.calorias.Repository.Interface.IPlatoRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PlatoRepository implements IPlatoRepository {

    public List<Plato> listaDePlatos = new ArrayList<>();

    public PlatoRepository() throws IOException {
        this.loadResource();
    }

    @Override
    public Optional<Plato> getByName(String name){ return this.listaDePlatos.stream().filter(p -> p.getName().equals(name)).findFirst();}

    public void loadResource() throws IOException{
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Ingrediente> ingredientes;

        file = ResourceUtils.getFile("classpath:food.json");
        ingredientes = objectMapper.readValue(file,new TypeReference<List<Ingrediente>>(){});
        crearPlatos(ingredientes);
    }

    public void crearPlatos(List<Ingrediente> ingredientes){
        Plato plato = new Plato("dish1");
        for(Ingrediente ingrediente: ingredientes){
            if(plato.getCantidadDeIngredientes() == 2){
                listaDePlatos.add(plato);
                plato = new Plato("dish" + listaDePlatos.size() + 1);
            }
        plato.addIngrediente(ingrediente);
        }
    }
}
