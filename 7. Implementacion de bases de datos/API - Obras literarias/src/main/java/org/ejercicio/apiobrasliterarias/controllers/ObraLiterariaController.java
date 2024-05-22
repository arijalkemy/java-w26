package org.ejercicio.apiobrasliterarias.controllers;

import org.ejercicio.apiobrasliterarias.dtos.ObraLiterariaDto;
import org.ejercicio.apiobrasliterarias.dtos.ObraLiterariaRequestDto;
import org.ejercicio.apiobrasliterarias.services.IObraLiterariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("obras-literarias")
public class ObraLiterariaController {

    @Autowired
    private IObraLiterariaService obraLiterariaService;

    @PostMapping
    public ResponseEntity<ObraLiterariaDto> create(@RequestBody ObraLiterariaRequestDto obraLiteraria) {
        return new ResponseEntity<>(obraLiterariaService.save(obraLiteraria) , HttpStatus.CREATED);
    }

    @PostMapping("save-all")
    public ResponseEntity<List<ObraLiterariaDto>> saveAll(@RequestBody List<ObraLiterariaDto> obrasLiteraria) {
        return new ResponseEntity<>(obraLiterariaService.saveAll(obrasLiteraria) , HttpStatus.CREATED);
    }

    @GetMapping("autor/{nombreAutor}")
    public ResponseEntity<List<ObraLiterariaDto>> findByNombreAutor(@PathVariable String nombreAutor) {
        return new ResponseEntity<>(obraLiterariaService.findByAutor(nombreAutor) , HttpStatus.OK);
    }

    @GetMapping("tituloLike/{titulo}")
    public ResponseEntity<List<ObraLiterariaDto>> findByTitulo(@PathVariable String titulo) {
        return new ResponseEntity<>(obraLiterariaService.findByNombreContainingIgnoreCase(titulo) , HttpStatus.OK);
    }

    @GetMapping("top5-obras-masPaginas")
    public ResponseEntity<List<ObraLiterariaDto>> findTop5ObrasConMasPaginas() {
        return new ResponseEntity<>(obraLiterariaService.findTop5ByOrderByCantidadDePaginasDesc() , HttpStatus.OK);
    }

    @GetMapping("antes-de-fecha/{anio}")
    public ResponseEntity<List<ObraLiterariaDto>> findByAntesDeAnio(@PathVariable Integer anio) {
        return new ResponseEntity<>(obraLiterariaService.findByAnioPrimeraPublicacionBefore(anio) , HttpStatus.OK);
    }

    @GetMapping("editorial/{editorial}")
    public ResponseEntity<List<ObraLiterariaDto>> findByEditorial(@PathVariable String editorial) {
        return new ResponseEntity<>(obraLiterariaService.findByEditorial(editorial) , HttpStatus.OK);
    }
}
