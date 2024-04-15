package bootcamp.bendezu.morse.controller.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bootcamp.bendezu.morse.dto.ConvertionDto;
import jakarta.validation.constraints.NotEmpty;

@RequestMapping("/morse")
public interface IMorseController {
    
    @GetMapping("/spanish")
    ResponseEntity<ConvertionDto> transalteToSpanish(@NotEmpty @RequestParam("toTranslate") String toTranslate);

}
