package com.example.demo.controller;

import com.example.demo.service.ITraductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/traductor")
public class TraductorController {

    @Autowired
    private ITraductorService traductorImpl;

    @GetMapping("/traducirCodigoMorse/{codigoMorse}")
    public String obtenerFraseEspanol(@PathVariable String codigoMorse) {
        return traductorImpl.obtenerFraseEspanol(codigoMorse);
    }

    @GetMapping("/traducirEspanol/{fraseEspanol}")
    public String obtenerCodigoMorse(@PathVariable String fraseEspanol) {
        return traductorImpl.obtenerCodigoMorse(fraseEspanol);
    }
}
