package bootcamp.bendezujonathan.recetas.repository.implementations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import bootcamp.bendezujonathan.recetas.model.Plato;
import bootcamp.bendezujonathan.recetas.repository.interfaces.IPlatoRepository;


@Repository
public class PlatoRepository implements IPlatoRepository {

    private Map<String, Plato> platos;


    public PlatoRepository() {
        this.platos = new HashMap<>(); 
    }

    @Override
    public List<Plato> findAll() {
        return new ArrayList<>(this.platos.values());
    }

    @Override
    public Optional<Plato> find(String name) {
        return Optional.of(this.platos.get(name));
    }

    @Override
    public void add(Plato model) {
        this.platos.put(model.getName(), model);
    }
    
}
