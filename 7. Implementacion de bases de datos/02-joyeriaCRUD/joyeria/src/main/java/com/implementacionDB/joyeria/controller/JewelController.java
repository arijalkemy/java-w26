package com.implementacionDB.joyeria.controller;

import com.implementacionDB.joyeria.dto.JewellResponseDTO;
import com.implementacionDB.joyeria.dto.request.JewelDTO;
import com.implementacionDB.joyeria.dto.MessageDTO;
import com.implementacionDB.joyeria.service.IJewelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jewerly")
public class JewelController {

    private final IJewelService jewelServ;

    @GetMapping()
    public ResponseEntity<List<JewellResponseDTO>> getAll(){
        List<JewellResponseDTO> listJewel = jewelServ.getAll();
        return ResponseEntity.ok().body(listJewel);
    }

    @GetMapping("/find")
    public ResponseEntity<JewellResponseDTO> getById(@RequestParam ("id") Long id){
        JewellResponseDTO jewel = jewelServ.getById(id);
        return ResponseEntity.ok().body(jewel);
    }

    @PostMapping("/new")
    public ResponseEntity<MessageDTO> addJewel(@RequestBody JewelDTO jewelDTO){
        MessageDTO response = jewelServ.addJewel(jewelDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MessageDTO> updateJewel(@PathVariable Long id,
                                                  @RequestBody JewelDTO jewelDTO){
        MessageDTO response = jewelServ.updateJewel(id, jewelDTO);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageDTO> deleteJewel(@PathVariable Long id){
        MessageDTO response = jewelServ.deleteJewel(id);
        return ResponseEntity.ok().body(response);
    }

}
