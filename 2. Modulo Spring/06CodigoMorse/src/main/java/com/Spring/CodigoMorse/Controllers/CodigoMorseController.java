package com.Spring.CodigoMorse.Controllers;

import com.Spring.CodigoMorse.Services.IConversorMorseEspanol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class CodigoMorseController {

    @Autowired
    IConversorMorseEspanol conversorMorseAEspanol;

    @GetMapping("/convertirATexto/{codigoMorse}")
    public String convertirMorseATexto(@PathVariable String codigoMorse) {
        return conversorMorseAEspanol.convertirAEspanol(codigoMorse);
    }

    @GetMapping("/convertirAMorse/{texto}")
    public String convertirAMorse(@PathVariable String texto) {
        return conversorMorseAEspanol.convertirAMorse(texto);
    }
}
