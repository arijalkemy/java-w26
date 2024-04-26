package org.example.MorseCodigo.controladores;
import org.example.MorseCodigo.service.Espanol;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
/*Definicion de controlador REST*/
@RestController
public class EspanolController {
    @PostMapping("/translateE")
    /* Peticion que indica que un método en un controlador debe ser invocado cuando se realiza una solicitud
    POST a una URL específica.
     */
    public String translateS(@RequestBody Espanol espanol){
        return espanol.translateE(espanol.getCodes());
    }

}
