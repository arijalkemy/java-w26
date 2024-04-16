package meli.bootcamp.codigomorse.controller;

import meli.bootcamp.codigomorse.service.interfaces.ITranslateMorse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/morse")
public class MorseController {

    private final ITranslateMorse translateMorse;

    public MorseController(ITranslateMorse translateMorse) {
        this.translateMorse = translateMorse;
    }

    @GetMapping("translate/{morseCode}")
    public Map<String, String> convertMorseCode(@PathVariable String morseCode) {
        return Map.of("translate", translateMorse.toText(morseCode));
    }

    @GetMapping("convert/{word}")
    public Map<String, String> convertToMorseCode(@PathVariable String word) {
            return new HashMap<>(){{
                put("morseCode", translateMorse.toMorse(word));
            }};
        }
}
