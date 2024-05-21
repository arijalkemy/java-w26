package bootcamp.bendezujonathan.hql.controller.implementations;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.bendezujonathan.hql.controller.interfaces.SerieController;
import bootcamp.bendezujonathan.hql.dto.response.SerieResponse;
import bootcamp.bendezujonathan.hql.service.interfaces.SerieService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SerieControllerImpl implements SerieController {
    
    private final SerieService serieService;

    @Override
    public ResponseEntity<List<SerieResponse>> getAllByCantSeason(int cantTemp) {
        List<SerieResponse> res = serieService.findAllByCantSeason(cantTemp);
        return ResponseEntity.ok(res);
    }



}
