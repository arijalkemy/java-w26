package org.bootcamp.morse.restcontroller;

import org.bootcamp.morse.service.MorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author jsanchezpimi
 */
@RestController
@RequestMapping("/morse")
public class MorseRestController {

    @Autowired
    MorseService morseService;

    @GetMapping("/obtener-texto")
    public String convertirTextoACodidoMorse(@RequestParam String codigoMorse) {
        return morseService.convertirCodigoMorseATexto(codigoMorse);
    }
    @GetMapping("/obtener-morse")
    public String convertirCodigoMorseATexto (@RequestParam String texto){
        return morseService.convertirTextoACodidoMorse(texto);
    }

}
