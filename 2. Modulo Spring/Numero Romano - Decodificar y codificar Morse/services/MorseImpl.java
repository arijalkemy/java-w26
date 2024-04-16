package org.example.apitest.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Primary
public class MorseImpl implements IMorse {
    private final Map<String, String> decodeMap;
    private final Map<String, String> encodeMap;

    public MorseImpl(@Qualifier("decodeMap") Map<String, String> decodeMap, @Qualifier("encodeMap") Map<String, String> encodeMap) {
        this.decodeMap = decodeMap;
        this.encodeMap = encodeMap;
    }

    @Override
    public String decodeMorse(String phrase) {
        List<String> ans = new ArrayList<>();
        Arrays.stream(phrase.split(" {3}"))
                .forEach(currentWord -> {
                    List<String> word = Arrays
                            .stream(currentWord.split(" "))
                            .map(String::trim)
                            .toList();
                    ans.add(String.join("", word
                            .stream().map(decodeMap::get)
                            .toList()));
                });
        return String.join(" ", ans);
    }

    @Override
    public String encodeMorse(String text) {
        String textUpper = text.toUpperCase();
        List<String> words = Arrays
                .stream(textUpper.split(" ")).map(word ->
                        String.join(" ", Arrays
                                .stream(word.split(""))
                                .filter(i -> !i.equals(" "))
                                .map(encodeMap::get)
                                .toList()))
                .toList();
        return String.join("   ", words);
    }
}
