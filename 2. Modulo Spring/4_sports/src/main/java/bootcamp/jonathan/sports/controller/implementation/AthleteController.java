package bootcamp.jonathan.sports.controller.implementation;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.jonathan.sports.controller.interfaces.IAthleteController;
import bootcamp.jonathan.sports.dto.AthleteDto;
import bootcamp.jonathan.sports.services.implementation.AthleteService;
import bootcamp.jonathan.sports.services.interfaces.ISportService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AthleteController implements IAthleteController {

    private final ISportService sportService;
    private final AthleteService athleteService;
    private final ModelMapper mapper;

    @Override
    public ResponseEntity<List<AthleteDto>> findAthlete() {
        List<AthleteDto> result = this.athleteService.findAthlete().stream().map(athete -> {
            AthleteDto dto = this.mapper
                                 .map(athete, AthleteDto.class);
                                    dto.setSportName(sportService.random().getName());
                                    return dto;})
                                 .toList();

        return ResponseEntity.ok(result);
    }

}
