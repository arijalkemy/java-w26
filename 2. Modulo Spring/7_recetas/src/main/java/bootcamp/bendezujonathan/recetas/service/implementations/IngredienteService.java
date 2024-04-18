package bootcamp.bendezujonathan.recetas.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bootcamp.bendezujonathan.recetas.model.Ingrediente;
import bootcamp.bendezujonathan.recetas.repository.interfaces.IIngredienteRepository;
import bootcamp.bendezujonathan.recetas.service.interfaces.IIngredienteService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IngredienteService implements IIngredienteService {

    private final IIngredienteRepository repository;

    @Override
    public Optional<Ingrediente> searchByName(String name) {
        return this.repository.find(name);
    }

    @Override
    public List<Ingrediente> findAll() {
        return this.repository.findAll();
    }

}
