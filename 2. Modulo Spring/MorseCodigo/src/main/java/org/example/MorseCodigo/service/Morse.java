package org.example.MorseCodigo.service;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Map;
import java.util.HashMap;

public class Morse {
    private String code;
    @JsonCreator
    public Morse(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    public String translate(){
        StringBuilder translation = new StringBuilder();
        String[] words = code.trim().split("   ");
        for(String word : words){
            String[] characters = word.split(" ");
            for(String character : characters){
                translation.append(MorseAlphabet.getAlphabet().getOrDefault(character, " "));
            }
            translation.append(" ");
        }
        return translation.toString().trim();
    }
}

