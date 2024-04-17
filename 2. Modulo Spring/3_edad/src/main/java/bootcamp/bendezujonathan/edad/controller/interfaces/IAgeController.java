package bootcamp.bendezujonathan.edad.controller.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;

@RequestMapping("/edad")
public interface IAgeController {

    @GetMapping("/{dia}/{mes}/{anio}")
    ResponseEntity<Integer> calculateAge(
            @Min(1) @Max(31) @PathVariable Integer day,
            @Min(1) @Max(12) @PathVariable Integer month, 
            @Positive @PathVariable Integer year);
}

