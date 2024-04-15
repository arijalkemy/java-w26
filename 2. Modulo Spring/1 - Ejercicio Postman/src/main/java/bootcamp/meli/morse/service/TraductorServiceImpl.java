package bootcamp.meli.morse.service;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class TraductorServiceImpl implements ITraductorService {

    @Override
    public String morseToSpanish(String morse) {
        String[] morseSplited = morse.split("\\s");
        return Arrays.asList(morseSplited)
                .stream()
                .map(morseCharacter -> MorseEnum.getByMorseKey(morseCharacter).getValue())
                .collect(Collectors.joining());
    }

    @Override
    public String spanishToMorse(String spanish) {
        String[] wordSplited = spanish.split("");
        return Arrays.asList(wordSplited)
                .stream()
                .map(letter -> MorseEnum.getByLetter(letter).getMorseKey())
                .collect(Collectors.joining(" "));
    }

}
