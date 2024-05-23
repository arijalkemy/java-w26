package com.example.tiendaropa.controller;
import com.example.tiendaropa.models.Dto.PrendaRequestDto;
import com.example.tiendaropa.models.Dto.PrendaResponseDto;
import com.example.tiendaropa.service.IPrendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class PrendaController {

    @Autowired
    IPrendaService prendaService;

    //Crear una Prenda
    @PostMapping("/clothes")
    public ResponseEntity<?> createPrenda(@RequestBody PrendaRequestDto prendaRequestDto) {
        return new ResponseEntity<>(prendaService.postNewPrenda(prendaRequestDto),HttpStatus.CREATED);
    }

    //    Obtener todas las prendas
    @GetMapping("/clothes")
    public ResponseEntity<?> getAllPrendas() {
        return new ResponseEntity<>(prendaService.getAllPrendas(), HttpStatus.OK);
    }

    //    Devolver una prenda en particular
    @GetMapping("/clothes/{id}")
    public ResponseEntity<PrendaResponseDto> getPrendaById(@PathVariable Long id){
        return new ResponseEntity<>(prendaService.findPrendaById(id), HttpStatus.OK);
    }

    //    Actualizar una prenda en particular
    @PutMapping("/clothes/{id}")
    public ResponseEntity<PrendaResponseDto> updatePrenda(@PathVariable Long id, @RequestBody PrendaRequestDto prendaRequestDto){
        return new ResponseEntity<>(prendaService.updatePrenda(id, prendaRequestDto), HttpStatus.OK);
    }

    //    Traer todas las prendas de un determinado talle
    @GetMapping("/clothes/size/{talla}")
    public ResponseEntity<List<PrendaResponseDto>> getPrendaBySize(@PathVariable String talla) {
        return new ResponseEntity<>(prendaService.findPrendasBySize(talla), HttpStatus.OK);
    }
    //    Buscar todas las prendas en cuyo nombre aparezca la palabra "remera". No se tienen en cuenta ni mayúsculas ni minúsculas
    @GetMapping(value = "/clothes" , params = "name")
    public ResponseEntity<List<PrendaResponseDto>> getPrendaByName(@RequestParam String name){
        return new ResponseEntity<>(prendaService.findByName(name), HttpStatus.OK);
    }

    //Eliminar una prenda en particular
    @DeleteMapping("/clothes/{id}")
    public ResponseEntity<String> deletePrenda(@PathVariable Long id){
        return new ResponseEntity<>(prendaService.deletePrenda(id), HttpStatus.OK);
    }
}
