package com.ejerciciosjpa.jewelry.controller;


import com.ejerciciosjpa.jewelry.dto.JewelResponseDto;
import com.ejerciciosjpa.jewelry.entity.Jewel;
import com.ejerciciosjpa.jewelry.service.IJewelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JewelController {
    @Autowired
    IJewelService jewelService;

    @PostMapping("/jewelry/new")
    public JewelResponseDto saveStudent(@RequestBody Jewel jewel){
        return jewelService.create(jewel);
    }
    @GetMapping("/jewelry")
    public List<Jewel> getAllJewels(){
        return jewelService.getJewelCatalogue();
    }
    @PostMapping("/jewelry/delete/{id}")
    public void deleteJewels(@PathVariable Long id){
        jewelService.deleteJewel(id);
    }
    @PostMapping("/jewelry/update/{id_modificar}")
    public Jewel update(@PathVariable Long id_modificar, @RequestBody Jewel jewelUpdate){
        return jewelService.update(id_modificar,jewelUpdate);
    }

}
