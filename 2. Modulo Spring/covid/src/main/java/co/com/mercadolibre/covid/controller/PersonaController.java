package co.com.mercadolibre.covid.controller;

import co.com.mercadolibre.covid.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private IPersonaService personaService;

    @GetMapping(path = "/buscarPersonasConRiesgo")
    public ResponseEntity<?> buscarPersonasConRiesgo() {
        return ResponseEntity.ok(this.personaService.listar());
    }
}
