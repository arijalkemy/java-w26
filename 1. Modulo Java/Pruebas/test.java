import java.util.HashMap;

public class test {
    private static final HashMap<String, Character> morseMap = new HashMap<>();

    static {
        morseMap.put(".-", 'A');
        morseMap.put("-...", 'B');
        morseMap.put("-.-.", 'C');
        morseMap.put("-..", 'D');
        morseMap.put(".", 'E');
        morseMap.put("..-.", 'F');
        morseMap.put("--.", 'G');
        morseMap.put("....", 'H');
        morseMap.put("..", 'I');
        morseMap.put(".---", 'J');
        morseMap.put("-.-", 'K');
        morseMap.put(".-..", 'L');
        morseMap.put("--", 'M');
        morseMap.put("-.", 'N');
        morseMap.put("---", 'O');
        morseMap.put(".--.", 'P');
        morseMap.put("--.-", 'Q');
        morseMap.put(".-.", 'R');
        morseMap.put("...", 'S');
        morseMap.put("-", 'T');
        morseMap.put("..-", 'U');
        morseMap.put("...-", 'V');
        morseMap.put(".--", 'W');
        morseMap.put("-..-", 'X');
        morseMap.put("-.--", 'Y');
        morseMap.put("--..", 'Z');
        morseMap.put(".----", '1');
        morseMap.put("..---", '2');
        morseMap.put("...--", '3');
        morseMap.put("....-", '4');
        morseMap.put(".....", '5');
        morseMap.put("-....", '6');
        morseMap.put("--...", '7');
        morseMap.put("---..", '8');
        morseMap.put("----.", '9');
        morseMap.put("-----", '0');
    }

    public static String decode(String morseCode) {
        StringBuilder decodedString = new StringBuilder();
        StringBuilder morseCharacter = new StringBuilder();
        for (char c : morseCode.toCharArray()) {
            if (c == ' ' || c == '/') { // Espacio entre letras o palabras en código Morse
                if (morseMap.containsKey(morseCharacter.toString())) {
                    decodedString.append(morseMap.get(morseCharacter.toString()));
                } else if (morseCharacter.length() > 0) {
                    // Si no se encuentra la secuencia Morse en el mapa y la secuencia no está vacía, se agrega como un espacio en blanco
                    decodedString.append(' ');
                }
                morseCharacter.setLength(0); // Reiniciar la secuencia Morse para la siguiente letra
            } else {
                morseCharacter.append(c); // Agregar el carácter al conjunto Morse
            }
        }
        // Procesar el último conjunto Morse después del último espacio
        if (morseMap.containsKey(morseCharacter.toString())) {
            decodedString.append(morseMap.get(morseCharacter.toString()));
        }
        return decodedString.toString();
    }

    public static void main(String[] args) {
        String morseCode = "...---..."; // Código Morse a decodificar (SOS)
        String decodedText = decode(morseCode);
        System.out.println("Texto decodificado: " + decodedText);
    }
}
