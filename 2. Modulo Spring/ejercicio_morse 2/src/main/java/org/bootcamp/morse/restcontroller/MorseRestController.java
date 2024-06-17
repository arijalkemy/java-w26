package org.bootcamp.morse.restcontroller;

import org.bootcamp.morse.service.MorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/morse")
public class MorseRestController {


    @Autowired
    MorseService morseService;

    @GetMapping("/obtener-texto")
    public String obtenerTextoAlfanumerico(@RequestParam String codigoMorse) {
        return morseService.obtenerTextoAlfanumerico(codigoMorse);
    }
    @GetMapping("/obtener-morse")
    public String obtenerCodigoMorse (@RequestParam String texto){
        return morseService.obtenerCodidoMorse(texto);
    }

}
