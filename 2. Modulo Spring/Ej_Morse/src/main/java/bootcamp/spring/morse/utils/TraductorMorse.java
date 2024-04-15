package bootcamp.spring.morse.utils;

import java.util.HashMap;
import java.util.Map;

public class TraductorMorse {

    private static final Map<String, String> espanolMorse = Map.ofEntries(
        Map.entry("A", ".-"),
        Map.entry("B", "-..."),
        Map.entry("C", "-.-."),
        Map.entry("D", "-.."),
        Map.entry("E", "."),
        Map.entry("F", "..-."),
        Map.entry("G", "--."),
        Map.entry("H", "...."),
        Map.entry("I", ".."),
        Map.entry("J", ".---"),
        Map.entry("K", "-.-"),
        Map.entry("L", ".-.."),
        Map.entry("M", "--"),
        Map.entry("N", "-."),
        Map.entry("O", "---"),
        Map.entry("P", ".--."),
        Map.entry("Q", "--.-"),
        Map.entry("R", ".-."),
        Map.entry("S", "..."),
        Map.entry("T", "-"),
        Map.entry("U", "..-"),
        Map.entry("V", "...-"),
        Map.entry("W", ".--"),
        Map.entry("X", "-..-"),
        Map.entry("Y", "-.--"),
        Map.entry("Z", "--.."),
        Map.entry("1", ".----"),
        Map.entry("2", "..---"),
        Map.entry("3", "...--"),
        Map.entry("4", "....-"),
        Map.entry("5", "....."),
        Map.entry("6", "-...."),
        Map.entry("7", "--..."),
        Map.entry("8", "---.."),
        Map.entry("9", "----."),
        Map.entry("0", "-----"),
        Map.entry("?", "..--.."),
        Map.entry(".", ".-.-.-"),
        Map.entry(",", "--..--"),
        Map.entry("!", "-.-.--")
    );


    private static final Map<String, String> morseEspanol = Map.ofEntries(
        Map.entry(".-", "A"),
        Map.entry("-...", "B"),
        Map.entry("-.-.", "C"),
        Map.entry("-..", "D"),
        Map.entry(".", "E"),
        Map.entry("..-.", "F"),
        Map.entry("--.", "G"),
        Map.entry("....", "H"),
        Map.entry("..", "I"),
        Map.entry(".---", "J"),
        Map.entry("-.-", "K"),
        Map.entry(".-..", "L"),
        Map.entry("--", "M"),
        Map.entry("-.", "N"),
        Map.entry("---", "O"),
        Map.entry(".--.", "P"),
        Map.entry("--.-", "Q"),
        Map.entry(".-.", "R"),
        Map.entry("...", "S"),
        Map.entry("-", "T"),
        Map.entry("..-", "U"),
        Map.entry("...-", "V"),
        Map.entry(".--", "W"),
        Map.entry("-..-", "X"),
        Map.entry("-.--", "Y"),
        Map.entry("--..", "Z"),
        Map.entry(".----", "1"),
        Map.entry("..---", "2"),
        Map.entry("...--", "3"),
        Map.entry("....-", "4"),
        Map.entry(".....", "5"),
        Map.entry("-....", "6"),
        Map.entry("--...", "7"),
        Map.entry("---..", "8"),
        Map.entry("----.", "9"),
        Map.entry("-----", "0"),
        Map.entry("..--..", "?"),
        Map.entry(".-.-.-", "."),
        Map.entry("--..--", ","),
        Map.entry("-.-.--", "!")
        );

        public static String traducirMorse(String codigoMorse) {
                StringBuilder resultado = new StringBuilder();
                String[] palabras = codigoMorse.split("\\s{2}"); 
                for (String word : palabras) {
                    String[] characters = word.split("\\s+");
                    for (String character : characters) {
                        if (morseEspanol.containsKey(character.toString())) {
                            resultado.append(morseEspanol.get(character));
                        } else {
                            resultado.append("?");
                        }
                    }
                    resultado.append(" ");
                }
                return resultado.toString().trim(); 
        }

        public static String traducirEspañol(String fraseEspanol){
            StringBuilder resultado = new StringBuilder();
            String[] palabras = fraseEspanol.split("\\s+");
            for(String word : palabras){
                for (int i = 0; i < word.length(); i++) {
                    char caracter = word.charAt(i);
                    String caracterComoString = String.valueOf(caracter);

                    if(espanolMorse.containsKey(caracterComoString)){
                        resultado.append(espanolMorse.get(caracterComoString));
                    }
                    else{
                        resultado.append("?");
                    }
                    resultado.append(" ");
                }
                resultado.append("  ");
            }
            return resultado.toString();
        }
}
