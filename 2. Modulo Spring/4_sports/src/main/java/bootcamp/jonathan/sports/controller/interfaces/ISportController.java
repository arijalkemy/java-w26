package bootcamp.jonathan.sports.controller.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import bootcamp.jonathan.sports.dto.SportDto;

@RequestMapping("/sports")
public interface ISportController {
    
    @GetMapping
    public ResponseEntity<List<SportDto>> findAllSports();

    @GetMapping("/{name}")
    public ResponseEntity<SportDto> findSportByName(@PathVariable String name);
}
