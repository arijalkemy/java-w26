package org.example.joyas.controller;

import jakarta.websocket.server.PathParam;
import org.example.joyas.DTO.JewelRequestDTO;
import org.example.joyas.DTO.JewelResponseDTO;
import org.example.joyas.services.IJewelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewerly")
public class JewelController {

    @Autowired
    IJewelService jewelService;

    @PostMapping("/new")
    ResponseEntity<?> postNewJewel(@RequestBody JewelRequestDTO jewel){
        return new ResponseEntity<>(jewelService.createJewerly(jewel), HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<?> getAllJewels(){
        return new ResponseEntity<>(jewelService.listAll(),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteJewel(@PathVariable Long id){
        jewelService.deleteJewerlyById(id);
        return new ResponseEntity<>("Jewel with id:"+id+" was eliminated",HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<?> putJewel(@PathVariable Long id, @RequestBody JewelRequestDTO jewel){
        return new ResponseEntity<>(jewelService.updateById(id,jewel),HttpStatus.OK);
    }

}
