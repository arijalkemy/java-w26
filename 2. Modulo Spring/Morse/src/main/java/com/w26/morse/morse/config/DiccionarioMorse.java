package com.w26.morse.morse.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
@Data
public class DiccionarioMorse {
    private @Getter @Setter Map<String, Character> mapaMorseAlfabeto;
    private @Getter @Setter Map<Character, String> mapaAlfabetoMorse;

    public DiccionarioMorse(){}



}
