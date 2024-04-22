package org.example.codigomorse.interfaces.implementation;

import org.example.codigomorse.interfaces.IConvertMorseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ConvertMorseCodeImpl implements IConvertMorseCode {

    private static final Logger logger = LoggerFactory.getLogger(ConvertMorseCodeImpl.class);

    Map<String, String> morseCode = getSymbolString();

    @Override
    public String convertMorseToString(String code) {
        StringBuilder text =new StringBuilder();
        List<String> codeSplitWords =  Arrays.stream(code.split("   ")).toList();
        codeSplitWords.forEach(word -> {
            text.append(" ");
            Arrays.stream(word.split(" ")).forEach(x -> text.append(morseCode.get(x)));
        });

        return text.toString().replace("null"," ");
    }

    public String convertStringToMorse(String code) {
        StringBuilder text = new StringBuilder("");
        char[] chars = code.toCharArray();
        for(char c : chars){
            logger.info(String.valueOf(c));
            if(c == 32) {
                text.append("   ");

            }
            else {
                text.append(getSymbolMorse(String.valueOf(c)));
                text.append(" ");
            }
        }
        return text.toString();
    }

    private String getSymbolMorse(String chars){
        for(Map.Entry<String, String> entry : morseCode.entrySet()){
            if(entry.getValue().equals(chars.toUpperCase()))return entry.getKey();
        }
        return " ";
    }

    private static Map<String, String> getSymbolString(){
        return Stream.of(
                new AbstractMap.SimpleEntry<String, String>(".-", "A"),
                new AbstractMap.SimpleEntry<String, String>("-...", "B"),
                new AbstractMap.SimpleEntry<String, String>("-.-.", "C"),
                new AbstractMap.SimpleEntry<String, String>("-..", "D"),
                new AbstractMap.SimpleEntry<String, String>(".", "E"),
                new AbstractMap.SimpleEntry<String, String>("..-.", "F"),
                new AbstractMap.SimpleEntry<String, String>("--.", "G"),
                new AbstractMap.SimpleEntry<String, String>("....", "H"),
                new AbstractMap.SimpleEntry<String, String>("..", "I"),
                new AbstractMap.SimpleEntry<String, String>(".---", "J"),
                new AbstractMap.SimpleEntry<String, String>("-.-", "K"),
                new AbstractMap.SimpleEntry<String, String>(".-..", "L"),
                new AbstractMap.SimpleEntry<String, String>("--", "M"),
                new AbstractMap.SimpleEntry<String, String>("-.", "N"),
                new AbstractMap.SimpleEntry<String, String>("---", "O"),
                new AbstractMap.SimpleEntry<String, String>(".--.", "P"),
                new AbstractMap.SimpleEntry<String, String>("--.-", "Q"),
                new AbstractMap.SimpleEntry<String, String>(".-.", "R"),
                new AbstractMap.SimpleEntry<String, String>("...", "S"),
                new AbstractMap.SimpleEntry<String, String>("-", "T"),
                new AbstractMap.SimpleEntry<String, String>("..-", "U"),
                new AbstractMap.SimpleEntry<String, String>("...-", "V"),
                new AbstractMap.SimpleEntry<String, String>(".--", "W"),
                new AbstractMap.SimpleEntry<String, String>("-..-", "X"),
                new AbstractMap.SimpleEntry<String, String>("-.--", "Y"),
                new AbstractMap.SimpleEntry<String, String>("--..", "Z"),
                new AbstractMap.SimpleEntry<String, String>("-----", "0"),
                new AbstractMap.SimpleEntry<String, String>(".----", "1"),
                new AbstractMap.SimpleEntry<String, String>("..---", "2"),
                new AbstractMap.SimpleEntry<String, String>("...--", "3"),
                new AbstractMap.SimpleEntry<String, String>("....-", "4"),
                new AbstractMap.SimpleEntry<String, String>(".....", "5"),
                new AbstractMap.SimpleEntry<String, String>("-....", "6"),
                new AbstractMap.SimpleEntry<String, String>("--...", "7"),
                new AbstractMap.SimpleEntry<String, String>("---..", "8"),
                new AbstractMap.SimpleEntry<String, String>("----.", "9"),
                new AbstractMap.SimpleEntry<String, String>(".-.-.-", "."),
                new AbstractMap.SimpleEntry<String, String>("--..--", ","),
                new AbstractMap.SimpleEntry<String, String>("..--..", "?"),
                new AbstractMap.SimpleEntry<String, String>("-.-.--", "!"),
                new AbstractMap.SimpleEntry<String, String>("-..-.", "/"),
                new AbstractMap.SimpleEntry<String, String>("-.--.", "("),
                new AbstractMap.SimpleEntry<String, String>("-.--.-", ")"),
                new AbstractMap.SimpleEntry<String, String>(".-...", "&"),
                new AbstractMap.SimpleEntry<String, String>("---...", ":"),
                new AbstractMap.SimpleEntry<String, String>("-.-.-.", ";"),
                new AbstractMap.SimpleEntry<String, String>("-...-", "="),
                new AbstractMap.SimpleEntry<String, String>(".-.-.", "+"),
                new AbstractMap.SimpleEntry<String, String>("-....-", "-"),
                new AbstractMap.SimpleEntry<String, String>("..--.-", "_"),
                new AbstractMap.SimpleEntry<String, String>("  ", "  "),
                new AbstractMap.SimpleEntry<String, String>(".--.-.", "@")
        ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
