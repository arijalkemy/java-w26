package com.example.introduccion_a_springp2vivo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class morseController {

    @Autowired
    IMorseService morseService;

    @GetMapping("/toMorse/{words}")
    ResponseEntity<ResponseDTO> convertToMorse(@PathVariable String words){
        return new ResponseEntity<>(morseService.toMorse(words), HttpStatus.OK);
    }

    @GetMapping("/toStrings/{morse}")
    ResponseEntity<ResponseDTO> convertToWords(@PathVariable String morse){
        return new ResponseEntity<>(morseService.toChars(morse), HttpStatus.OK);
    }
}
