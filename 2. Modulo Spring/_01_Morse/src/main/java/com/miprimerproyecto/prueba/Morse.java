package com.miprimerproyecto.prueba;

import com.miprimerproyecto.prueba.servicios.IMorse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/{morse}")
public class Morse {
    @Autowired
    IMorse morseService;

    @GetMapping
    public String saludar(@PathVariable String morse){
        return morseService.obtenerResultadoEnEspanol(morse);
    }
}
