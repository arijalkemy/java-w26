package bootcamp.bendezujonathan.cloth.controller.interfaces;


import bootcamp.bendezujonathan.cloth.dto.request.ClothRequest;
import bootcamp.bendezujonathan.cloth.dto.response.ClothResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/clothes")
public interface ClothController {

    @GetMapping
    ResponseEntity<List<ClothResponse>> getAll();

    @GetMapping("/{id}")
    ResponseEntity<ClothResponse> getById(@PathVariable long id);

    @GetMapping(value = "", params = "size")
    ResponseEntity<List<ClothResponse>> getAllBySize(@RequestParam String  size);

    @GetMapping(value = "", params = "name")
    ResponseEntity<List<ClothResponse>> getAllByName(@RequestParam String name);

    @PostMapping
    ResponseEntity<Void> postCloth(@RequestBody ClothRequest req);

    @PostMapping("/batch")
    ResponseEntity<Void> postBatchCloth(@RequestBody  List<ClothRequest> req);

    @PutMapping("/{id}")
    ResponseEntity<Void> putCloth(@PathVariable Long id, @RequestBody ClothRequest req);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteCloth(@PathVariable  Long id);

}
