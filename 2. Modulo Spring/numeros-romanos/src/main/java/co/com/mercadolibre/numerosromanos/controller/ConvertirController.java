package co.com.mercadolibre.numerosromanos.controller;

import co.com.mercadolibre.numerosromanos.service.IConvertirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("convertir")
public class ConvertirController {

    @Autowired
    private IConvertirService convertirService;

    @GetMapping(value = "/{numero}", produces = "application/json")
    public ResponseEntity<String> convertir(@PathVariable("numero") Integer numero) {
        return new ResponseEntity<String>(convertirService.convertir(numero), HttpStatus.OK);
    }
}
