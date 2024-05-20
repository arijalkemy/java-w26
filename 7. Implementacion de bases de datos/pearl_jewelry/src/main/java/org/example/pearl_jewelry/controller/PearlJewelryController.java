package org.example.pearl_jewelry.controller;

import jakarta.validation.Valid;
import org.example.pearl_jewelry.dto.JewelDto;
import org.example.pearl_jewelry.dto.SuccessDto;
import org.example.pearl_jewelry.dto.UpdateDto;
import org.example.pearl_jewelry.service.interfaces.IJewelryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.constraints.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class PearlJewelryController {
    IJewelryService jewelryService;

    public PearlJewelryController(IJewelryService jewelryService) {
        this.jewelryService = jewelryService;
    }

    @PostMapping("/new")
    private ResponseEntity<SuccessDto> createJewel(@RequestBody @Valid JewelDto newJewel) {
        SuccessDto successDto = jewelryService.createJewel(newJewel);
        return ResponseEntity.status(HttpStatus.CREATED).body(successDto);
    }

    @GetMapping("")
    private ResponseEntity<List<JewelDto>> getJewelList() {
        List<JewelDto> jewelDtoList = jewelryService.getJewelList();
        return ResponseEntity.ok(jewelDtoList);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<SuccessDto> deleteJewel(
            @PathVariable @Positive Long id
    ) {
        SuccessDto successDto = jewelryService.deleteJewel(id);
        return ResponseEntity.ok(successDto);
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<UpdateDto> updateJewel(
            @PathVariable @Positive Long id,
            @RequestBody @Valid JewelDto updatedJewel
    ) {
        UpdateDto updateDto = jewelryService.updateJewel(id, updatedJewel);
        return ResponseEntity.ok(updateDto);
    }
}
