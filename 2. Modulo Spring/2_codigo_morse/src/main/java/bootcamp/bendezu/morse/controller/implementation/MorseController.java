package bootcamp.bendezu.morse.controller.implementation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.bendezu.morse.controller.interfaces.IMorseController;
import bootcamp.bendezu.morse.dto.ConvertionDto;
import bootcamp.bendezu.morse.service.interfaces.ITranslationService;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MorseController implements IMorseController {

    private final ITranslationService service;

    @Override
    public ResponseEntity<ConvertionDto> transalteToSpanish(@NotEmpty String toTranslate) {
        String result = this.service.morseToSpanish(toTranslate);
        return ResponseEntity.ok(new ConvertionDto(toTranslate, result));
    }

}
