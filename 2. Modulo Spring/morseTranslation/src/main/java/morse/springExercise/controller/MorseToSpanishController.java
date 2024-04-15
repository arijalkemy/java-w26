package morse.springExercise.controller;

import morse.springExercise.MorseCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseToSpanishController {
    @GetMapping("/morse-to-spanish/{morseCode}")
    public String translation(@PathVariable String morseCode){
        String[] morseLetters = morseCode.split(" ");
        StringBuilder translatedMessage = new StringBuilder();
        for (String letter : morseLetters) {
            translatedMessage.append(MorseCode.getMorseAlphabet().getOrDefault(letter, ""));
        }
        return translatedMessage.toString();
    }
}
