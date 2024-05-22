package bootcamp.vivo.obras.controller.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bootcamp.vivo.obras.dto.request.ObraRequest;
import bootcamp.vivo.obras.dto.response.ObraResponse;

@RequestMapping("/obras")
public interface ObraController {
    
    @GetMapping
    ResponseEntity<List<ObraResponse>> getAll();

    @PostMapping
    ResponseEntity<Void> postObra(@RequestBody ObraRequest req);

    @PostMapping("/batch")
    ResponseEntity<Void> postAllObra(@RequestBody List<ObraRequest> req);

    @GetMapping(value = "", params = "autor")
    ResponseEntity<List<ObraResponse>> getAllByAutorName(@RequestParam String autor);

    @GetMapping(value = "", params = "titulo")
    ResponseEntity<List<ObraResponse>> getAllByTitle(@RequestParam String titulo);

    @GetMapping(value = "", params = "year")
    ResponseEntity<List<ObraResponse>> getAllBeforeYear(@RequestParam int year);


    @GetMapping(value = "", params = "editorial")
    ResponseEntity<List<ObraResponse>> getAllByEditorial(@RequestParam String editorial);


    @GetMapping("/top5")
    ResponseEntity<List<ObraResponse>> getTop5CantidadPaginas();
}
