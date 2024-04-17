package bootcamp.jonathan.sports.controller.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import bootcamp.jonathan.sports.dto.AthleteDto;

@RequestMapping("/athlete")
public interface IAthleteController {
    
    @GetMapping
    public ResponseEntity<List<AthleteDto>> findAthlete();
}
