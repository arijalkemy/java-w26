package com.example.introduccion_a_springp2pg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanController {
    @Autowired
    IRomanService romanService;


    @GetMapping("/toNumber/{romanNumber}")
    ResponseEntity <ResponseDTO> romanToNumber(@PathVariable String romanNumber){
        return new ResponseEntity<>(romanService.toNumber(romanNumber), HttpStatus.OK);
    }

    @GetMapping("/toRoman/{number}")
    ResponseEntity <ResponseDTO> numberToRoman(@PathVariable Integer number){
        return new ResponseEntity<>(romanService.toRoman(number), HttpStatus.OK);
    }
}
