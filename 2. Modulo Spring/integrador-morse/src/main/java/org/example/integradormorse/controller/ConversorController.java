package org.example.integradormorse.controller;


import org.example.integradormorse.service.impl.ConversorServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ConversorController {

    private ConversorServiceImpl conversorService;

    public ConversorController(ConversorServiceImpl conversorService){
        this.conversorService = conversorService;
    }


    @GetMapping("/morse/{morse}")
    public String convertToText(@PathVariable String morse){
        return conversorService.convertToText(morse);
    }

    @GetMapping("/text/{text}")
    public String convertToMorse(@PathVariable String text){
        return conversorService.convertToMorse(text);
    }


}
