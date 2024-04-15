package com.example.demo.Morse.Domain;

import lombok.Getter;

import java.util.Objects;

@Getter
public enum MorseAlphabet {
    LETTER_A("A", ".-"),
    LETTER_B("B", "-..."),
    LETTER_C("C", "-.-."),
    LETTER_D("D", "-.."),
    LETTER_E("E", "."),
    LETTER_F("F", "..-."),
    LETTER_G("G", "--."),
    LETTER_H("H", "...."),
    LETTER_I("I", ".."),
    LETTER_J("J", ".---"),
    LETTER_K("K", "-.-"),
    LETTER_L("L", ".-.."),
    LETTER_M("M", "--"),
    LETTER_N("N", "-."),
    LETTER_O("O", "---"),
    LETTER_P("P", ".--."),
    LETTER_Q("Q", "--.-"),
    LETTER_R("R", ".-."),
    LETTER_S("S", "..."),
    LETTER_T("T", "-"),
    LETTER_U("U", "..-"),
    LETTER_V("V", "...-"),
    LETTER_W("W", ".--"),
    LETTER_X("X", "-..-"),
    LETTER_Y("Y", "-.--"),
    LETTER_Z("Z", "--.."),
    DIGIT_0("0", "-----"),
    DIGIT_1("1", ".----"),
    DIGIT_2("2", "..---"),
    DIGIT_3("3", "...--"),
    DIGIT_4("4", "....-"),
    DIGIT_5("5", "....."),
    DIGIT_6("6", "-...."),
    DIGIT_7("7", "--..."),
    DIGIT_8("8", "---.."),
    DIGIT_9("9", "----."),
    SPACE(" ", "");

    private final String letter;
    private final String code;

    MorseAlphabet(String letter, String code) {
        this.letter = letter;
        this.code = code;
    }

    public static String getLetterFromCode(String code) {
        for (MorseAlphabet e : MorseAlphabet.values()) {
            if (Objects.equals(e.getCode(), code)) {
                return e.getLetter();
            }
        }
        return "";
    }

    public static String getCodeFromLetter(String letter) {
        for (MorseAlphabet e : MorseAlphabet.values()) {
            if (e.getLetter().equals(letter)) {
                return e.getCode().concat(" ");
            }
        }
        return "";
    }
}

