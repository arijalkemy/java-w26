package com.Ejercicio.CodigoMorse.ServiceImpl;

import com.Ejercicio.CodigoMorse.Service.Convert;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConvertImplementation implements Convert {
    private final Map<String, Character> morseToABC;

    private final Map<Character, String> ABCToMorse;

    public ConvertImplementation() {
        this.morseToABC = new HashMap<>();
        morseToABC.put(".-", 'A');
        morseToABC.put("-...", 'B');
        morseToABC.put("-.-.", 'C');
        morseToABC.put("-..", 'D');
        morseToABC.put(".", 'E');
        morseToABC.put("..-.", 'F');
        morseToABC.put("--.", 'G');
        morseToABC.put("....", 'H');
        morseToABC.put("..", 'I');
        morseToABC.put(".---", 'J');
        morseToABC.put("-.-", 'K');
        morseToABC.put(".-..", 'L');
        morseToABC.put("--", 'M');
        morseToABC.put("-.", 'N');
        morseToABC.put("---", 'O');
        morseToABC.put(".--.", 'P');
        morseToABC.put("--.-", 'Q');
        morseToABC.put(".-.", 'R');
        morseToABC.put("...", 'S');
        morseToABC.put("-", 'T');
        morseToABC.put("..-", 'U');
        morseToABC.put("...-", 'V');
        morseToABC.put(".--", 'W');
        morseToABC.put("-..-", 'X');
        morseToABC.put("-.--", 'Y');
        morseToABC.put("--..", 'Z');
        morseToABC.put("-----", '0');
        morseToABC.put(".----", '1');
        morseToABC.put("..---", '2');
        morseToABC.put("...--", '3');
        morseToABC.put("....-", '4');
        morseToABC.put(".....", '5');
        morseToABC.put("-....", '6');
        morseToABC.put("--...", '7');
        morseToABC.put("---..", '8');
        morseToABC.put("----.", '9');

        this.ABCToMorse = new HashMap<>();
        ABCToMorse.put('A', ".-");
        ABCToMorse.put('B', "-...");
        ABCToMorse.put('C', "-.-.");
        ABCToMorse.put('D', "-..");
        ABCToMorse.put('E', ".");
        ABCToMorse.put('F', "..-.");
        ABCToMorse.put('G', "--.");
        ABCToMorse.put('H', "....");
        ABCToMorse.put('I', "..");
        ABCToMorse.put('J', ".---");
        ABCToMorse.put('K', "-.-");
        ABCToMorse.put('L', ".-..");
        ABCToMorse.put('M', "--");
        ABCToMorse.put('N', "-.");
        ABCToMorse.put('O', "---");
        ABCToMorse.put('P', ".--.");
        ABCToMorse.put('Q', "--.-");
        ABCToMorse.put('R', ".-.");
        ABCToMorse.put('S', "...");
        ABCToMorse.put('T', "-");
        ABCToMorse.put('U', "..-");
        ABCToMorse.put('V', "...-");
        ABCToMorse.put('W', ".--");
        ABCToMorse.put('X', "-..-");
        ABCToMorse.put('Y', "-.--");
        ABCToMorse.put('Z', "--..");
    }



    @Override
    public String convertToABC(String morse) {
        List<String> palabras = List.of(morse.split("   "));
        String traduccion = "";
        for( String palabra:palabras){
            List<String> simbolos = List.of(palabra.split(" "));
            for (String simbolo: simbolos){
                traduccion += this.morseToABC.get(simbolo);
            }
            traduccion += " ";
        }
        return traduccion;
    }


    @Override
    public String convertToMorse(String abcText) {
        List<String> palabras = List.of(abcText.split(" "));
        String traduccion = "";
        for( String palabra:palabras){
            char[] letras = palabra.toCharArray();
            for (Character letra: letras){
                traduccion += this.ABCToMorse.get(letra);
                traduccion+=" ";
            }
            traduccion += "   ";
        }
        return traduccion;
    }
}
