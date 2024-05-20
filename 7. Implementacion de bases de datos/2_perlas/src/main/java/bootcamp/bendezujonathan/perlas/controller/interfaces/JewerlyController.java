package bootcamp.bendezujonathan.perlas.controller.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import bootcamp.bendezujonathan.perlas.dto.request.JewerlyRequest;
import bootcamp.bendezujonathan.perlas.dto.response.JewerlyResponse;
import bootcamp.bendezujonathan.perlas.dto.response.MessageResponse;

@RequestMapping("/jewerly")
public interface JewerlyController {
    
    @PostMapping
    ResponseEntity<MessageResponse> postJwerly(@RequestBody JewerlyRequest req);

    @GetMapping
    ResponseEntity<List<JewerlyResponse>> getAll();

    @GetMapping("/{id}")
    ResponseEntity<JewerlyResponse> getById(@PathVariable long id);

    @PutMapping("/{id}")
    ResponseEntity<Void> updateJewerly(@PathVariable long id, @RequestBody JewerlyRequest req);

    @DeleteMapping("/{id}")
    ResponseEntity<MessageResponse> deleteJewerly(@PathVariable long id);


}
