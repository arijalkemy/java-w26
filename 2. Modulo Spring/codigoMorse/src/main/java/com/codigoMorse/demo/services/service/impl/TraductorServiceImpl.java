package com.codigoMorse.demo.services.service.impl;

import com.codigoMorse.demo.services.ITraductorService;
import com.codigoMorse.demo.util.MorseEnum;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class TraductorServiceImpl implements ITraductorService {

    @Override
    public String morseAEspaniol(String morse) {
        String[] morseSplited = morse.split("\\s");
        return Arrays.asList(morseSplited)
                .stream()
                .map(morseCharacter -> MorseEnum.getByMorseKey(morseCharacter).getValue())
                .collect(Collectors.joining());
    }

    @Override
    public String esoaniolAMorse(String espaniol) {
        String[] wordSplited = espaniol.split("");
        return Arrays.asList(wordSplited)
                .stream()
                .map(letter -> MorseEnum.getByLetter(letter).getMorseKey())
                .collect(Collectors.joining(" "));
    }
}
