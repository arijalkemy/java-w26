package com.bootcamp.joyeria.controllers;

import com.bootcamp.joyeria.dtos.JewelRequestDTO;
import com.bootcamp.joyeria.dtos.JewelResponseDTO;
import com.bootcamp.joyeria.dtos.JewelUpdateDTO;
import com.bootcamp.joyeria.dtos.MessageResponseDTO;
import com.bootcamp.joyeria.services.IJewelService;
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
    public MessageResponseDTO postJewel(@RequestBody JewelRequestDTO jewelRequestDTO) {
        return jewelService.createJewel(jewelRequestDTO);
    }
    @GetMapping
    public List<JewelResponseDTO> getAllJewel(){
        return jewelService.getAllJewels();
    }

    @DeleteMapping("delete/{id}")
    public void deleteJewel(@PathVariable Long id){
        jewelService.deleteJewel(id);
    }
    @PutMapping("update/{id_modificar}")
    public MessageResponseDTO updateJewel(@PathVariable Long id_modificar,
                                          @RequestBody JewelUpdateDTO jewelUpdateDTO){
        return jewelService.updateJewel(id_modificar, jewelUpdateDTO);
    }
}
