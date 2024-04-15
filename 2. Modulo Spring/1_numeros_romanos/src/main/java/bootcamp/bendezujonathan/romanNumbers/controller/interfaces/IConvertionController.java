package bootcamp.bendezujonathan.romanNumbers.controller.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bootcamp.bendezujonathan.romanNumbers.dto.ConvertionDto;
import jakarta.validation.constraints.Positive;

@RequestMapping("/convertion")
public interface IConvertionController {
    
    @GetMapping("/roman")
    ResponseEntity<ConvertionDto> fromArabicToRoman(@Positive @RequestParam("toConvert") Integer toConvert);

}
