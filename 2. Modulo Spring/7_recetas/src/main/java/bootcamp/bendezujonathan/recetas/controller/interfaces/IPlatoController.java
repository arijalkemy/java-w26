package bootcamp.bendezujonathan.recetas.controller.interfaces;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import bootcamp.bendezujonathan.recetas.dto.request.PlatoRequest;
import bootcamp.bendezujonathan.recetas.dto.response.PlatoResponse;

@RequestMapping("/plato")
public interface IPlatoController {
    
   @PostMapping
   public ResponseEntity<PlatoResponse> postPlato(@RequestBody PlatoRequest request);

}
