package codigomorse.controllers;

import codigomorse.model.CodigoMorse;
import codigomorse.model.Espanol;
import codigomorse.servicios.CodigoMorseServicio;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TraductorController {

    private final CodigoMorseServicio codigoMorseServicio;

    public TraductorController(CodigoMorseServicio codigoMorseServicio) {
        this.codigoMorseServicio = codigoMorseServicio;
    }

    @PostMapping("/codigo-morse-a-espanol")
    public String convertirCodigoMorse(@RequestBody CodigoMorse codigoMorse){
        return codigoMorseServicio.convertirOracionDeCodigoMorseAPalabra(codigoMorse.getCodigoMorse());
    }

    @PostMapping("/espanol-a-codigo-morse")
    public String convertirEspanol(@RequestBody Espanol oracion){
        return codigoMorseServicio.convertirOracionDeEspanolACodigoMorse(oracion.getOracion());
    }
}
