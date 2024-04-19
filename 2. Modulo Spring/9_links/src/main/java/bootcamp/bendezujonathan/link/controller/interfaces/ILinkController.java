package bootcamp.bendezujonathan.link.controller.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bootcamp.bendezujonathan.link.dto.request.LinkRequest;
import bootcamp.bendezujonathan.link.dto.response.LinkResponse;

@RequestMapping("/link")
public interface ILinkController {
    
    @PostMapping
    ResponseEntity<LinkResponse> postLink(@RequestBody LinkRequest request);

    @GetMapping
    ResponseEntity<List<LinkResponse>> getAll();

    @GetMapping("/{linkId}")
    ResponseEntity<Void> getById(@PathVariable int linkId, @RequestParam String password);

    @PatchMapping("/invalidate/{id}")
    ResponseEntity<Void> patchInvalidate(@PathVariable int id);


}
