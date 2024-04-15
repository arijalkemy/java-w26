package bootcamp.bendezu.morse.service.implementation;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import bootcamp.bendezu.morse.service.interfaces.ITranslationService;

@Service
public class TranslationService implements ITranslationService {

    private static final String MORSE_DELIMITER = "\\s";

    @Override
    public String morseToSpanish(String morse) {
        return Arrays.asList(morse.split(MORSE_DELIMITER))
                .stream()
                .map(morseCharacter -> MorseEnum.getByMorseKey(morseCharacter)
                        .getValue())
                .collect(Collectors.joining());
    }

}
