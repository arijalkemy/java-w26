package com.example.demo.Morse.Application.service;

import com.example.demo.Morse.Domain.MorseAlphabet;
import com.example.demo.Morse.Application.in.IMorseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class MoseServiceImpl implements IMorseService {


    @Override
    public String wordToMorse(String word) {
        String[] words = word.split(" ");
        StringBuilder sbResponse = new StringBuilder();
        String spaceMorse = "   ";

        Arrays.stream(words).forEach(w -> {
            String[] letterMorse = w.split("");
            StringBuilder sbWord = new StringBuilder();

            Arrays.stream(letterMorse).forEach(letter -> sbWord.append(MorseAlphabet.getCodeFromLetter(letter.toUpperCase())));
            sbResponse.append(sbWord).append(spaceMorse);
        });

        return sbResponse.toString().trim();
    }

    @Override
    public String morseToWord(String morse) {
        String[] words = morse.split(" {3}");
        StringBuilder sbResponse = new StringBuilder();

        Arrays.stream(words).forEach(word -> {
            String[] letterMorse = word.split(" ");
            StringBuilder sbWord = new StringBuilder();

            Arrays.stream(letterMorse).forEach(lm -> sbWord.append(MorseAlphabet.getLetterFromCode(lm)));
            sbResponse.append(sbWord).append(' ');
        });

        return sbResponse.toString().trim();
    }
}
