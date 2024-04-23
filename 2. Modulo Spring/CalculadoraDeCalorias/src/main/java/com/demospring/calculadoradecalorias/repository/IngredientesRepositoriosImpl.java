package com.demospring.calculadoradecalorias.repository;

import com.demospring.calculadoradecalorias.dto.IngredienteDTO;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IngredientesRepositoriosImpl implements IIngredientesRepositorios{
    private List<IngredienteDTO> ingredientes;

    public IngredientesRepositoriosImpl() {
        this.ingredientes = cargarIngredientes();
    }

    public List<IngredienteDTO> cargarIngredientes() {
        try (JsonReader reader = Json.createReader(new FileReader("src/main/java/com/demospring/calculadoradecalorias/1. c. food.json"))) {
            JsonArray jsonArray = reader.readArray();
            this.ingredientes = new ArrayList<>();
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject jsonObject = jsonArray.getJsonObject(i);
                IngredienteDTO ingrediente = new IngredienteDTO(
                        jsonObject.getString("name"),
                        jsonObject.getInt("calories")
                );
                this.ingredientes.add(ingrediente);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.ingredientes;
    }

    @Override
    public IngredienteDTO findIngredienteByName(String name) {
        return this.ingredientes.stream().filter(ingrediente -> ingrediente.getName().equals(name)).findFirst().orElse(null);
    }
}
