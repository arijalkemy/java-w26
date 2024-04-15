package com.example.codigoMorse.Service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MorseServiceImpl implements MorseService{

    @Override
    public String morseToWords(String morse) {
        Map<String, String> translations = Map.ofEntries(
                new AbstractMap.SimpleEntry<>(".-", "a"),
                new AbstractMap.SimpleEntry<>("-...", "b"),
                new AbstractMap.SimpleEntry<>("-.-.", "c"),
                new AbstractMap.SimpleEntry<>("-..", "d"),
                new AbstractMap.SimpleEntry<>(".", "e"),
                new AbstractMap.SimpleEntry<>("..-.", "f"),
                new AbstractMap.SimpleEntry<>("--.", "g"),
                new AbstractMap.SimpleEntry<>("....", "h"),
                new AbstractMap.SimpleEntry<>("..", "i"),
                new AbstractMap.SimpleEntry<>(".---", "j"),
                new AbstractMap.SimpleEntry<>("-.-", "k"),
                new AbstractMap.SimpleEntry<>(".-..", "l"),
                new AbstractMap.SimpleEntry<>("--", "m"),
                new AbstractMap.SimpleEntry<>("-.", "n"),
                new AbstractMap.SimpleEntry<>("---", "o"),
                new AbstractMap.SimpleEntry<>(".--.", "p"),
                new AbstractMap.SimpleEntry<>("--.-", "q"),
                new AbstractMap.SimpleEntry<>(".-.", "r"),
                new AbstractMap.SimpleEntry<>("...", "s"),
                new AbstractMap.SimpleEntry<>("-", "t"),
                new AbstractMap.SimpleEntry<>("..-", "u"),
                new AbstractMap.SimpleEntry<>("...-", "v"),
                new AbstractMap.SimpleEntry<>(".--", "w"),
                new AbstractMap.SimpleEntry<>("-..-", "x"),
                new AbstractMap.SimpleEntry<>("-.--", "y"),
                new AbstractMap.SimpleEntry<>("--..", "z"),
                new AbstractMap.SimpleEntry<>(".----", "1"),
                new AbstractMap.SimpleEntry<>("..---", "2"),
                new AbstractMap.SimpleEntry<>("...--", "3"),
                new AbstractMap.SimpleEntry<>("....-", "4"),
                new AbstractMap.SimpleEntry<>(".....", "5"),
                new AbstractMap.SimpleEntry<>("-....", "6"),
                new AbstractMap.SimpleEntry<>("--...", "7"),
                new AbstractMap.SimpleEntry<>("---..", "8"),
                new AbstractMap.SimpleEntry<>("----.", "9"),
                new AbstractMap.SimpleEntry<>("-----", "0"),
                new AbstractMap.SimpleEntry<>("..--..", "?"),
                new AbstractMap.SimpleEntry<>("-.-.--", "!"),
                new AbstractMap.SimpleEntry<>("--..--", ","),
                new AbstractMap.SimpleEntry<>(".-.-.-", ".")
        );
        String[] morseWords = morse.split("   ");
        List<String> results = new ArrayList<>();
        for(String morses: morseWords){
            String[] aux = morses.split(" ");
            for(String morseLetter: aux){
                results.add(translations.get(morseLetter));
            }
        }
        String result = results.stream().collect(Collectors.joining());
        return result;
    }

    @Override
    public String textToMorse(String text) {
        Map<Character, String> translations = Map.ofEntries(
                new AbstractMap.SimpleEntry<>('a', ".-"),
                new AbstractMap.SimpleEntry<>('b', "-..."),
                new AbstractMap.SimpleEntry<>('c', "-.-."),
                new AbstractMap.SimpleEntry<>('d', "-.."),
                new AbstractMap.SimpleEntry<>('e', "."),
                new AbstractMap.SimpleEntry<>('f', "..-."),
                new AbstractMap.SimpleEntry<>('g', "..-."),
                new AbstractMap.SimpleEntry<>('h', "...."),
                new AbstractMap.SimpleEntry<>('i', ".."),
                new AbstractMap.SimpleEntry<>('j', ".---"),
                new AbstractMap.SimpleEntry<>('k', "-.-"),
                new AbstractMap.SimpleEntry<>('l', ".-.."),
                new AbstractMap.SimpleEntry<>('m', "--"),
                new AbstractMap.SimpleEntry<>('n', "-."),
                new AbstractMap.SimpleEntry<>('o', "---"),
                new AbstractMap.SimpleEntry<>('p', ".--."),
                new AbstractMap.SimpleEntry<>('q', "--.-"),
                new AbstractMap.SimpleEntry<>('r', ".-."),
                new AbstractMap.SimpleEntry<>('s', "..."),
                new AbstractMap.SimpleEntry<>('t', "-"),
                new AbstractMap.SimpleEntry<>('u', "..-"),
                new AbstractMap.SimpleEntry<>('v', "...-"),
                new AbstractMap.SimpleEntry<>('w', ".--"),
                new AbstractMap.SimpleEntry<>('x', "-..-"),
                new AbstractMap.SimpleEntry<>('y', "-.--"),
                new AbstractMap.SimpleEntry<>('z', "--.."),
                new AbstractMap.SimpleEntry<>('1', ".----"),
                new AbstractMap.SimpleEntry<>('2', "..---"),
                new AbstractMap.SimpleEntry<>('3', "...--"),
                new AbstractMap.SimpleEntry<>('4', "....-"),
                new AbstractMap.SimpleEntry<>('5', "....."),
                new AbstractMap.SimpleEntry<>('6', "-...."),
                new AbstractMap.SimpleEntry<>('7', "--..."),
                new AbstractMap.SimpleEntry<>('8', "---.."),
                new AbstractMap.SimpleEntry<>('9', "----."),
                new AbstractMap.SimpleEntry<>('0', "-----"),
                new AbstractMap.SimpleEntry<>('?', "..--.."),
                new AbstractMap.SimpleEntry<>('!', "-.-.--"),
                new AbstractMap.SimpleEntry<>(',', "--..--"),
                new AbstractMap.SimpleEntry<>('.', ".-.-.-")
        );
        text = text.toLowerCase();
        String[] textWords = text.split(" ");
        String results = "";
        for(String word: textWords){
            for(int i = 0; i < word.length(); i++) {
                results += translations.get(word.charAt(i));
                results += " ";
            }
            results += "  ";
        }
        results.trim();
        return results;
    }
}
