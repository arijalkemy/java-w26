package bootcamp.bendezu.morse.service.implementation;

import java.util.Arrays;

public enum MorseEnum {
    A(".-", "A"),
    B("-...", "B"),
    C("-.-.", "C"),
    D("-..", "D"),
    E(".", "E"),
    F("..-.", "F"),
    G("--.", "G"),
    H("....", "H"),
    I("..", "I"),
    J(".---", "J"),
    K("-.-", "K"),
    L(".-..", "L"),
    M("--", "M"),
    N("-.", "N"),
    O("---", "O"),
    P(".--.", "P"),
    Q("--.-", "Q"),
    R(".-.", "R"),
    S("...", "S"),
    T("-", "T"),
    U("..-", "U"),
    V("...-", "V"),
    W(".--", "W"),
    X("-..-", "X"),
    Y("-.--", "Y"),
    Z("--..", "Z"),
    CERO("-----", "0"),
    UNO(".----", "1"),
    DOS("..---", "2"),
    TRES("...--", "3"),
    CUATRO("....-", "4"),
    CINCO(".....", "5"),
    SEIS("-....", "6"),
    SIETE("--...", "7"),
    OCHO("---..", "8"),
    NUEVE("----.", "9"),
    NMC("", "[No Reconocido]");

    private final String morseKey;
    private final String value;

    MorseEnum(String morseKey, String value) {
        this.morseKey = morseKey;
        this.value = value;
    }

    public String getMorseKey() {
        return morseKey;
    }

    public String getValue() {
        return value;
    }

    public static MorseEnum getByMorseKey(String morseKey) {
        return Arrays.stream(values())
                .filter(morseEnum -> morseEnum.morseKey.equals(morseKey))
                .findFirst()
                .orElse(NMC);
    }


}
