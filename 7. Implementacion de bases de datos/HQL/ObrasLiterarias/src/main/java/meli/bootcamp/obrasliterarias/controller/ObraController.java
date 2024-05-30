package meli.bootcamp.obrasliterarias.controller;

import lombok.RequiredArgsConstructor;
import meli.bootcamp.obrasliterarias.model.ObraLiteraria;
import meli.bootcamp.obrasliterarias.service.ObraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obras")
@RequiredArgsConstructor
public class ObraController {

    private final ObraService obraService;

    @PostMapping
    public ResponseEntity<ObraLiteraria> newObra(@RequestBody ObraLiteraria obraLiteraria){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(obraService.create(obraLiteraria));
    }

    @GetMapping("/autor/{autor}")
    public ResponseEntity<List<ObraLiteraria>> getObrasByAutor(@PathVariable String autor){
        return ResponseEntity.ok(obraService.getObraLiterariasByAutor(autor));
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<ObraLiteraria>> getObrasByNombre(@PathVariable String nombre){
        return ResponseEntity.ok(obraService.getObraLiterariasByNombreContaining(nombre));
    }

    @GetMapping("/top-5-total-paginas")
    public ResponseEntity<List<ObraLiteraria>> getObrasTopCinco(){
        return ResponseEntity.ok(obraService.getTop5ByOrderByCantidadPaginasDesc());
    }

    @GetMapping("/publicacion-antes/{anio}")
    public ResponseEntity<List<ObraLiteraria>> getObrasByAnio(@PathVariable Integer anio){
        return ResponseEntity.ok(obraService.getAllByAnioPrimeraPublicacionBefore(anio));
    }

    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<List<ObraLiteraria>> getObrasByEditorial(@PathVariable String editorial){
        return ResponseEntity.ok(obraService.getAllByEditorialEqualsIgnoreCase(editorial));
    }
}
