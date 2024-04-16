package meli.bootcamp.codigomorse.service;

import meli.bootcamp.codigomorse.helpers.ConvertMorse;
import meli.bootcamp.codigomorse.service.interfaces.ITranslateMorse;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TranslateMorseImpl implements ITranslateMorse {

    @Override
    public String toMorse(String text) {
        String upperCaseWord = text.toUpperCase();

        return Arrays.stream(upperCaseWord.split(""))
                .map(ConvertMorse::convertToMorseCode)
                .collect(Collectors.joining(" "));
    }

    @Override
    public String toText(String text) {
        return Arrays.stream(text.split(" "))
                .map(ConvertMorse::convertMorseCode)
                .map(Objects::toString)
                .collect(Collectors.joining())
                .replace("  ", " ");
    }
}
