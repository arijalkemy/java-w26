package jpa.ejercicioelasticsearch.controller;

import jpa.ejercicioelasticsearch.dto.reponseDTO.ObraliterariaResponseDto;
import jpa.ejercicioelasticsearch.dto.requestDTO.ObraLiterariaRequestDto;
import jpa.ejercicioelasticsearch.model.ObraLiteraria;
import jpa.ejercicioelasticsearch.service.IObraLiterariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obras-literarias")
public class ObraLiterariaController {

    @Autowired
    private IObraLiterariaService obraService;

    @PostMapping
    public ResponseEntity<ObraliterariaResponseDto> createObraLiteraria(
            @RequestBody ObraLiterariaRequestDto obraLiteraria) {
        return ResponseEntity.status(HttpStatus.CREATED).body(obraService.saveObraLiteraria(obraLiteraria));
    }

    @PostMapping("/create")
    public ResponseEntity<List<ObraliterariaResponseDto>> createObrasLiterarias(
            @RequestBody List<ObraLiterariaRequestDto> obrasLiterarias) {
        return ResponseEntity.status(HttpStatus.CREATED).body(obraService.saveAllObrasLiterarias(obrasLiterarias));
    }

    @GetMapping("/autor/{author}")
    public ResponseEntity<List<ObraliterariaResponseDto>> getObrasLiterariasByAuthor(
            @PathVariable String author) {
        return ResponseEntity.status(HttpStatus.OK).body(obraService.getAllByAuthor(author));
    }

    @GetMapping("/titulo/{title}")
    public ResponseEntity<List<ObraliterariaResponseDto>> getObrasLiterariasByKeyWordTitulo(
            @PathVariable String title) {
        return ResponseEntity.status(HttpStatus.OK).body(this.obraService.getAllObrasByKeyWordTitle(title));
    }

    @GetMapping("/paginas/top-5")
    public ResponseEntity<List<ObraliterariaResponseDto>> getTopFiveObrasLiterariasByNumberPages() {
        return ResponseEntity.status(HttpStatus.OK).body(this.obraService.getTopFiveObrasLiterariasByNumberPage());
    }

    @GetMapping("/año-publicacion/{year}")
    public ResponseEntity<List<ObraliterariaResponseDto>> getObrasLiterariasByYearBefore(@PathVariable int year) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.obraService.getObrasLiterariasByYearPublicationBefore(year));
    }

   @GetMapping("/editorial/{editorial}")
    public ResponseEntity<List<ObraliterariaResponseDto>> getObrasLiterariasEditorial(@PathVariable String editorial) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.obraService.getObrasLiterariasByEditorial(editorial));
    }

}
