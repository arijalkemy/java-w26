package meli.bootcamp.jewelry.controller;

import lombok.RequiredArgsConstructor;
import meli.bootcamp.jewelry.dto.JewelRequestDTO;
import meli.bootcamp.jewelry.dto.JewelResponseDTO;
import meli.bootcamp.jewelry.service.IJewelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jewelry")
public class JewelryController {

    private final IJewelService jewelService;

    @PostMapping("/new")
    public ResponseEntity<Map<String, Long>> newJewel(@RequestBody JewelRequestDTO jewelRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(jewelService.saveJewel(jewelRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<JewelResponseDTO>> getJewels(){
        return ResponseEntity.status(HttpStatus.OK).body(jewelService.getJewels());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJewel(@PathVariable Long id){
        jewelService.deleteJewel(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<JewelResponseDTO> updateJewel(@PathVariable Long id, @RequestBody JewelRequestDTO jewelRequestDTO){
        return ResponseEntity.status(HttpStatus.OK).body(jewelService.updateJewel(id, jewelRequestDTO));
    }
}
