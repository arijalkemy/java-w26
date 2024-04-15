package com.codigo_morse.codigo_morse.conversion;

import com.codigo_morse.codigo_morse.enums.MorseAlphabet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConversionCodigo implements IConversionCodigo{

    @Override
    public String decifrarLetraMorse(String morseCode) {
        MorseAlphabet letter = MorseAlphabet.fromMorseCode(morseCode);
        if (letter != null) {
            return letter.name();
        } else {
            return "";
        }
    }

    @Override
    public String decifrarCadenaMorse(String morseStringCode) {
        List<String> splittedString = List.of(morseStringCode.split(" "));
        StringBuilder decodedMsg = new StringBuilder();
        for(String morseLetter: splittedString){
            decodedMsg.append(this.decifrarLetraMorse(morseLetter));
        }

        return decodedMsg.toString();
    }
}
