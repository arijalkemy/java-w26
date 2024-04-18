package com.codigo_morse.codigo_morse.enums;

import org.springframework.stereotype.Service;

public enum MorseAlphabet {
    A(".-"),
    B("-..."),
    C("-.-."),
    D("-.."),
    E("."),
    F("..-."),
    G("--."),
    H("...."),
    I(".."),
    J(".---"),
    K("-.-"),
    L(".-.."),
    M("--"),
    N("-."),
    O("---"),
    P(".--."),
    Q("--.-"),
    R(".-."),
    S("..."),
    T("-"),
    U("..-"),
    V("...-"),
    W(".--"),
    X("-..-"),
    Y("-.--"),
    Z("--..");

    private final String morseCode;

    MorseAlphabet(String morseCode) {
        this.morseCode = morseCode;
    }

    public String getMorseCode() {
        return this.morseCode;
    }

    public static MorseAlphabet fromMorseCode(String morseCode) {
        for (MorseAlphabet letter : MorseAlphabet.values()) {
            if (letter.getMorseCode().equals(morseCode)) {
                return letter;
            }
        }
        return null;
    }

    public static String obtenerValorPorClave(String clave) {
        for (MorseAlphabet item : MorseAlphabet.values()) {
            if (item.name().equals(clave)) {
                return item.getMorseCode();
            }
        }
        return "";
    }
}
