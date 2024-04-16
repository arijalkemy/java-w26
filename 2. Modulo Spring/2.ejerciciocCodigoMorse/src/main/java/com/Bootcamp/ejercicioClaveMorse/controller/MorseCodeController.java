package com.Bootcamp.ejercicioClaveMorse.controller;
import com.Bootcamp.ejercicioClaveMorse.service.ImorseCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Morse")
public class MorseCodeController {

    @Autowired
    ImorseCodeService morseCodeService;
    @GetMapping("/encode/{data}")
    public String encodeMorse(@PathVariable String data){
        return morseCodeService.encodeMorse(data);
    }

    @GetMapping("/decode/{data}")
    public String decodeMorse(@PathVariable String data){
        return morseCodeService.decodeMorse(data);
    }
}
