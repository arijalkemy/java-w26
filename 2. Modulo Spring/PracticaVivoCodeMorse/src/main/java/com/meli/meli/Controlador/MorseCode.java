package com.meli.meli.Controlador;
import com.meli.meli.Service.IEncodeDecode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/morse")
public class MorseCode {


    @Autowired
    IEncodeDecode morseEncoded;


        @GetMapping("/decode/{morseCode}")
        public String decode(@PathVariable String morseCode) {

            String morseDecoded = morseEncoded.decode(morseCode);
            return "Decoding morse code: " + morseDecoded;
        }

        @GetMapping("/encode/{word}")
        public String encode(@PathVariable String word) {
            String morseDecoded = morseEncoded.encode(word);
            return "Encoding text: " + morseDecoded;
        }
}
