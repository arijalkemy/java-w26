package org.example.jewels.controller;

import jakarta.validation.Valid;
import org.example.jewels.dto.JewelDto;
import org.example.jewels.dto.SuccessDto;
import org.example.jewels.service.IJewelsService;
import org.example.jewels.service.JewelsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jewerly")
public class JewelsController {
    @Autowired
    IJewelsService service;

    @PostMapping("new")
    private ResponseEntity<SuccessDto> createJewel(@RequestBody @Valid JewelDto newJewel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createJewel(newJewel));
    }
}
