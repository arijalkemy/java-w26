package bootcamp.spring.edad_persona.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.spring.edad_persona.services.EdadService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/edad")
@RequiredArgsConstructor
/**
 * EdadController
 */
public class EdadController {

  private final EdadService edadService;

  @GetMapping("/{dia}/{mes}/{anio}")
  public ResponseEntity<Integer> calcularEdad(@Positive @Max(31) @PathVariable Integer dia,
                                              @Positive @Max(12) @PathVariable Integer mes,
                                              @Positive @PathVariable Integer anio) {
    Integer edad = edadService.calcularEdad(dia, mes, anio);
    return ResponseEntity.ok(edad);
  }

}
