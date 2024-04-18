package bootcamp.bendezujonathan.recetas.service.interfaces;

import bootcamp.bendezujonathan.recetas.dto.request.PlatoRequest;
import bootcamp.bendezujonathan.recetas.dto.response.PlatoResponse;
import bootcamp.bendezujonathan.recetas.model.Plato;

public interface IPlatoService extends IService<Plato> {

    PlatoResponse create(PlatoRequest toCreate);
}
