package bootcamp.jonathan.sports.controller.implementation;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.jonathan.sports.controller.interfaces.ISportController;
import bootcamp.jonathan.sports.dto.SportDto;
import bootcamp.jonathan.sports.model.Sport;
import bootcamp.jonathan.sports.services.interfaces.ISportService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SportController implements ISportController {

    private final ISportService service;
    private final ModelMapper mapper;

    @Override
    public ResponseEntity<List<SportDto>> findAllSports() {
        List<SportDto> result = this.service
                                    .findSports()
                                    .stream()
                                    .map(sport -> mapper.map(sport, SportDto.class)).toList();

        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<SportDto> findSportByName(String name) {
        Sport founded = this.service.findByName(name);
        return ResponseEntity.ok(mapper.map(founded, SportDto.class));
    }
    
}
