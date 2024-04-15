package bootcamp.bendezu.morse.controller.implementation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.bendezu.morse.controller.interfaces.ITranslateController;
import bootcamp.bendezu.morse.dto.ConvertionDto;
import bootcamp.bendezu.morse.service.interfaces.ITranslationService;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TranslateController implements ITranslateController {

    private final ITranslationService service;

    @Override
    public ResponseEntity<ConvertionDto> transalteToSpanish(@NotEmpty String toTranslate) {
        String result = this.service.morseToSpanish(toTranslate);
        return ResponseEntity.ok(new ConvertionDto(toTranslate, result));
    }

    @Override
    public ResponseEntity<ConvertionDto> translateToMorse(@NotEmpty String toSpanish) {
        String result = this.service.spanishToMorse(toSpanish);
        return ResponseEntity.ok(new ConvertionDto(toSpanish, result));
    }

}
