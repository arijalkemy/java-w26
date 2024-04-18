package bootcamp.bendezujonathan.recetas.controller.implementations;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.bendezujonathan.recetas.controller.interfaces.IPlatoController;
import bootcamp.bendezujonathan.recetas.dto.request.PlatoRequest;
import bootcamp.bendezujonathan.recetas.dto.response.PlatoResponse;
import bootcamp.bendezujonathan.recetas.service.interfaces.IPlatoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PlatoController implements IPlatoController {

    private final IPlatoService service;

    @Override
    public ResponseEntity<PlatoResponse> postPlato(PlatoRequest request) {
        return ResponseEntity.ok(service.create(request));
    }

}
