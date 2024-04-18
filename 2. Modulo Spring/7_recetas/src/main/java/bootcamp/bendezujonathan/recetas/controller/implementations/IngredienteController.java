package bootcamp.bendezujonathan.recetas.controller.implementations;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.bendezujonathan.recetas.controller.interfaces.IIngredienteController;
import bootcamp.bendezujonathan.recetas.dto.mapping.IngredienteMapping;
import bootcamp.bendezujonathan.recetas.dto.response.IngredienteResponse;
import bootcamp.bendezujonathan.recetas.service.interfaces.IIngredienteService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class IngredienteController implements IIngredienteController {

    private final IIngredienteService service;

    @Override
    public ResponseEntity<List<IngredienteResponse>> getAllIngredientes() {

        List<IngredienteResponse> result = this.service
                .findAll()
                .stream()
                .map(IngredienteMapping::modelToResponse).toList();

        return ResponseEntity.ok(result);

    }

    @Override
    public ResponseEntity<IngredienteResponse> getIngredienteByName(String name) {
        return this.service
                .searchByName(name)
                .map(IngredienteMapping::modelToResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
