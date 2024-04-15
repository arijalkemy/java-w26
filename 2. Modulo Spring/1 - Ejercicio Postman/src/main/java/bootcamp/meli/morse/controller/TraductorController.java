package bootcamp.meli.morse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.meli.morse.service.ITraductorService;

@RestController
@RequestMapping("/traductor")
public class TraductorController {
    
    @Autowired
    private ITraductorService service;

    @GetMapping("/spanish/{morse}")
    public String morseToSpanish(@PathVariable String morse){
        return this.service.morseToSpanish(morse);
    }

    @GetMapping("/morse/{spanish}")
    public String spanishToMorse(@PathVariable String spanish) {
        return this.service.spanishToMorse(spanish);
    }


}
