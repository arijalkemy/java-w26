package com.example.movieshqlasync.controller;

import com.example.movieshqlasync.dto.request.ClotheRequestDto;
import com.example.movieshqlasync.service.IClotheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clothe")
public class ClotheController {
    @Autowired
    IClotheService iClotheService;

    @PostMapping
    public ResponseEntity<?> postClothe(@RequestBody ClotheRequestDto clotheRequestDto){
        return new ResponseEntity<>(iClotheService.addClothe(clotheRequestDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllClothes(){
        return new ResponseEntity<>(iClotheService.getAllClothes(), HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<?> getClotheById(@PathVariable int code){
        return new ResponseEntity<>(iClotheService.getClotheById(code), HttpStatus.OK);
    }

    @PutMapping("/{code}")
    public ResponseEntity<?> editClothe(@PathVariable int code,
                                        @RequestBody ClotheRequestDto clotheRequestDto){
        return new ResponseEntity<>(iClotheService.editClothe(code, clotheRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> deleteClothe(@PathVariable int code){
        iClotheService.deleteClothe(code);
        return new ResponseEntity<>("Eliminada con exito", HttpStatus.OK);
    }

    @GetMapping("/{size}")
    public ResponseEntity<?> getClothesBySize(@PathVariable String size){
        return new ResponseEntity<>(iClotheService.getClothesBySize(size), HttpStatus.OK);
    }

    @GetMapping("/clothes")
    public ResponseEntity<?> getClotheByName(@RequestParam String name){
        return new ResponseEntity<>(iClotheService.getClothesByTShirt(name), HttpStatus.OK);
    }

}
