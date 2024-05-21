package com.example.joyeria.controller;

import com.example.joyeria.model.Jewel;
import com.example.joyeria.service.IJewelryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JewelryController {
    @Autowired
    IJewelryService jewelryService;

    @PostMapping("/jewelry/new")
    public ResponseEntity<?> addJewel(@RequestBody Jewel jewel){
        return jewelryService.saveJewel(jewel);
    }

    @GetMapping("/jewelry")
    public List<Jewel> listJewels(){
        return jewelryService.getJewels();
    }

    @PutMapping("/jewelry/delete/{id}")
    public ResponseEntity<?> deleteJewel(@PathVariable Long id){
       return jewelryService.deleteJewel(id);
    }

    @PutMapping("/jewelry/update/{id_modificar}")
    public ResponseEntity<?> editJewel(@PathVariable Long id_modificar,
                                       @RequestBody Jewel jewel){
        return jewelryService.editJewel(id_modificar,jewel);
    }

}
