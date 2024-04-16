package com.example.demo.controller;

import com.example.demo.service.ICodigoMorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/codigoMorse")
public class CodigoMorseController {

    @Autowired
    private ICodigoMorseService codigoMorseImpl;

    @GetMapping("/traductorMorse/{codigoMorse}")
    public String codigoMorseAEspanol(@PathVariable String codigoMorse) {
        return codigoMorseImpl.traducirAEspanol(codigoMorse);
    }

    @GetMapping("/traductorEspanol/{fraseEspanol}")
    public String fraseEspanolAMorse(@PathVariable String fraseEspanol) {
        return codigoMorseImpl.traducirAMorse(fraseEspanol);
    }
}
