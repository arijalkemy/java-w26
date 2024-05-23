package com.bootcamp.joyerialasperlas.controller;

import com.bootcamp.joyerialasperlas.models.Jewel;
import com.bootcamp.joyerialasperlas.service.IJewelryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewelry")
public class JewelryController {

    private final IJewelryService jewelryService;

    public JewelryController(IJewelryService jewelryService) {
        this.jewelryService = jewelryService;
    }

    @PostMapping("/new")
    public ResponseEntity<?> postJewel(@RequestBody Jewel j){
        return new ResponseEntity<>(jewelryService.addJewel(j), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> getAllJewels(){
        return new ResponseEntity<>(jewelryService.getAllJewels(),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJewel(@PathVariable Long id){
        return new ResponseEntity<>(jewelryService.deleteJewel(id),HttpStatus.OK);
    }

    @PutMapping("/update/{id_modificar}")
    public ResponseEntity<?> updateJewel(@PathVariable Long id_modificar,@RequestBody Jewel j){
        return new ResponseEntity<>(jewelryService.modifyJewelParticularity(id_modificar,j),HttpStatus.OK);
    }



}
