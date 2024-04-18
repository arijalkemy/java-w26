package bootcamp.spring.calculadora_calorias.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import bootcamp.spring.calculadora_calorias.models.dtos.PlatoDTO;
import bootcamp.spring.calculadora_calorias.models.dtos.RequestPlatoDTO;

public interface IPlatosController extends IController<PlatoDTO>{
    
    @PostMapping
    public ResponseEntity<PlatoDTO> getPlato(@RequestBody RequestPlatoDTO plato);
}
