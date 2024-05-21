package bootcamp.bendezujonathan.hql.controller.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bootcamp.bendezujonathan.hql.dto.response.EpisodeResponse;

@RequestMapping("/episodes")
public interface EpisodeController {
    
    @GetMapping(value = "", params = "actor")
    ResponseEntity<List<EpisodeResponse>> getAllByActor(@RequestParam String actor);

}
