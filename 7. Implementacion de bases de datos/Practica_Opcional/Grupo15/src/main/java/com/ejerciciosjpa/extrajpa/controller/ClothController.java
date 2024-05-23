package com.ejerciciosjpa.extrajpa.controller;

import com.ejerciciosjpa.extrajpa.dto.ClothRequestDto;
import com.ejerciciosjpa.extrajpa.service.IClotheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clothes")
public class ClothController {

    @Autowired
    IClotheService clothService;

    @PostMapping()
    public ResponseEntity<?> addCloth(@RequestBody ClothRequestDto request){
        return new ResponseEntity<>(clothService.addCloth(request), HttpStatus.CREATED);
    }
    @GetMapping()
    public ResponseEntity<?> getAllClothes(){
        return new ResponseEntity<>(clothService.getAllClothes(),HttpStatus.OK);
    }
    @GetMapping("/code/{code}")
    public ResponseEntity<?> getClothesByCode(@PathVariable Long code){
        return new ResponseEntity<>(clothService.getClothByCode(code),HttpStatus.OK);
    }
    @PutMapping("/{code}")
    public ResponseEntity<?> updateClothe(@PathVariable Long code,@RequestBody ClothRequestDto request){
        return new ResponseEntity<>(clothService.updateCloth(code,request),HttpStatus.OK);
    }
    @DeleteMapping("/{code}")
    public ResponseEntity<?> deleteCloth(@PathVariable Long code){
        clothService.deleteClothById(code);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/size/{size}")
    public ResponseEntity<?> getClothBySize(@PathVariable Integer size){
        return new ResponseEntity<>(clothService.getClothBySize(size),HttpStatus.OK);
    }
    @GetMapping("/query")
    public ResponseEntity<?> getClothByKeyWord(@RequestParam String name){
        return new ResponseEntity<>(clothService.getClothesByKey(name),HttpStatus.OK);
    }


}
