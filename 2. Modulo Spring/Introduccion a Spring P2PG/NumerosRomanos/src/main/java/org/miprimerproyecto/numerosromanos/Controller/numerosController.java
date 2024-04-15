package org.miprimerproyecto.numerosromanos.Controller;

import org.miprimerproyecto.numerosromanos.Conversor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class numerosController {

    @GetMapping("/numeroRomano/{numero}")
    public String numeroRomano(@PathVariable("numero") int numero) {

        return "El numero decimal: "+numero+" en numeros romanos es: "+Conversor.convertirANumeroRomano(numero);
    }
}
