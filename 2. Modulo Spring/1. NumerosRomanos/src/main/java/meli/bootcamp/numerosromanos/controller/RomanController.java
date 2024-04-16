package meli.bootcamp.numerosromanos.controller;

import meli.bootcamp.numerosromanos.service.RomanNumber;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roman")
public class RomanController {


    @GetMapping("/convert/{number}")
    public String convert(@PathVariable int number){
        return String.format("The number %s converted to Roman is: %s", number, RomanNumber.convertToRoman(number));
    }
}
