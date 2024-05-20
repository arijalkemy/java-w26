package com.bootcamp.joyeria.controllers;

import com.bootcamp.joyeria.dtos.JewelRequestDTO;
import com.bootcamp.joyeria.dtos.JewelResponseDTO;
import com.bootcamp.joyeria.dtos.JewelUpdateDTO;
import com.bootcamp.joyeria.dtos.MessageResponseDTO;
import com.bootcamp.joyeria.services.IJewelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JewelController {
    private final IJewelService jewelService;

    public JewelController(IJewelService jewelService) {
        this.jewelService = jewelService;
    }

    @PostMapping("/new")
    public ResponseEntity<MessageResponseDTO> postJewel(@RequestBody JewelRequestDTO jewelRequestDTO) {
        return ResponseEntity.ok(jewelService.createJewel(jewelRequestDTO));
    }
    @GetMapping
    public ResponseEntity<List<JewelResponseDTO>> getAllJewel(){
        return ResponseEntity.ok(jewelService.getAllJewels());
    }

    @DeleteMapping("delete/{id}")
    public void deleteJewel(@PathVariable Long id){
        jewelService.deleteJewel(id);
    }
    @PutMapping("update/{id_modificar}")
    public ResponseEntity<MessageResponseDTO> updateJewel(@PathVariable Long id_modificar,
                                          @RequestBody JewelUpdateDTO jewelUpdateDTO){
        return ResponseEntity.ok(jewelService.updateJewel(id_modificar, jewelUpdateDTO));
    }
}
