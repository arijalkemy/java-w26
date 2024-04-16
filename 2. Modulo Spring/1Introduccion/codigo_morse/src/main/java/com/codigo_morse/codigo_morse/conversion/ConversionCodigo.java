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
        List<String> splittedWords = List.of(morseStringCode.split("   "));
        StringBuilder decodedMsg = new StringBuilder();
        for(String word: splittedWords){
            List<String> splittedString = List.of(word.split(" "));
            for(String morseLetter: splittedString){
                decodedMsg.append(this.decifrarLetraMorse(morseLetter));
            }
            decodedMsg.append(" ");
        }

        return decodedMsg.toString();
    }

    @Override
    public String convertirAMorse(String cadena){
        List<String> splittedWords = List.of(cadena.split(" "));
        StringBuilder decodedMsg = new StringBuilder();

        for(String word: splittedWords){
            List<String> letters =  List.of(word.split(""));
            for(String letter: letters){
                decodedMsg.append(MorseAlphabet.obtenerValorPorClave(letter));
                decodedMsg.append(" ");
            }
            decodedMsg.append("   ");
        }
        return decodedMsg.toString();
    }
}
