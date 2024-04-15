package org.example.spring_p2_morse_code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@RestController
public class Decode {
    JsonElement root = new JsonParser().parse(new FileReader("src/main/resources/static/Morse.json"));
    JsonObject obj = root.getAsJsonObject();
    Gson gson = new Gson();

    public Decode() throws FileNotFoundException {
    }

    @GetMapping("/{morse}")
    public String decodeMorse(@PathVariable String morse) {
        String[] words = morse.split(" {3}");
        StringBuilder translation = new StringBuilder();
        Map<String, JsonElement> morseMap = obj.asMap();
        for(String word : words){
            String[] letters = word.split(" ");

            for(String letter : letters){
                if (!morseMap.containsKey(letter)) {
                    translation.append("?");
                    continue;
                }
                String aLetter = morseMap.get(letter).getAsString();
                translation.append(aLetter);
            }

            translation.append(" ");
        }
        return translation.toString();
    }
}
