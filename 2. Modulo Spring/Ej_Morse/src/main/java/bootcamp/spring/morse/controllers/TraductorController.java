package bootcamp.spring.morse.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.spring.morse.services.TraductorService;

@RestController
@RequestMapping("/traducir")
public class TraductorController {
    
    private final TraductorService traductorService;
    public TraductorController(TraductorService traductorService){
        this.traductorService = traductorService;
    }

    @GetMapping("/espanol")
    public ResponseEntity<String> traducirMorseEspanol(@RequestParam String morse){
        String traduccion = this.traductorService.traducirMorse(morse);
        return ResponseEntity.ok(traduccion);
    }

    @GetMapping("/morse")
    public ResponseEntity<String> traducirEspanolMorse(@RequestParam String espanol){
        String traduccion = this.traductorService.traducirEspanol(espanol);
        return ResponseEntity.ok(traduccion);
    }
}
