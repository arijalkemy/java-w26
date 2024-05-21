package bootcamp.bendezujonathan.hql.controller.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bootcamp.bendezujonathan.hql.dto.response.SerieResponse;

@RequestMapping("/series")
public interface SerieController {
    

    @GetMapping(value = "", params = "cantTemp")
    ResponseEntity<List<SerieResponse>> getAllByCantSeason(@RequestParam int cantTemp);


}
