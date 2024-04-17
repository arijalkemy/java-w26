package co.com.mercadolibre.starwars.controller;

import co.com.mercadolibre.starwars.service.ICustomCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/star-wars")
public class CustomCharacterController {

    @Autowired
    private ICustomCharacterService characterService;

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String name) {
        return ResponseEntity.ok(this.characterService.findByName(name));
    }
}
