package bootcamp.bendezujonathan.covid.controller.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bootcamp.bendezujonathan.covid.dto.response.PersonResponse;

@RequestMapping("/person")
public interface IPersonController {
    
    @GetMapping("/risk")
    public ResponseEntity<List<PersonResponse>> getPersonsByAgeAndRisk(@RequestParam Integer age);

}
