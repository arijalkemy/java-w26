package morse.springExercise.controller;

import morse.springExercise.MorseCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class SpanishToMorseController {
    @GetMapping("/spanish-to-morse/{text}")
    public String translation(@PathVariable String text) {
        Map<String, String> spanishToMorse = spanishToMorse();
        return text.toLowerCase().chars()
                .mapToObj(c -> (char) c == ' ' ? " / " : spanishToMorse.getOrDefault(String.valueOf((char) c), ""))
                .filter(s -> !s.isEmpty())
                .collect(Collectors.joining(" "));
    }

    private static Map<String, String> spanishToMorse() {
        Map<String, String> morseToSpanish = MorseCode.getMorseAlphabet();
        return morseToSpanish.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
    }
}
