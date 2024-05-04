package com.meli.meli.Service.ServiceImpl;

import com.meli.meli.Service.IEncodeDecode;
import org.springframework.stereotype.Service;

import static com.meli.meli.Modelo.MorseDiccionary.morseDiccionary;

@Service
public class EncodeDecodeService implements IEncodeDecode {

    @Override
    public String encode(String morse)
    {

        char[] morseWords = morse.toUpperCase().toCharArray();
        StringBuilder palabra = new StringBuilder();

        for(char morseWord : morseWords) {
            morseDiccionary.forEach((key, value) -> {
                if (key.equals(morseWord)) {
                    palabra.append(value).append(" ");
                }
            });
        }


        return palabra.toString();

    }

    @Override
    public String decode(String morse) {
        String[] morseWords = morse.split("\\s+");
        StringBuilder palabra = new StringBuilder();

        for(String morseWord : morseWords) {
            morseDiccionary.forEach((key, value) -> {
                if (value.equals(morseWord)) {
                    palabra.append(key);
                }
            });
        }


        return palabra.toString();
    }
}
