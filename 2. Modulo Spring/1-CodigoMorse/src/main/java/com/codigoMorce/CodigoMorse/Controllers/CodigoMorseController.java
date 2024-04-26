package com.codigoMorce.CodigoMorse.Controllers;

import com.codigoMorce.CodigoMorse.service.ICodigoMorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/codigo-morse")
public class CodigoMorseController {

    @Autowired
    ICodigoMorseService morseCodeService;

    @GetMapping("/to-morse/{text}")
    public String convertToText(@PathVariable String text){
        return morseCodeService.convertToMorse(text);
    }

    @GetMapping("/to-text/{text}")
    public String convertToMorse(@PathVariable String text){
        return morseCodeService.convertToText(text);
    }
}
