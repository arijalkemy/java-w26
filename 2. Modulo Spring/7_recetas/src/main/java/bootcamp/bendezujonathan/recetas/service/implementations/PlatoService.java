package bootcamp.bendezujonathan.recetas.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bootcamp.bendezujonathan.recetas.dto.mapping.IngredienteMapping;
import bootcamp.bendezujonathan.recetas.dto.request.PlatoRequest;
import bootcamp.bendezujonathan.recetas.dto.response.PlatoResponse;
import bootcamp.bendezujonathan.recetas.model.Ingrediente;
import bootcamp.bendezujonathan.recetas.model.Plato;
import bootcamp.bendezujonathan.recetas.repository.interfaces.IPlatoRepository;
import bootcamp.bendezujonathan.recetas.service.interfaces.IIngredienteService;
import bootcamp.bendezujonathan.recetas.service.interfaces.IPlatoService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlatoService implements IPlatoService {

    private final IPlatoRepository repository;

    private final IIngredienteService ingredienteService;

    @Override
    public Optional<Plato> searchByName(String name) {
        return repository.find(name);
    }

    @Override
    public List<Plato> findAll() {
        return repository.findAll();
    }

    @Override
    public PlatoResponse create(PlatoRequest toCreate) {
        List<Ingrediente> ingredientes = toCreate.getIngredientes()
                .stream()
                .map(this.ingredienteService::searchByName)
                .map(Optional::get)
                .toList();
        double calories = this.calculateCalories(toCreate.getPeso(), ingredientes);
        Plato newPlato = new Plato(toCreate.getName(), toCreate.getPeso(), ingredientes, calories);
        this.repository.add(newPlato);
        return new PlatoResponse(newPlato.getName(),
                calories,
                IngredienteMapping.modelToResponse(newPlato.getIngredientes()),
                IngredienteMapping.modelToResponse(newPlato.getMaxCalories()));

    }

    private double calculateCalories(double peso, List<Ingrediente> ingredientes) {
        int milPeso = (int) peso / 100;
        return ingredientes.stream()
                .mapToDouble(Ingrediente::getCalories)
                .map(cal -> cal * milPeso)
                .sum();
    }
}
