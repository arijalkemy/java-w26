package bootcamp.bendezujonathan.recetas.repository.implementations;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import bootcamp.bendezujonathan.recetas.RecetasApplication;
import bootcamp.bendezujonathan.recetas.model.Ingrediente;
import bootcamp.bendezujonathan.recetas.repository.interfaces.IIngredienteRepository;

@Repository
public class IngredienteRepository implements IIngredienteRepository {

    private final ObjectMapper mapper = new ObjectMapper();
    private Map<String, Ingrediente> recetas;

    public IngredienteRepository() {
        InputStream json = RecetasApplication.class.getResourceAsStream("/data.json");
        try {
            this.recetas = this.mapper.readValue(json, new TypeReference<List<Ingrediente>>() {
            })
                    .stream()
                    .collect(Collectors.toMap(Ingrediente::getName, i -> i));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Ingrediente> findAll() {
        return new ArrayList<>(this.recetas.values());
    }

    @Override
    public Optional<Ingrediente> find(String name) {
        return Optional.of(this.recetas.get(name));
    }

    @Override
    public void add(Ingrediente model) {
        this.recetas.put(model.getName(), model);
    }

}
