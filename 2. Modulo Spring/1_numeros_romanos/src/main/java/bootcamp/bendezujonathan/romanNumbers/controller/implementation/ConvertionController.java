package bootcamp.bendezujonathan.romanNumbers.controller.implementation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.bendezujonathan.romanNumbers.controller.interfaces.IConvertionController;
import bootcamp.bendezujonathan.romanNumbers.dto.ConvertionDto;
import bootcamp.bendezujonathan.romanNumbers.services.interfaces.IConvertionService;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ConvertionController implements IConvertionController {

    private final IConvertionService service;

    @Override
    public ResponseEntity<ConvertionDto> fromArabicToRoman(Integer toConvert) {

        String result = this.service.toRoman(toConvert);

        return ResponseEntity.ok(new ConvertionDto(toConvert.toString(), result));
    }

}
