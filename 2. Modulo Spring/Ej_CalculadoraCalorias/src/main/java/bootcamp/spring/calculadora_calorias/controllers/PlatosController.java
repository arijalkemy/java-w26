package bootcamp.spring.calculadora_calorias.controllers;

import javax.naming.NameNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.spring.calculadora_calorias.models.dtos.PlatoDTO;
import bootcamp.spring.calculadora_calorias.models.dtos.RequestPlatoDTO;
import bootcamp.spring.calculadora_calorias.services.IExternalPlatosService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/platos")
@AllArgsConstructor
public class PlatosController implements IPlatosController {

    private final IExternalPlatosService platosService;

    @Override
    public ResponseEntity<PlatoDTO> getPlato(RequestPlatoDTO plato) {
        try{
            PlatoDTO platoDTO = platosService.searchByNameWithCalories(plato.getNombre(), plato.getGramos()).get();
            return ResponseEntity.ok(platoDTO);
        }
        catch(NameNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}
