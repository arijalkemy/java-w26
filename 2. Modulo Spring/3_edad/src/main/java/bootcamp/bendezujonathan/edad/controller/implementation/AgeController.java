package bootcamp.bendezujonathan.edad.controller.implementation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.bendezujonathan.edad.controller.interfaces.IAgeController;
import bootcamp.bendezujonathan.edad.services.interfaces.IAgeService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min; 
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AgeController implements IAgeController {

    private final IAgeService service;

    @Override
    public ResponseEntity<Integer> calculateAge(@Min(1) @Max(31) Integer day, @Min(1) @Max(12) Integer month,
            @Positive Integer year) {
        return ResponseEntity.ok(service.calculateAge(day, month, year));
    }

}
