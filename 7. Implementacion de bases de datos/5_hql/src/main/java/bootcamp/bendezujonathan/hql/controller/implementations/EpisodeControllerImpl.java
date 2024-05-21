package bootcamp.bendezujonathan.hql.controller.implementations;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.bendezujonathan.hql.controller.interfaces.EpisodeController;
import bootcamp.bendezujonathan.hql.dto.response.EpisodeResponse;
import bootcamp.bendezujonathan.hql.service.interfaces.EpisodeService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EpisodeControllerImpl  implements EpisodeController {
    
    private final EpisodeService service;

    @Override
    public ResponseEntity<List<EpisodeResponse>> getAllByActor(String actor) {
        List<EpisodeResponse> res = service.findAllByActor(actor);

        return ResponseEntity.ok(res);
    }



}
