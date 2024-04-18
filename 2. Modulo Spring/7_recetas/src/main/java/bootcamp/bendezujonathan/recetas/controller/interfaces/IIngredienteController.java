package bootcamp.bendezujonathan.recetas.controller.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import bootcamp.bendezujonathan.recetas.dto.response.IngredienteResponse;

@RequestMapping("/ingredientes")
public interface IIngredienteController {
    
    @GetMapping
    public ResponseEntity<List<IngredienteResponse>> getAllIngredientes();

    @GetMapping("/{name}")
    public ResponseEntity<IngredienteResponse> getIngredienteByName(@PathVariable String name);

}
