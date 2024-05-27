package org.responseentity.showroom.controller;

import org.responseentity.showroom.dto.PrendaDTO;
import org.responseentity.showroom.dto.PrendaDTORequest;
import org.responseentity.showroom.service.PrendaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clothes")
public class PrendaController {

    @Autowired
    private PrendaServiceImp prendaService;

    @PostMapping
    public ResponseEntity<?> createNewClothes(@RequestBody PrendaDTORequest prendaDTO){
        return new ResponseEntity<>(prendaService.createNewClothes(prendaDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllClothes(){
        return new ResponseEntity<>(prendaService.getAllClothes(), HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<?> getClothesByCode(@PathVariable Long code){
        return new ResponseEntity<>(prendaService.getClothesByCode(code), HttpStatus.OK);
    }

    @GetMapping("/talla/{size}")
    public ResponseEntity<?> getAllClothesBySize(@PathVariable String size){
        return new ResponseEntity<>(prendaService.getAllClothesBySize(size), HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> deleteClothesById(@PathVariable Long code){
        prendaService.deleteClothesById(code);
        return new ResponseEntity<>("eliminado", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateClothes(@PathVariable("id") Long id, @RequestBody PrendaDTORequest prendaDTORequest){
        return new ResponseEntity<>(prendaService.updateClothes(id, prendaDTORequest), HttpStatus.OK);
    }

}
