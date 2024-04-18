package com.spring.codigomorse.Services;

import com.spring.codigomorse.Interfaces.MorseInterface;
import com.spring.codigomorse.Utils.TranslateMorseText;
import org.springframework.stereotype.Service;

@Service
public class MorseService implements MorseInterface {


    @Override
    public String textToMorse(String text) {

        return TranslateMorseText.textToMorse(text);
    }

    @Override
    public String morseToText(String morse) {
        return TranslateMorseText.morseToText(morse);
    }
}
