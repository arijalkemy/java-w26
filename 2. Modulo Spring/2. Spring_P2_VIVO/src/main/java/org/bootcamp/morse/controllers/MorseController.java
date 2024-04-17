package org.bootcamp.morse.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.bootcamp.morse.service.IMorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/morse")
public class MorseController {
    @Autowired private IMorseService morseService;

    @GetMapping("decode/{text}")
    public String decode(@PathVariable String text) {
        return morseService.decode(text);
    }

    @GetMapping("encode/{text}")
    public String encode(@PathVariable String text) {
        return morseService.encode(text);
    }
}
