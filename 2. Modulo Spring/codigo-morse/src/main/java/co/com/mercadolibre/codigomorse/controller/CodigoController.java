package co.com.mercadolibre.codigomorse.controller;

import co.com.mercadolibre.codigomorse.service.ICodigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("codigo")
public class CodigoController {

    @Autowired
    private ICodigoService codigoService;

    @GetMapping("/morse")
    public ResponseEntity<String> morseANormal(@RequestParam("morse") String morse) {
        return new ResponseEntity<>(codigoService.convertirDeMorseANormal(morse) ,HttpStatus.OK);
    }

    @GetMapping("/normal")
    public ResponseEntity<String> normalAMorse(@RequestParam("normal") String normal) {
        return new ResponseEntity<>(codigoService.convertirDeNormalAMorse(normal), HttpStatus.OK);
    }


}
